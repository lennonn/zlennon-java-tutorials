package com.zlennon.io.bytes.inputstream;

import com.zlennon.io.bytes.outputstream.MyObject;

import java.io.*;

public class ObjectInputStreamTest {
        public static void main(String[] args) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data.ser"))) {
                MyObject myObject = (MyObject) objectInputStream.readObject();
                System.out.println("Deserialized Object: " + myObject);
            } catch (IOException e) {
                System.err.println("IOException: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException: " + e.getMessage());
            }
        }

}

