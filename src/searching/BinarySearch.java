package searching;

public class BinarySearch{
	
	public static void main(String ...args){
		int[] arr  = {1,2,3,5,16};

		BinarySearch bSearch = new BinarySearch();
		System.out.println(bSearch.search(arr, 1));
	}

	private boolean search(int[] arr, int data){
		boolean found = searchUtil(arr, data, 0, arr.length-1);
		return found;
	}

	private boolean searchUtil(int[] arr, int data, int start, int end){
		if(start > end){
			return false;
		}

		int mid = (end + start)/2;

		if(arr[mid] == data){
			return true;
		}
		if(data < arr[mid]){
			return searchUtil(arr, data, start, mid-1);
		}
		return searchUtil(arr, data, mid+1, end);
		
	}
}