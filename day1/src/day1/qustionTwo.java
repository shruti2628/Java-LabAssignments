package day1;

import java.util.Scanner;

public class qustionTwo {
	public static void main(String[] args) {
		System.out.print("Enter number of students: ");
		try(Scanner sc = new Scanner(System.in)){
			int noOfStudents = sc.nextInt();
			if (noOfStudents>0) {
				int[] grades = new int[noOfStudents];
				int i=0, avg=0;
				while(i<noOfStudents) {
					int count=i+1;
					System.out.print("Enter grade for student "+count+": ");
					grades[i]=sc.nextInt();
					if (grades[i]>100 || grades[i]<0) {
						System.out.println("Invalid grade. Try again.");
					}
					else {
						avg = avg+grades[i];
						i++;
					}
				}
				System.out.print(avg/noOfStudents);
				
			}
			else if(noOfStudents==0){
				System.out.print("Number of students is zero.");
			}
		}
		catch (Exception e) {
			System.out.print("Exception occurred.");
		}
		
	}
}
