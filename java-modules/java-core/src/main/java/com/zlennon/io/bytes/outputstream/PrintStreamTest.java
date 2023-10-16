package com.zlennon.io.bytes.outputstream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {
        public static void main(String[] args) {
            try (PrintStream printStream = new PrintStream(new FileOutputStream("output.txt"))) {
                // 使用 print 方法将文本写入文件
                printStream.print("This is some text.");
                printStream.print("Another line of text.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
