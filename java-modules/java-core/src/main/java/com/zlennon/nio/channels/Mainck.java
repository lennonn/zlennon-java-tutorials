package com.zlennon.nio.channels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

/**
 *
 * @author Apress
 */
public class Mainck {

    public static void main(String[] args) {

        Path path = Paths.get("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal/email", "vamos.txt");
        ByteBuffer buffer = ByteBuffer.wrap("Hai Hanescu !".getBytes());

        try (FileChannel fileChannel = (FileChannel.open(path, EnumSet.of(StandardOpenOption.READ, StandardOpenOption.WRITE)))) {

            fileChannel.position(0);
            fileChannel.write(buffer);

        } catch (IOException ex) {
            System.err.println(ex);
        }

    }
}
