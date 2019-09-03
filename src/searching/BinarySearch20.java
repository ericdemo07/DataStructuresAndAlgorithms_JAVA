package searching;

public class BinarySearch20{
	public static void main(String ...args){
		String[] arr =  {"for", "", "", "", "geeks", "ide", "", "practice", "" , "", "quiz", "", ""};

		BinarySearch20 bSearch = new BinarySearch20();
		bSearch.binarySearch(arr, "geeks");
	}

	private void binarySearch(String[] arr, String data){
		if(!isNullOrEmpty(data)){
			binarySearchUtil(arr, data, 0, arr.length-1);
		}
	}

	private void binarySearchUtil(String[] arr, String data, int start, int end){
		if(start > end){
			return;
		}

		int mid = (start + end)/2;

		if(isNullOrEmpty(arr[mid])){
			mid = findMid(mid, arr, start, end);
		}

		if(data.compareTo(arr[mid]) == 0){
			System.out.println("found at :"+mid);
		}

		if(data.compareTo(arr[mid]) > 0){
			binarySearchUtil(arr, data, mid+1, end);
		}
		else{
			binarySearchUtil(arr, data, start, mid-1);
		}
	}

	private boolean isNullOrEmpty(String str){
		if(str == null || str.length() == 0){	
			return true;
		}
		return false;
	}

	private int findMid(int mid, String[] arr, int start, int end){
		
		int i = mid-1;
		int j = mid+1;
		while(i >= start && j <= end){
			if(isNullOrEmpty(arr[i])){
				i = i-1;
			}else{
				mid = i;
				break;
			}
			if(isNullOrEmpty(arr[j])){
				j = j+1;
			}else{
				mid = j;
				break;
			}
		}
		return mid;
	}
}