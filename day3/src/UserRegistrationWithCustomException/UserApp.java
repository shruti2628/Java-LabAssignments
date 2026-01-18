package UserRegistrationWithCustomException;

public class UserApp {

    public static void main(String[] args) {

        //Valid Input
        try {
            UserRegistration.registerUser("Amit", "India");
        } catch (InvalidCountryException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //Invalid Input
        try {
            UserRegistration.registerUser("John", "USA");
        } catch (InvalidCountryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

