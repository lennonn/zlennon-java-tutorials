package com.zlennon.nio.async;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 *
 * @author Apress
 */
public class Main01 {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.wrap("use AsynchronousFileChannel wirte content to file".getBytes());

        Path path = Paths.get("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal/tournaments", "CopaClaro.txt");
        try (AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE)) {

            Future<FileLock> featureLock = asynchronousFileChannel.lock();
            System.out.println("Waiting the file to be locked ...");
            FileLock lock = featureLock.get();
            //or, use shortcut
            //FileLock lock = asynchronousFileChannel.lock().get();
            
            if (lock.isValid()) {
                Future<Integer> featureWrite = asynchronousFileChannel.write(buffer, 0);
                System.out.println("Waiting the bytes to be written ...");
                int written = featureWrite.get();
                //or, use shorcut
                //int written = asynchronousFileChannel.write(buffer,0).get();

                System.out.println("I written " + written + " bytes into " + path.getFileName() + " locked file!");
                
                lock.release();
            }

        } catch (Exception ex) {
            System.err.println(ex);
        }

    }
}
