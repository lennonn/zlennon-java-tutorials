package fv_09;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.util.EnumSet;

/**
 *
 * @author Apress
 */
class ListTree extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {

        System.out.println("Visited directory: " + dir.toString());

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {

        System.out.println(exc);

        return FileVisitResult.CONTINUE;
    }
}

public class Main09 {

    public static void main(String[] args) throws IOException {

        Path listDir = Paths.get("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal");
        ListTree walk = new ListTree();
        EnumSet opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        Files.walkFileTree(listDir, opts, Integer.MAX_VALUE, walk);

    }
}
