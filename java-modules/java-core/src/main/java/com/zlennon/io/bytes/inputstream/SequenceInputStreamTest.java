package com.zlennon.io.bytes.inputstream;

import java.io.*;

public class SequenceInputStreamTest {
    public static void main(String[] args) {
        try (
                // 创建两个文件输入流
                InputStream input1 = SequenceInputStreamTest.class.getClassLoader().getResourceAsStream("seq1.txt");
                InputStream input2 = SequenceInputStreamTest.class.getClassLoader().getResourceAsStream("seq2.txt");

                // 创建 SequenceInputStream，将两个输入流连接在一起
                SequenceInputStream sequenceInputStream = new SequenceInputStream(input1, input2);
        ) {
            // 读取数据并打印到控制台
            int data;
            while ((data = sequenceInputStream.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }

