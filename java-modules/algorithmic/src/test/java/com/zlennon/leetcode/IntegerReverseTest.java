package com.zlennon.leetcode;


import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegerReverseTest {
    int max=Integer.MAX_VALUE;
    int min=Integer.MIN_VALUE;

    @Test
    public void testReverse(){
       int rev1= IntegerReverse.reverse(123456);
       Assert.assertEquals(rev1,654321);
        int rev2= IntegerReverse.reverse(-123456);
        Assert.assertEquals(rev2,-654321);
        //2^31-1=2147483647,-2^31=-2147483648
        int max=2147483647;
        int min=-2147483648;
        int rev3= IntegerReverse.reverse(max);
        Assert.assertEquals(rev3,0);
        int rev4= IntegerReverse.reverse(min);
        Assert.assertEquals(rev4,0);
    }

    @Test
    public void testStringReverse(){
        int rev1= IntegerReverse.stringReverse(123456);
        Assert.assertEquals(rev1,654321);

        int rev2= IntegerReverse.stringReverse(-123456);
        Assert.assertEquals(rev2,-654321);

        int rev3= IntegerReverse.stringReverse(max);
        Assert.assertEquals(rev3,0);
        int rev4= IntegerReverse.stringReverse(min);
        Assert.assertEquals(rev4,0);
    }
}
