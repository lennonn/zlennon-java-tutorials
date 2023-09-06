package com.zlennon.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PalindromeTest {

    @Test
   public void testIsPalindrome(){
        Palindrome palindrome =new Palindrome();
        Assert.assertEquals(palindrome.isPalindrome(121),true);
        Assert.assertEquals(palindrome.isPalindrome(-121),false);
        Assert.assertEquals(palindrome.isPalindrome(10),false);

        //方法二
        Assert.assertEquals(palindrome.isPalindrome2(4321),true);
        //Assert.assertEquals(palindrome.isPalindrome2(-121),false);
       // Assert.assertEquals(palindrome.isPalindrome2(10),false);

    }

}
