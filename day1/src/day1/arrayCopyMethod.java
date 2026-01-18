package day1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class arrayCopyMethod {
	public static int[] copyOf(int[] array) {
		int[] copyArray = new int[array.length];
		for(int i=0; i<array.length; i++) {
			copyArray[i]=array[i];
		}
		return copyArray;
	}
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("Enter size of array: ");
			int num = sc.nextInt();
			
			if (num<0) {
				System.out.print("size of array cannot be negative.");
				return;
			}
			System.out.println("Enter elements in array:");
			int[] arr = new int[num];
			for(int i=0; i<num; i++) {
				arr[i]=sc.nextInt();
			}
			int[] copied = copyOf(arr);	
			
		}
		catch(InputMismatchException e) {
			System.out.println("Exception. Input type is different.");
		}
		catch(Exception e) {
			System.out.println("Exception occurred."+e.getMessage());
		}
	}
}
