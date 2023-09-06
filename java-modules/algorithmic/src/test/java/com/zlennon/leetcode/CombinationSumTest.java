package com.zlennon.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CombinationSumTest {
    @Test
    public void testCombinationSum(){
        CombinationSum cs =new CombinationSum();
        int nums[]=new int[]{2,3,6,7};
        List<List<Integer>> lists= cs.combinationSum(nums,8);
        for(List<Integer> list:lists){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }


    @Test
    public void testCombinationSum2(){
        CombinationSum cs =new CombinationSum();
        //int nums[]=new int[]{10,1,2,7,6,1,5};
        int nums[]=new int[]{1,7,1};

        List<List<Integer>> lists= cs.combinationSum2(nums,8);
        for(List<Integer> list:lists){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

}
