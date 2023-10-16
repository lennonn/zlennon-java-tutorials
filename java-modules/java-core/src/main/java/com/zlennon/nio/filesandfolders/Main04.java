package com.zlennon.nio.filesandfolders;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Apress
 */
public class Main04 {

    public static void main(String[] args) {

        Path path = FileSystems.getDefault().getPath("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal/tournaments", "MutuaMadridOpen.txt");

        //is hidden ?
        try {
            boolean is_hidden = Files.isHidden(path);
            System.out.println("Is hidden ? " + is_hidden);
        } catch (IOException e) {
            System.err.println(e);
        }      
    }
}
