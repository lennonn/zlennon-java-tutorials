package com.zlennon.io.bytes.outputstream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamTest {
        public static void main(String[] args) {
            MyObject myObject = new MyObject("zlennon", 30);

            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
                // 序列化对象并将其写入文件
                objectOutputStream.writeObject(myObject);
                System.out.println("Object serialized and written to data.ser");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
