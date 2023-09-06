package com.zlennon.securityvul;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * XSS过滤处理
 */
public class SecurityHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public SecurityHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> requestMap = new HashMap<>(super.getParameterMap());
        if (requestMap != null && !requestMap.isEmpty()) {
            Iterator<Map.Entry<String, String[]>> it = requestMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String[]> me = it.next();
                String key = me.getKey();
                String s = StringEscapeUtils.escapeHtml4(key);
                if (!key.equals(s)) {
                    it.remove();
                }
                String[] values = me.getValue();
                for (int i = 0; i < values.length; i++) {
                    values[i] = escapeHtml(values[i]);
                }
            }
        }
        return requestMap;
    }

    @Override
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        if (values == null || values.length == 0) {
            return values;
        }

        int count = values.length;

        String[] encodedValues = new String[count];

        for (int i = 0; i < count; i++) {
            String str = values[i];
            encodedValues[i] = escapeHtml(str);
        }
        return encodedValues;

    }

    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return escapeHtml(value);
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return escapeHtml(value);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        // 非json类型，直接返回
        if (!isJsonRequest()) {
            return super.getInputStream();
        }
        String json = IOUtils.toString(super.getInputStream(), "utf-8");
        if (StringUtils.isBlank(json)) {
            return super.getInputStream();
        }
        json = StringEscapeUtils.escapeHtml4(json);
        json = json.replace("&quot;", "\"");
        final ByteArrayInputStream bis = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return true;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
            }

            @Override
            public int read() throws IOException {
                return bis.read();
            }
        };
    }

    /**
     * 是否是Json请求
     */
    private boolean isJsonRequest() {
        String header = super.getHeader("Content-Type");
        return MediaType.APPLICATION_JSON_VALUE.equalsIgnoreCase(header)
                || "application/json;charset=UTF-8".equalsIgnoreCase(header);
    }

    private String escapeHtml(String value) {
        if (!StringUtils.isBlank(value)) {
            value = StringEscapeUtils.escapeHtml4(value);
            if (value.contains("{")) {
                value = value.replace("&quot;", "\"");
            }
            return escapeSql(value);
        }
        return value;
    }

    public static String escapeSql(String str) {
        return str == null ? null : org.apache.commons.lang.StringUtils.replace(str, "'", "''");
    }

}