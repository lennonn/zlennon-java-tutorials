package com.zlennon.io.bytes.inputstream;

import java.io.IOException;
import java.io.StringBufferInputStream;

public class StringBufferInputStreamTest {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("Hello, World!");
        try (

                // 创建一个 StringBufferInputStream
                StringBufferInputStream inputStream = new StringBufferInputStream(stringBuffer.toString());

        ) {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

