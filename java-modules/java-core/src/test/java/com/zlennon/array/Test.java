package com.zlennon.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Test {
    public void test() {
        int[][] arr = {{0, 0, 0}, {1, 0, 0}, {2, 2, 3}, {3, 2, 3}, {4, 0, 0}, {5, 2, 3}, {6, 0, 0}};

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] num1, int[] num2) {
                return num2[1] - num1[1];
            }
        });
        for (int[] s : arr) {
            System.out.println(Arrays.toString(s));
        }
    }

    public int searchArrayItem(int[] nums, int key) {
/*        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key)
                return i;
        }
        return -1;*/

        int len = nums.length;
        return IntStream.range(0, len)
                .filter(i -> key== nums[i])
                .findFirst()
                .orElse(-1);
    }

    @org.junit.Test
    public void testArray() {
        int nums[] = new int[]{1, 5, 8, 2, 23, 435};
        int result = searchArrayItem(nums, 23);
        System.out.println(result);
    }


}
