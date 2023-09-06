package com.zlennon.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
public class HttpURLDownload {
    private static final String ACCEPT = "Accept";
    private static final String RANGE = "Range";
    private static String accept = "*/*";
    public static  int download(String urlPath, String outPath){
        int result = 0;
        RandomAccessFile oSavedFile = null;
        InputStream in = null;

        try {
            HttpURLConnection conn = getConnection(urlPath);
            int contentLen = conn.getContentLength();

            File outFile = mkFile(outPath);
            long fileLen = outFile.length();
            if (contentLen > fileLen||(contentLen==-1&&fileLen==0)) {
                conn = getConnection(urlPath);
                conn.setRequestProperty(RANGE, "bytes=" + fileLen + "-");
                in = conn.getInputStream();
                oSavedFile = new RandomAccessFile(outPath, "rw");
                oSavedFile.seek(fileLen);
                byte[] b = new byte[4096 * 1024];
                int nRead;
                int k=1;
                while ((nRead = in.read(b, 0, 204800)) > 0) {
                    System.out.println("have read:"+(204800*k)/1024+" kb");
                    oSavedFile.write(b, 0, nRead);
                    k++;
                }
            }
            if (contentLen != -1) {
                result = contentLen;
            }
        } catch (IOException e) {
            log.error("file path:" + outPath + "\ndownload url:" + urlPath + "_ERROR:", e);
        } finally {
            try {
                if (oSavedFile != null) {
                    oSavedFile.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    private static HttpURLConnection getConnection(String urlPath) throws IOException {
        HttpURLConnection conn = null;
        // 设定连接的相关参数
        URL url = new URL(urlPath);
        conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(30000000);
        conn.setReadTimeout(300000000);
        conn.setRequestMethod("GET");
        //conn.setRequestProperty("Accept-Encoding", "identity");
        //conn.setRequestProperty("Content-length", Integer.MAX_VALUE+"");
        conn.setDoOutput(true);
       // conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        //conn.setRequestProperty(ACCEPT, accept);
        return conn;
    }

    public static File mkFile(String outPath) {
        File file = new File(outPath);
        if (file.isDirectory()) {
            if (!file.exists()) {
                file.mkdirs();
            }
        } else {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
        }
        return file;
    }
}
