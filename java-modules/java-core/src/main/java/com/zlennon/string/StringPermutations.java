package com.zlennon.string;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations<T> {

    public static List permSet = new ArrayList<>();

    public static void permutation(String input){
        repetPermutaion("",input);
    }

/*    private static void permutation(String perm, String word) {
        if(word.isEmpty()){
            //System.out.println(perm+word);
            permSet.add(perm);
        }else{
            for(int noMore =0;noMore<=1;noMore++) {
                if(noMore==0) {
                    for (int i = 0; i < word.length(); i++) {
                        permutation(perm + word.charAt(i),
                                word.substring(0, i) + word.substring(i + 1, word.length()));
                    }
                }else{
                    permutation(perm,"");
                }
            }
        }
    }*/

    private  static void repetPermutaion(String perm,String word){
        if(word.equals("")){
            System.out.println(perm);
        }else {
            int a[] = new int[256];
            for(int noMore =0;noMore<=1;noMore++) {
                if(noMore==0) {
                    for (int i = 0; i < word.length(); i++) {
                        if(a[word.charAt(i)]==0){
                            a[word.charAt(i)]=1;
                            repetPermutaion(perm + word.charAt(i),
                                    word.substring(0, i) + word.substring(i + 1, word.length()));
                        }
                    }
                }else{
                    repetPermutaion(perm,"");
                }
            }
        }

    }

}
