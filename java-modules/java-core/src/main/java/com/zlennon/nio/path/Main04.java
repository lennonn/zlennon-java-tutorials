package com.zlennon.nio.path;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Apress
 */
public class Main04 {

    public static void main(String[] args) {             

        //define the fix path
        Path base_1 = Paths.get("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal/tournaments");
        Path base_2 = Paths.get("D:/IdeaProject/zlennon-java-tutorials/java-modules/java-core/src/main/resources/rafaelnadal/tournaments/BNP.txt");

        //resolve BNP.txt file
        Path path_1 = base_1.resolve("BNP.txt");
        System.out.println(path_1.toString());

        //resolve AEGON.txt file
        Path path_2 = base_1.resolve("AEGON.txt");
        System.out.println(path_2.toString());
        
        //resolve sibling AEGON.txt file
        Path path_3 = base_2.resolveSibling("AEGON.txt");
        System.out.println(path_3.toString());
    }

}
