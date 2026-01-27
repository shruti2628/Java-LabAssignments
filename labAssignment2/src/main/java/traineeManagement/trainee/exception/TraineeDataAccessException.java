package traineeManagement.trainee.exception;

public class TraineeDataAccessException extends Exception{
	public TraineeDataAccessException(String message) {
        super(message);
    }

    public TraineeDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
