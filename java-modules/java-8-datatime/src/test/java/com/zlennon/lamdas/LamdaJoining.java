package com.zlennon.lamdas;

import com.zlennon.Joining;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LamdaJoining {

    @Test
    public void testArrayJoining(){
        String[]  helloWorld = new String[]{"H","e","l","l","o"," ","W","o","r","l","d","!"};
        System.out.println(Joining.ArrayJoin(helloWorld));
    }

    @Test
    public void testListJoining(){
        List<String> helloWorld = Arrays.asList("H","e","l","l","o"," ","W","o","r","l","d","!");
        System.out.println(Joining.ListJoin(helloWorld));
    }

    @Test
    public void testCharSequenceJoining(){
        List<CharSequence> helloWorld = Arrays.asList("H","e","l","l","o"," ","W","o","r","l","d","!");
        System.out.println(Joining.CharJoin(helloWorld));
    }
}
