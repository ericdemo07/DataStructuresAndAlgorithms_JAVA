package searching;

import java.util.Arrays;

public class SearchMediocre2{
	public static void main(String ...args){

		SearchMediocre2 search = new SearchMediocre2();

		int[] arr1 = {1, 60, -10, 70, -80, 85};
		search.findSamllestAndSecondSmallest(arr1);

	}

	private void pairsWithSumCloseToZero(int[] arr){
		Arrays.sort(arr);

		int i = 0;
		int j = arr.length-1;

		int max = Integer.MAX_VALUE;;
		int num1 = 0;
		int num2 = 0;
		while(i < j){
			if(Math.abs(arr[i] + arr[j]) < max){
				num1 = arr[i];
				num2 = arr[j];
				max = Math.abs(arr[i] + arr[j]);
			}
			i++;
			j--;
		}
		System.out.println("num1 :"+num1+"   |   num2 :"+num2);
	}

	private void findSamllestAndSecondSmallest(int[] arr){

		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		int thirdMin = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < min){
				thirdMin = secondMin;
				secondMin = min;
				min = arr[i];
			}
		}
		System.out.println("min :"+min);
		System.out.println("secondMin :"+secondMin);
		System.out.println("thirdMin :"+thirdMin);
	}
}