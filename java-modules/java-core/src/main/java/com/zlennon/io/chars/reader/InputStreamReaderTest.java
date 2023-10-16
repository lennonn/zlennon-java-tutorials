package com.zlennon.io.chars.reader;

import java.io.FileInputStream;
import java.io.*;

public class InputStreamReaderTest {
    public static void main(String[] args) {
        try (
             InputStream fileInputStream = InputStreamReaderTest.class.getClassLoader().getResourceAsStream("inputStream.txt");

             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream)) {
            int data;
            char[] datas = new char[5];
            int charCount; // 用于跟踪实际读取的字符数
/*            CharArrayWriter charArrayWriter = new CharArrayWriter(100);
            inputStreamReader.transferTo(charArrayWriter);
            System.out.println(new String(charArrayWriter.toCharArray()));*/
            while ((charCount = inputStreamReader.read(datas)) != -1) {
                // 使用字符数组中的实际字符数来构建字符串
                String charData = new String(datas, 0, charCount);
                System.out.print(charData);
            }






/*            char[] datas = new char[100];
            int read = inputStreamReader.read(datas, 0, 100);
            System.out.println(String.valueOf(datas));*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
