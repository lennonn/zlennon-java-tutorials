package com.zlennon;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );

        FileUtilsDemo fileUtilsDemo = new FileUtilsDemo();
        fileUtilsDemo.testFileUtils();
    }
}
