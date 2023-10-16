package com.zlennon.io.bytes.inputstream;

import java.io.*;

public class PushbackInputStreamTest {

        public static void main(String[] args) {
            String data = "Hello, World!";
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data.getBytes());

            try (PushbackInputStream pushbackInputStream = new PushbackInputStream(byteArrayInputStream, 1024)) {
                int bytesRead;
                while ((bytesRead = pushbackInputStream.read()) != -1) {
                    char c = (char) bytesRead;

                    // 如果读取到 'o' 字符，检查下一个字符是否是 'r'，如果是则推回 'o'
                    if (c == 'o') {
                        int nextByte = pushbackInputStream.read();
                        if (nextByte == 'r') {
                            pushbackInputStream.unread('o');
                        }
                        pushbackInputStream.unread(nextByte);
                    }

                    System.out.print(c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
