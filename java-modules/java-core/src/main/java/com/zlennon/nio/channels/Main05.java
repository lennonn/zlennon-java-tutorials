package com.zlennon.nio.channels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

/**
 *
 * @author Apress
 */
public class Main05 {

    public static void main(String[] args) {

        Path path = Paths.get("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal/tournaments", "HeinekenOpen.txt");        
        
        ByteBuffer copy = ByteBuffer.allocate(25);
        copy.put("\n".getBytes());
  
        try (SeekableByteChannel seekableByteChannel = (Files.newByteChannel(path, EnumSet.of(StandardOpenOption.READ, StandardOpenOption.WRITE)))) {

            int nbytes;
            do {
                nbytes = seekableByteChannel.read(copy);
            } while (nbytes != -1 && copy.hasRemaining());
            
            copy.flip();            
            
            seekableByteChannel.position(seekableByteChannel.size());
            while (copy.hasRemaining()) {
                seekableByteChannel.write(copy);
            }

            copy.clear();
            
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
