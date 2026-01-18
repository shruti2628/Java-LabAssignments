package UserRegistrationWithCustomException;

public class InvalidCountryException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCountryException() {
        super("User outside India cannot be registered");
    }

    public InvalidCountryException(String message) {
        super(message);
    }
}
