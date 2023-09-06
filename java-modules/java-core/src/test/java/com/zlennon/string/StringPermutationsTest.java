package com.zlennon.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationsTest {
    @Test
    public void permutiationTest(){
        StringPermutations.permutation("AAB");
        List permSet = StringPermutations.permSet;
        permSet.forEach(System.out::println);
    }

    @Test
    public void permutationArrayTest() {

        int nums[] = new int[]{3, 5, 6};
        // 定义结果集
        List<List<Integer>> result = new ArrayList<>();
        // 边界条件，当数组为空时返回空集
        if (nums == null || nums.length == 0) {
            //return result;
        }
        // 初始化结果集，加入空集
        result.add(new ArrayList<>());

        // 遍历数组，求全排列
        for (int i = 0; i < nums.length; i++) {
            // 获取当前数字
            int num = nums[i];
            // 定义临时集合，用于存储当前数字的全排列
            List<List<Integer>> temp = new ArrayList<>();
            // 遍历结果集，求全排列
            for (List<Integer> list : result) {
                // 遍历结果集中的每一个全排列，将当前数字插入到合法的位置
                for (int j = 0; j <= list.size(); j++) {
                    // 复制当前全排列
                    List<Integer> newList = new ArrayList<>(list);
                    // 将当前数字插入到合法的位置
                    newList.add(j, num);
                    // 将新的全排列加入到临时集合中
                    temp.add(newList);
                }
            }
            // 将临时集合更新为结果集
            System.out.println(result.toString());
        }
    }
    }