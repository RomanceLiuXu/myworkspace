package com.liuxu.review;

public class MyReview {

	public static void main(String[] args) {
		//去重
//	String string = "aabbcdfrgg";
//	
//	//用来后面便于拼接
//	String result = "";
//	for(int i = 0 ; i < string.length();i++){
//	char c = string.charAt(i);
//	int index = result.indexOf(c);
//	if (index == -1){
//		
//		result = result + c;
//		
//	}
//			
//	}
//	System.out.println(result);
//	//冒泡排序
//	int[] a = {10,2,34,5,67,1};
//	for(int i = 0;i < a.length-1;i++){
//		for(int j = 0 ; j < a.length-1-i;j++){
//			if (a[j] > a[j+1]) {
//				int temp = a[j];
//				a[j] = a[j+1];
//				a[j+1] = temp;
//			}
//		}
//	}for (int item : a) {
//		System.out.print(item+" ");
//	}
//	
	//二分查找
	int[] b = {1,2,4,6,8,10};
	int index = -1;
	int key = 10;
	int left = 0;
	int right = b.length;
	while (right > left) {
		 int middle = (left+right)/2;
		if (b[middle] == key) {
			index = middle;
			break;
		}
		else if (b[middle] > key ) {
			right = middle-1;
			
		}else{
			left = middle+1;
		}
		
	}	
		if (index == -1) {
			System.out.println("没有找到该值");
		}else{
			System.out.println("找到该值，下标为："+index);
			
		}
		
	}
	
	
	
	}



