package com.zlennon;

import org.testng.TestListenerAdapter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class TestNGListener extends TestListenerAdapter {
    public static void main(String[] args) throws InterruptedException {
        LocalDate start = LocalDate.of(2022, 11, 01);
        LocalDate end = LocalDate.of(2022, 11, 17);
        LocalDate now = LocalDate.now();
        if(now.compareTo(start)>=0&&now.compareTo(end)<=0){
            Thread life=  new Thread(() -> {
                List<String> items = Arrays.asList("看长津湖,感受革命先辈的峥嵘岁月", "看NBA",
                        "玩王者荣耀", "刷头条", "刷抖音","看书");
                Random random = new Random();
                System.out.println(items.get(random.nextInt(items.size())));
            },"life");
            Thread work=  new Thread(() -> {
                System.out.println("值班,保证线上服务质量");
            },"work");
            life.start();
            life.join();
            work.start();
            //work.join();
        }else {
            System.out.println("努力搬砖");
        }
    }
}
