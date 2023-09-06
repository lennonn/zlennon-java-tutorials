package com.zlennon.springymal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class SpringYmalApplication implements CommandLineRunner {

    @Autowired
    StringType stringtype;


    @Autowired
    YmalMap ymalMap;

    @Autowired
    YmalMapTwo ymalMapTwo;

    @Autowired
    YmalToList ymalToList;

    @Autowired
    YmalToArray ymalToArray;

    public static void main(String[] args) {
        SpringApplication.run(SpringYmalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("language==>>"+stringtype);

        Map<String, String> application = ymalMap.getMaps();

        System.out.println(ymalMapTwo.getSystems().toString());


        System.out.println(ymalMap.getMaps().toString());
        System.out.println(ymalMap.getUsers().toString());

        System.out.println(ymalToList.getInclude().toString());
        System.out.println(ymalToList.getUserlist().toString());
        System.out.println(ymalToArray.getUserlist().toString());
    }
}
