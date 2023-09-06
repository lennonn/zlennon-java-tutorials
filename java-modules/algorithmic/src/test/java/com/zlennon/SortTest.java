package com.zlennon;

import com.zl.test.TestNGListener;
import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.util.Arrays;

@Listeners({TestNGListener.class})
@Epic("回归测试")
@Feature("经典排序测试")
public class SortTest {
    public static  final  int size =10000;
   @Test()
    @Description("冒泡排序")
    @Step("第一步创建冒泡排序方法")
    @Link("https://www.baidu.com")
    @Story("这是一个 story..")
    public void testBubbleSort(){
        long start = System.currentTimeMillis();
        int arr[] =Sort.getRandomArr(size);
        int[] sorted= Sort.bubbleSort(arr);
        long end =System.currentTimeMillis();
        Assert.assertEquals(end,1);
        System.out.println("冒泡排序所用时间："+(end-start)+"ms"+ Arrays.toString(sorted));
    }

    @Test
    @Step("第二步创建选择排序方法")
    public void testSelectionSort(){
        long start = System.currentTimeMillis();
        int arr[] =Sort.getRandomArr(size);
        int[] sorted= Sort.selectionSort(arr);
        long end =System.currentTimeMillis();
        System.out.println("选择排序排序所用时间："+(end-start)+"ms"+ Arrays.toString(sorted));
    }

    @Test
    @Step("第三步创建插入排序方法")
    public void insertionSort(){
        long start = System.currentTimeMillis();
        int arr[] =Sort.getRandomArr(size);
        int[] sorted= Sort.insertionSort(arr);
        long end =System.currentTimeMillis();
        System.out.println("插入排序所用时间："+(end-start)+"ms"+ Arrays.toString(sorted));
    }

    @Test
    @Attachment
    public void shellSort(){
        long start = System.currentTimeMillis();
        int arr[] =Sort.getRandomArr(size);
        int[] sorted= Sort.shellSort(arr);
        long end =System.currentTimeMillis();
        System.out.println("希尔排序所用时间："+(end-start)+"ms"+ Arrays.toString(sorted));
    }

    @Test
    public void mergeSort(){
        long start = System.currentTimeMillis();
        //int arr[] =Sort.getRandomArr(size);
        int arr[]=new int[]{10,8,2,9,6,1};
        int[] sorted= Sort.mergeSort(arr,0,arr.length-1);
        long end =System.currentTimeMillis();
        System.out.println("归并排序所用时间："+(end-start)+"ms"+ Arrays.toString(sorted));
    }



    @Test
    @Link("https://www.baidu.com")
    @Link(name = "allure", type = "mylink")
    public void quickSort(){
        long start = System.currentTimeMillis();
        int arr[] =Sort.getRandomArr(size);
        int[] sorted= Sort.quickSort(arr,0,arr.length-1);
        long end =System.currentTimeMillis();
        System.out.println("快速排序所用时间："+(end-start)+"ms"+ Arrays.toString(sorted));
    }

    @Test
    @Story("java堆排序测试")
    public void heapSort(){
        long start = System.currentTimeMillis();
        int arr[] =Sort.getRandomArr(size);
        int[] sorted= Sort.heapSort(arr);
        long end =System.currentTimeMillis();
        System.out.println("堆排序所用时间："+(end-start)+"ms"+ Arrays.toString(sorted));
    }
}
