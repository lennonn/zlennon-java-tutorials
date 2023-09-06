package com.zlennon;

import com.zlennon.extend.BlankCat;
import com.zlennon.extend.Cat;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListConvet {
    @Test
    public void test(){
        List<BlankCat> blankCatList =new ArrayList<BlankCat>();
        BlankCat bc1= new BlankCat();
        bc1.setColor("blank");
        bc1.setName("Bill");
        bc1.setWeight("10");
        BlankCat bc2= new BlankCat();
        bc2.setColor("blank");
        bc2.setName("Mark");
        bc2.setWeight("12");
        blankCatList.add(bc1);
        blankCatList.add(bc2);
/*        List<? extends Cat> cats =blankCatList;
        Animal animal = new Animal(blankCatList);
        List<? extends Cat> genericCats= animal.getCats();
        for(Cat cat:genericCats){
            System.out.println(cat.getName());
        }*/
        List<Cat> allCats = new ArrayList<Cat>();

        List<Cat> a=new ArrayList<Cat>(blankCatList);
    }

}
