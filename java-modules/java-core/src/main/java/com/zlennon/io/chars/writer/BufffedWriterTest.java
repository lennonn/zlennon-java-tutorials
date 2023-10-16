package com.zlennon.io.chars.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufffedWriterTest {
    public static void main(String[] args) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"))) {
            // 写入文本数据到文件
            bufferedWriter.write("Hello, World!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
