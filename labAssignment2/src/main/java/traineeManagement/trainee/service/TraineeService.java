package traineeManagement.trainee.service;


import traineeManagement.trainee.dao.TraineeDao;
import traineeManagement.trainee.dto.Trainee;
import traineeManagement.trainee.exception.TraineeDataAccessException;
import traineeManagement.trainee.factory.TraineeDaoFactory;

import java.math.BigDecimal;
import java.util.Set;

public class TraineeService {

    private static final Set<String> VALID_BRANCHES =
            Set.of("java", "oracle", "php", "dotnet");

    private final TraineeDao traineeDAO;


    public TraineeService() {
        this.traineeDAO = TraineeDaoFactory.getTraineeDAO();
    }

    public TraineeService(TraineeDao traineeDAO) {
        this.traineeDAO = traineeDAO;
    }

    public void addTrainee(Trainee trainee) throws TraineeDataAccessException {
System.out.println("Add 1");
        validateTrainee(trainee);
        System.out.println("Add 2");
        traineeDAO.addTrainee(trainee);
        System.out.println("Add 3");    }

    public Trainee findTraineeById(int traineeId) throws TraineeDataAccessException {

        if (traineeId <= 0) {
            throw new IllegalArgumentException("Trainee ID must be positive");
        }

        return traineeDAO.findTraineeById(traineeId);
    }

    private void validateTrainee(Trainee trainee) {
    	System.out.println("Validate");
        if (trainee == null) {
            throw new IllegalArgumentException("Trainee cannot be null");
        }

        if (trainee.getTraineeName() == null || trainee.getTraineeName().isBlank()) {
            throw new IllegalArgumentException("Trainee name is mandatory");
        }

        if (!VALID_BRANCHES.contains(trainee.getBranch().toLowerCase())) {
            throw new IllegalArgumentException("Invalid branch");
        }

        BigDecimal percentage = trainee.getPercentage();
        if (percentage == null ||
                percentage.compareTo(BigDecimal.ZERO) < 0 ||
                percentage.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100");
        }
        System.out.println("Validation passed");
    }
};   
