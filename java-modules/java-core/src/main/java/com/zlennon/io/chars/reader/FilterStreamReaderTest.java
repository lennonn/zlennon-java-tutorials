package com.zlennon.io.chars.reader;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class FilterStreamReaderTest {
    static class UppercaseFilterReader extends FilterReader {
        protected UppercaseFilterReader(Reader in) {
            super(in);
        }

        @Override
        public int read() throws IOException {
            int c = super.read();
            if (c != -1) {
                // 将读取的字符转换为大写
                return Character.toUpperCase((char) c);
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        try (
                StringReader fileReader = new StringReader("abcdefg");
                UppercaseFilterReader uppercaseFilterReader = new UppercaseFilterReader(fileReader)
        ) {
            uppercaseFilterReader.skip(1);
            int data;
            while ((data = uppercaseFilterReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
