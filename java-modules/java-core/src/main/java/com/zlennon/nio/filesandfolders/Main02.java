package com.zlennon.nio.filesandfolders;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

/**
 *
 * @author Apress
 */
public class Main02 {

    public static void main(String[] args) {

        Path path = FileSystems.getDefault().getPath("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal/tournaments", "AEGON.txt");

        boolean path_exists = Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        boolean path_notexists = Files.notExists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});

        System.out.println("Exists? " + path_exists + "  Not exists? " + path_notexists);             
    }
}
