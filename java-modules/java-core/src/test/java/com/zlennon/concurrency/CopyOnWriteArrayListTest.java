package com.zlennon.concurrency;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.assertj.core.api.Assertions.assertThat;


public class CopyOnWriteArrayListTest {
    @Test
    public void testRemoveAll(){
        long n=((64 - 1) >> 6) + 1;
        System.out.println(n);
        CopyOnWriteArrayList<Integer> numbers =
                new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8,10});
        numbers.removeAll(Arrays.asList(3,8));
        assertThat(numbers.size()).isEqualTo(3);
    }
}
