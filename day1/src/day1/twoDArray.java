package day1;

import java.util.Scanner;

public class twoDArray {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int patternSize = sc.nextInt();
			if (patternSize<=0) {
				System.out.print("Pattern size is zero.");
				return;
			}
			int arr[][] = new int[patternSize][patternSize];
			for (int i=0; i<patternSize; i++) {
				for (int j=0; j<=i; j++) {
					arr[i][j]=j+1;
				}
			}
			for (int i=0; i<patternSize; i++) {
				for (int j=0; j<=i; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println("Unexpected error.");
		}
				
	}
}
