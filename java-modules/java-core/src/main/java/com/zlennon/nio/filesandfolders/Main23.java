package com.zlennon.nio.filesandfolders;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Apress
 */
public class Main23 {

    public static void main(String[] args) {

        Path movefrom = FileSystems.getDefault().getPath("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal/rafa_2.jpg");
        Path target = FileSystems.getDefault().getPath("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal/photos/rafa_2.jpg");
        Path target_dir = FileSystems.getDefault().getPath("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal/photos");

        //method 1
        try {
            Files.move(movefrom, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }

        //method 2 - using resolve
        try {
            Files.move(movefrom, target_dir.resolve(movefrom.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }

        //method 3 - using resolve to move and rename
        try {
            Files.move(target, target.resolveSibling("rafa_renamed_2.jpg"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
