package com.zlennon.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
       LOGGER.info("测试给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。");
        TwoSum twoSum = new TwoSum();
        int[] nums =new int[]{2, 11, 15, 7};
        int [] res=twoSum.twoSum2(nums,9);
       LOGGER.info("输入："+ Arrays.toString(nums)+", "+9+" ==>输出："+Arrays.toString(res));
    }
}
