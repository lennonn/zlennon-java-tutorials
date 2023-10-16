package com.zlennon.io.bytes.inputstream;

import java.io.*;

public class FilterInputStreamTest {
    public static void main(String[] args) {
        try (
                InputStream inputStream = FilterInputStreamTest.class.getClassLoader().getResourceAsStream("inputstream.txt");
                // 创建一个文件输入流
               // FileInputStream fileInputStream = new FileInputStream("inputstream.txt");
                // 使用 FilterInputStream 包装文件输入流
                FilterInputStream filterInputStream = new BufferedInputStream(inputStream);
        ) {


            if(filterInputStream.markSupported()) {
                filterInputStream.mark(0);
            }
            //跳过两字节
            long skippedBytes = filterInputStream.skip(2);
            // 读取数据并打印到控制台
            int data;
            while ((data = filterInputStream.read()) != -1) {
                System.out.print((char) data);
            }

            filterInputStream.reset();
            System.out.println("\n==========");
            int data1;
            while ((data1 = filterInputStream.read()) != -1) {
                System.out.print((char) data1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }

