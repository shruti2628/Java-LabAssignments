package ValidateAgeName;

public class ValidatePerson {

 public static void main(String[] args) {

     try {
         
         if (args.length < 2) {
             System.out.println("Usage: java ValidatePerson <Name> <Age>");
             return;
         }

         String name = args[0];
         int age = Integer.parseInt(args[1]);


         if (age < 18 || age >= 60) {
             throw new InvalidAgeException("Age must be between 18 and 59");
         }

         System.out.println("Name: " + name + ", Age: " + age);

     } catch (InvalidAgeException e) {
         System.out.println("InvalidAgeException: " + e.getMessage());
     } catch (NumberFormatException e) {
         System.out.println("Age must be a valid number");
     }
 }
}
