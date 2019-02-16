import java.util.Arrays;

/**
*
*@author LiuXu
*@version 2018年10月17日下午3:40:59 
*/
public class Sort {

	public static void main(String[] args) {
		int[] arr = {3,6,1,2};
		bubbleSort(arr);
		quickSort(arr);
	}
	
	//冒泡排序
	public static void bubbleSort(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void quickSort(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length-1; j++) {
				if (arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
