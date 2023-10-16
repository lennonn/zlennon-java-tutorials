package com.zlennon.io.bytes.inputstream;

import java.io.IOException;
import java.io.*;

public class PipedInputStreamTest {

        public static void main(String[] args) {
            try (
                    PipedInputStream pipedInputStream = new PipedInputStream();
                    PipedOutputStream pipedOutputStream = new PipedOutputStream()
            ) {
                // 将输入流和输出流连接在一起
                pipedInputStream.connect(pipedOutputStream);

                // 创建并启动写入线程
                Thread writerThread = new Thread(new Writer(pipedOutputStream));
                writerThread.start();

                // 在主线程中读取数据
                int data;
                while ((data = pipedInputStream.read()) != -1) {
                    System.out.print((char) data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class Writer implements Runnable {
        private PipedOutputStream pipedOutputStream;

        public Writer(PipedOutputStream pipedOutputStream) {
            this.pipedOutputStream = pipedOutputStream;
        }

        @Override
        public void run() {
            try {
                // 向管道输出流写入数据
                String message = "Hello, Pipe!";
                pipedOutputStream.write(message.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

