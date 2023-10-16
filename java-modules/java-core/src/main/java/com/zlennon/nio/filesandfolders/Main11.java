package com.zlennon.nio.filesandfolders;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Apress
 */
public class Main11 {

    public static void main(String[] args) {

        Path basedir = FileSystems.getDefault().getPath("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal/tmp/");
        String tmp_dir_prefix = "rafa_";

        //get the default temporary folders path
        String default_tmp = System.getProperty("java.io.tmpdir");
        System.out.println(default_tmp);

        try {
            //passing null prefix
            Path tmp_1 = Files.createTempDirectory(null);
            System.out.println("TMP: " + tmp_1.toString());
            //set a prefix
            Path tmp_2 = Files.createTempDirectory(tmp_dir_prefix);
            System.out.println("TMP: " + tmp_2.toString());
            //create a tmp directory in a the base dir
            Path tmp_3 = Files.createTempDirectory(basedir, tmp_dir_prefix);
            System.out.println("TMP: " + tmp_3.toString());
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
