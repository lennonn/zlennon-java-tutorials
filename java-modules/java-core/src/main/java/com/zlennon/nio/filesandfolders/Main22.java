package com.zlennon.nio.filesandfolders;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Apress
 */
public class Main22 {

    public static void main(String[] args) {
        
        Path basedir = FileSystems.getDefault().getPath("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal/tmp");
        String tmp_file_prefix = "rafa_";
        String tmp_file_sufix = ".txt";

        try {
            final Path tmp_file = Files.createTempFile(basedir, tmp_file_prefix, tmp_file_sufix);

           File asFile = tmp_file.toFile();
            asFile.deleteOnExit();

            //simulate some operations with temp file until delete it            
            Thread.sleep(10000);
            //operations done

        } catch (IOException | InterruptedException e) {
            System.err.println(e);
        }        
    }
}
