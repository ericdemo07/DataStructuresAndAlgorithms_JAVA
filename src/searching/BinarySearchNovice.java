package searching;

import java.util.*;

public class BinarySearchNovice{
	public static void main(String ...args){
		//int[] arr = {1, 2, 3, 4, 2, 3};
		int[] arr = {2, 3, 1, 2, 3};

		BinarySearchNovice bSearch = new BinarySearchNovice();
		//System.out.println(bSearch.arrayHasDuplicates(arr));
		System.out.println("firstRepeating : "+bSearch.firstRepeating(arr));
	}
//in these examples elements is between 1-n
	private boolean arrayHasDuplicates(int[] arr){
		for(int i = 0; i < arr.length; i++){
			if(arr[Math.abs(arr[i])] < 0){
				return true;
			}
			arr[Math.abs(arr[i])] =  - arr[Math.abs(arr[i])];
		}
		return false;
	}


	private int maxOccourence(int[] arr){
		int max = 0;
		int n = arr.length; 
		int maxIndex = 0;
		for(int i = 0; i < n; i++){
			arr[arr[i] % n] += n;
		}

		for(int i = 0; i < n; i++){
			if(arr[i]/n > max){
				max = arr[i]/n;
				maxIndex = i;
			}
		}
		return max;
	}

	private int firstRepeating(int[] arr){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < arr.length; i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i], -map.get(arr[i]));
			}else{
				map.put(arr[i], i+1);
			}
		}

		int min = - arr.length;
		int element = 0;
		for(Map.Entry<Integer, Integer> m : map.entrySet()){
			if(m.getValue() < 0 && m.getValue() > min){
				min = m.getValue();
				element = m.getKey();
			}
		}

		return element;
	}
}