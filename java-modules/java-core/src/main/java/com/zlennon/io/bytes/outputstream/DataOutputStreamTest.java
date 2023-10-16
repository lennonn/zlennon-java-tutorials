package com.zlennon.io.bytes.outputstream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamTest {
        public static void main(String[] args) {
            // 文件路径，可以根据项目结构进行调整
            String filePath = "data.dat";

            try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filePath))) {
                // 写入整数、双精度浮点数、布尔值和字符串
                dataOutputStream.writeInt(42);
                dataOutputStream.writeDouble(3.14);
                dataOutputStream.writeBoolean(true);
                dataOutputStream.writeUTF("Hello, Data!");

                System.out.println("Data written to " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
