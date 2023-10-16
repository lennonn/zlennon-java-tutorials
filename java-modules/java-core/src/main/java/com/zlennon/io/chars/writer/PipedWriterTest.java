package com.zlennon.io.chars.writer;


import java.io.*;

public class PipedWriterTest {
        public static void main(String[] args) {
            try {
                // 创建PipedWriter和对应的PipedReader
                PipedWriter pipedWriter = new PipedWriter();
                PipedReader pipedReader = new PipedReader(pipedWriter);

                // 创建一个线程来写入数据到PipedWriter
                Thread writerThread = new Thread(() -> {
                    try {
                        pipedWriter.write("Hello, PipedWriter!");
                        Thread.sleep(2000);
                        pipedWriter.write("after sleep");

                        pipedWriter.close(); // 关闭PipedWriter
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

                // 创建一个线程来读取数据从PipedReader
                Thread readerThread = new Thread(() -> {
                    try {
                        int data;
                        while ((data = pipedReader.read()) != -1) {
                            System.out.print((char) data);
                        }
                        pipedReader.close(); // 关闭PipedReader
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                // 启动线程
                writerThread.start();
                readerThread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
