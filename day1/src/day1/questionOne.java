package day1;

public class questionOne {
	public static void main(String[] args) {
		int[] arr = new int[20];
		arr[0]=1;
		arr[1]=1;
		System.out.print(arr[0]+" "+arr[1]+" ");
		for (int i=2; i<20; i++) {
			arr[i]=arr[i-1]+arr[i-2];
			System.out.print(arr[i]+" ");
		}
	}
}
