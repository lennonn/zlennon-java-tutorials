package com.zlennon;



public class FibonacciSequence {
	//(n-1)+n=(n+1);
	public static long fid(int n){
		if((n==1)||(n==2)){
			return 1;
		}
		else{
			return fid(n-1)+fid(n-2); //�ݹ����
		}
	}

	public static void prinSum(int n){
		long sum=0L;
		for(int i=1;i<=n;i++){
			sum+=fid(i);     //���
			//System.out.println(fid(i));
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
	FibonacciSequence.prinSum(100);;
	}

}
