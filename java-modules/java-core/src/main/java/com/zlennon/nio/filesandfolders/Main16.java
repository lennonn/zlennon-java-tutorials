package com.zlennon.nio.filesandfolders;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author Apress
 */
public class Main16 {

    public static void main(String[] args) {

        Path wiki_path = Paths.get("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal/wiki", "wiki.txt");

        Charset charset = Charset.forName("UTF-8");
        String text = "\nVamos Rafa!";
        try (BufferedWriter writer = Files.newBufferedWriter(wiki_path, charset, StandardOpenOption.APPEND)) {
            writer.write(text);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
