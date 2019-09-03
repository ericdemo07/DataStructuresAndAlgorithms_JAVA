package searching;


public class SearchMediocre{

	public static void main(String ...args){
		SearchMediocre search = new SearchMediocre();

		//int[] arr = {12,13,14,15,1,2,3,4,5,6,7,8,9,10,11}; 
		int[] arr1 = {1, 12, 15, 26, 38}; 
		int[] arr2 = {2, 13, 17, 30, 45}; 
		
		//System.out.println(search.searchInSortedAndRotatedArray(arr, 122));
		search.findMedianOfTwoSortedArrayOfSameSize(arr1, arr2);
	}

	private void findMedianOfTwoSortedArrayOfSameSize(int[] arr1, int[] arr2){
		findMedianOfTwoSortedArrayOfSameSizeUtil(arr1, 0, arr1.length-1, arr2, 0, arr2.length-1);
	}

	private void findMedianOfTwoSortedArrayOfSameSizeUtil(int[] arr1,int start1, int end1, int[] arr2, int start2, int end2){
	
		if(end1-start1 == 2){
			int median = (Math.max(arr1[start1], arr2[start2])+Math.min(arr2[end1], arr2[end2]))/2;
			return;
		}


		int midArr1 = (start1+end1)/2;
		int medianArr1 = 0;
		if((end1 - start1)%2 == 0){
			medianArr1 = arr1[midArr1];
		}
		else{
			medianArr1 = (arr1[midArr1] + arr1[midArr1 +1])/2;
		}
		if(medianArr1 > arr1[midArr1]){
			end1 = midArr1;
		}
		else{
			start1 = midArr1;
		}


		int midArr2 = (start2+end2)/2;
		int medianArr2 = 0;
		if((end2 - start2)%2 == 0){
			medianArr2 = arr2[midArr2];
		}
		else{
			medianArr2 = (arr2[midArr2] + arr2[midArr2 +2])/2;
		}
		if(medianArr2 > arr2[midArr2]){
			end2 = midArr2;
		}
		else{
			start2 = midArr2;
		}
		findMedianOfTwoSortedArrayOfSameSizeUtil(arr1, start1, end1, arr2, start2, end2);
	}

	private int findMissingInN(int[] arr){

		int max = 0, sum = 0;

		for(int i = 0; i < arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
			}
			sum = sum + arr[i];
		}

		int sumOfNnumbers = (max * (max + 1))/2;

		return sumOfNnumbers - sum;
	}	
	
	private boolean binarySearch(int[] arr, int start, int end, int data){
		if(end < start){
			return false;
		}

		int mid = (start + end)/2;

		if(arr[mid] == data){
			return true;
		}

		if(data > arr[mid]){
			return binarySearch(arr, mid+1, end, data);
		}
		return binarySearch(arr, start, mid -1, data);
	}

	private int findPivot(int[] arr, int start, int end){
		if(end < start){
			return -1;
		}
		if(end == start){
			return start;
		}
		int mid = (start + end)/2;

		if(arr[mid+1] < arr[mid]){
			return mid;
		}
		if(arr[mid] < arr[mid-1]){
			return arr[mid-1];
		}
		if(arr[start] > arr[mid]){
			return findPivot(arr, start, mid-1);
		}
		return findPivot(arr, mid+1, end);
	}

	private boolean searchInSortedAndRotatedArray(int[] arr, int data){
		int end = arr.length - 1, start = 0;
		int pivot = findPivot(arr, 0, arr.length - 1);

		if(data > arr[end] && data < arr[pivot]){
			return binarySearch(arr, start, pivot-1, data);
		}
		return binarySearch(arr, pivot, end, data);
	}
}