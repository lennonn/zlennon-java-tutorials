package com.zlennon.string;

import java.util.Arrays;

public class TestAllLists {
    public static String[] getAllLists(String[] elements, int lengthOfList)
    {
        //initialize our returned list with the number of elements calculated above
        String[] allLists = new String[(int)Math.pow(elements.length, lengthOfList)];

        //lists of length 1 are just the original elements
        if(lengthOfList == 1) return elements;
        else
        {
            //the recursion--get all lists of length 3, length 2, all the way up to 1
            String[] allSublists = getAllLists(elements, lengthOfList - 1);

            //append the sublists to each element
            int arrayIndex = 0;

            for(int i = 0; i < elements.length; i++)
            {
                for(int j = 0; j < allSublists.length; j++)
                {
                    //add the newly appended combination to the list
                    allLists[arrayIndex] = elements[i] + allSublists[j];
                    arrayIndex++;
                }
            }

            return allLists;
        }
    }

    public static void main(String... args){
        String s[] ={"A1","A2","B1","B2","C1","C2","D1","D2"};
        String[] result=getAllLists(s,s.length);
        System.out.println(result.length);
        System.out.println(Arrays.deepToString(result));
    }

}