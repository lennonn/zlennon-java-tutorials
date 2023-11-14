package com.zlennon.io.bytes.inputstream;

import java.io.IOException;
import java.io.*;
import java.net.URL;

public class DataInputStreamTest {
        public static void main(String[] args) {
            try (
                    //InputStream origin = new URL("").openStream();
                    InputStream stream= DataInputStreamTest.class.getClassLoader().getResourceAsStream("data.dat");
                    DataInputStream dataInputStream = new DataInputStream(stream);
            ) {
                int intValue = dataInputStream.readInt();
                double doubleValue = dataInputStream.readDouble();
                boolean booleanValue = dataInputStream.readBoolean();
                String stringValue = dataInputStream.readUTF();

                System.out.println("Int Value: " + intValue);
                System.out.println("Double Value: " + doubleValue);
                System.out.println("Boolean Value: " + booleanValue);
                System.out.println("String Value: " + stringValue);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}

