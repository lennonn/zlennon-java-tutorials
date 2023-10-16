package com.zlennon.nio.filesandfolders;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Apress
 */
public class Main20 {

    public static void main(String[] args) {
        
        Path basedir = FileSystems.getDefault().getPath("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal/tmp");
        String tmp_file_prefix = "rafa_";
        String tmp_file_sufix=".txt";

        //get the default temporary folders path
        String default_tmp = System.getProperty("java.io.tmpdir");
        System.out.println(default_tmp);

        try {
            //passing null prefix/sufix
            Path tmp_1 = Files.createTempFile(null,null);
            System.out.println("TMP: " + tmp_1.toString());
            //set a prefix and a sufix
            Path tmp_2 = Files.createTempFile(tmp_file_prefix, tmp_file_sufix);
            System.out.println("TMP: " + tmp_2.toString());
            //create a tmp file in a the base dir
            Path tmp_3 = Files.createTempFile(basedir, tmp_file_prefix, tmp_file_sufix);
            System.out.println("TMP: " + tmp_3.toString());
        } catch (IOException e) {
            System.err.println(e);
        }
        
    }
}
