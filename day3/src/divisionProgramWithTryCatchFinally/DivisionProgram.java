package divisionProgramWithTryCatchFinally;

import java.util.Scanner;

public class DivisionProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the 2 numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        try {
            int result = a / b;
            System.out.println("The quotient of " + a + "/" + b + " = " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("DivideByZeroException caught");
        }
        finally {
            System.out.println("Inside finally block");
            sc.close();
        }
    }
}
