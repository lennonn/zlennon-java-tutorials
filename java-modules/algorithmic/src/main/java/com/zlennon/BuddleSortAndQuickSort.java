package com.zlennon;

import java.util.Date;

public class BuddleSortAndQuickSort {
	public void buddleSort(int num[]) {
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] > num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		for (int k = 0; k < num.length; k++) {
			System.out.println(num[k]);
		}
	}

	public void quickSort(int num[], int low, int high) {
		if (low < high) {
			// Swap(s[l], s[(l + r) / 2]); //���м��������͵�һ�������� �μ�ע1
			int i = low, j = high, x = num[low];
			while (i < j) {
				while (i < j && num[j] >= x) // ���������ҵ�һ��С��x����
					j--;
				if (i < j)
					num[i++] = num[j];

				while (i < j && num[i] < x) // ���������ҵ�һ�����ڵ���x����
					i++;
				if (i < j)
					num[j--] = num[i];
			}
			num[i] = x;
			quickSort(num, low, i - 1); // �ݹ����
			quickSort(num, i + 1, high);
		}

	}
/*//	public static void main(String[] args){
//	    int[] a={2,4,6,8,3,6,9,12};
//	    doSomething(a,0,a.length-1);
//	    for(int i=0;i<=a.length-1;i++)
//	    System.out.print(a[i]+�� ��);
//	}
//	private static void doSomething(int[] a,int start,int end){
//	    if(start<end){
//	        int p=core(a,start,end);
//	        doSomething(a,start,p-1);
//	        doSomething(a,p+1,end);
//	    }
//	}
//	private static int core(int[] a,int start,int end)
//	{
//	    int x=a[end];
//	    int i=start;
//	    for(int j=start;j<=end-1;j++){
//	        if(a[j]>=x){
//	            swap(a,i,j);
//	            i++;//�����˼���
//	        }
//	    }//�����ķŵ����
//	    swap(a,i,end);//�����ķŵ�i��λ��
//	    return i;
//	}
//
//	private static void swap(int[] a,inti,int j)
//	{
//	    int tmp=a[i];
//	    a[i]=a[j];
//	    a[j]=tmp;
//	}
//	}
//}
*/	public static void main(String args[]) {
		int num[] = { 10, 3, 8, 20, 100, 30, 50, 2, 80, 90 };
		BuddleSortAndQuickSort buddleSortnumndQuickSort = new BuddleSortAndQuickSort();

	    Date start = new Date();
	    System.out.println(start);
		buddleSortnumndQuickSort.quickSort(num, 0, 9);
		//buddleSortnumndQuickSort.buddleSort(num);
		Date enDate =new Date();
		for(int k=0;k<num.length;k++){
			System.out.println(num[k]);
		}
	}
}
