package traineeManagement.trainee.dao;

import traineeManagement.trainee.dto.Trainee;
import traineeManagement.trainee.exception.TraineeDataAccessException;

public interface TraineeDao {
	void addTrainee(Trainee trainee) throws TraineeDataAccessException;

    Trainee findTraineeById(int traineeId) throws TraineeDataAccessException;
}
