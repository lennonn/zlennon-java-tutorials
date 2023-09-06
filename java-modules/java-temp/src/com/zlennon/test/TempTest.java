package com.zlennon.test;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.util.Arrays;

public class TempTest {
    public static void main(String[] args) {
        String str="1920*800";
        String[] split = str.split("\\*");
        System.out.println(split[0]+"=="+split[1]+"");

        String json="{\n" +
                "    \"outParam\":{\n" +
                "        \"resolution\":\"1920*1000\",\n" +
                "        \"framerate\":15,\n" +
                "        \"bitrate\":6000\n" +
                "    },\n" +
                "    \"streamLayout\":{\n" +
                "        \"stream1\":{\n" +
                "            \"loc_y\":20,\n" +
                "            \"height\":900,\n" +
                "            \"loc_x\":20,\n" +
                "            \"width\":300,\n" +
                "            \"locX\":20,\n" +
                "            \"locY\":20\n" +
                "        },\n" +
                "        \"stream2\":{\n" +
                "            \"loc_y\":20,\n" +
                "            \"height\":900,\n" +
                "            \"loc_x\":100,\n" +
                "            \"width\":300,\n" +
                "            \"locX\":350,\n" +
                "            \"locY\":20\n" +
                "        }\n" +
                "    },\n" +
                "    \"watermark\":{\n" +
                "        \"text\":{\n" +
                "            \"text\":\"测试\",\n" +
                "            \"loc_x\":\"距离左上角x轴的为位置 如：10\",\n" +
                "            \"loc_y\":\"距离左上角x轴的为位置\",\n" +
                "            \"color\":\"文本水印的颜色\",\n" +
                "            \"locX\":\"2\",\n" +
                "            \"locY\":\"2\"\n" +
                "        },\n" +
                "        \"date\":{\n" +
                "            \"loc_x\":\"距离左上角x轴的为位置\",\n" +
                "            \"loc_y\":\"距离左上角x轴的为位置\",\n" +
                "            \"color\":\"文本水印的颜色\",\n" +
                "            \"locX\":\"2\",\n" +
                "            \"locY\":\"2\"\n" +
                "        },\n" +
                "        \"picture\":{\n" +
                "            \"loc_x\":\"距离左上角x轴的为位置\",\n" +
                "            \"loc_y\":\"距离左上角x轴的为位置\",\n" +
                "            \"alpha\":76,\n" +
                "            \"pic_url\":\"图片地址\",\n" +
                "            \"locX\":\"2\",\n" +
                "            \"locY\":\"2\",\n" +
                "            \"picUrl\":\"http://www.baidu.com\"\n" +
                "        },\n" +
                "        \"device\":\"TELLER,CUSTOMER\"\n" +
                "    }\n" +
                "}";

        JSONObject jsons = JSONObject.parseObject(json);
        JSONObject streamLayout = jsons.getJSONObject("streamLayout");
        JSONObject layoutParams = new JSONObject();
        JSONArray inputStreamList = new JSONArray();

        for (int i = 0; i < 2; i++) {
            JSONObject jsonObject = streamLayout.getJSONObject("stream" + (i + 1));
            layoutParams.put("top", jsonObject.get("locY"));
            layoutParams.put("left", jsonObject.get("locX"));
            layoutParams.put("bottom", jsonObject.get("height"));
            //01为0；23为0.5
            layoutParams.put("right", jsonObject.get("width"));
            inputStreamList.add(layoutParams);
        }
        System.out.println(inputStreamList.toJSONString());
    }
}
