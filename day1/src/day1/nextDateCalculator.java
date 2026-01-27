package day1;

import java.util.Scanner;

public class nextDateCalculator {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int day = sc.nextInt();
			int month = sc.nextInt();
			int year = sc.nextInt();
			String date = day+"/"+month+"/"+year;
			int[] days = {-1,31,28,31,30,31,30,31,31,30,31,30,31};
			if(year%4==0 || (year%100==0 && year%4==0)) {
				days[2]=29;
			}
			if (days[month]==day) {
				if(month==12) {
					month=1;
					year++;
				}
				else{
					month++;	
				}
				day=1;
			}
			else {
				day++;				
			}
			String nextDate = day+"/"+month+"/"+year;
			System.out.println(nextDate);
		}
		catch(Exception e) {
			System.out.println("Exception occurred.");
		}
	}
}
