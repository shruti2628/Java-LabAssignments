package UserRegistrationWithCustomException;

public class UserRegistration {

    public static void registerUser(String username, String userCountry)
            throws InvalidCountryException {

        if (!"India".equalsIgnoreCase(userCountry)) {
            throw new InvalidCountryException(
                    "Invalid country: " + userCountry +
                    ". Only users from India are allowed."
            );
        }

        System.out.println("User registration done successfully");
    }
}
