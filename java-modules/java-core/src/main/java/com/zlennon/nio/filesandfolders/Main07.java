package com.zlennon.nio.filesandfolders;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author apress
 */
public class Main07 {

    public static void main(String[] args) {

        Path path_1 = FileSystems.getDefault().getPath("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal/tournaments", "MutuaMadridOpen.txt");
        Path path_2 = FileSystems.getDefault().getPath("/rafaelnadal/tournaments", "MutuaMadridOpen.txt"); 
        Path path_3 = FileSystems.getDefault().getPath("/rafaelnadal/tournaments/dummy/../2009", "MutuaMadridOpen.txt"); 

        try {
            boolean is_same_file_12 = Files.isSameFile(path_1, path_2);
            boolean is_same_file_13 = Files.isSameFile(path_1, path_3);
            boolean is_same_file_23 = Files.isSameFile(path_2, path_3);
            System.out.println("is same file 1&2 ? " + is_same_file_12);
            System.out.println("is same file 1&3 ? " + is_same_file_13);
            System.out.println("is same file 2&3 ? " + is_same_file_23);
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
