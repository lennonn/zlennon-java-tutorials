package com.zlennon.nio.path;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Apress
 */
public class Main07 {

    public static void main(String[] args) {

        Path path = Paths.get("C:", "rafaelnadal/tournaments", "BNP.txt");

        for (Path name : path) {
            System.out.println(name);
        }
    }
}
