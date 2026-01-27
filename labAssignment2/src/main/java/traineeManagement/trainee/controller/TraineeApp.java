package traineeManagement.trainee.controller;

import traineeManagement.trainee.dto.Trainee;
import traineeManagement.trainee.exception.TraineeDataAccessException;
import traineeManagement.trainee.service.TraineeService;

import java.math.BigDecimal;
import java.util.Scanner;
	
public class TraineeApp {

    public static void main(String[] args) throws TraineeDataAccessException {

        TraineeService traineeService = new TraineeService();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n Trainee Management System ");
            System.out.println("1. Add Trainee");
            System.out.println("2. Find Trainee by ID");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (choice) {

                    case 1:
                        addTrainee(scanner, traineeService);
                        break;

                    case 2:
                        findTrainee(scanner, traineeService);
                        break;

                    case 3:
                        System.out.println("Exiting application...");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Validation Error: " + e.getMessage());
            }
        }
    }

    private static void addTrainee(Scanner scanner, TraineeService service) {

        System.out.print("Enter Trainee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Branch (java/oracle/php/dotnet): ");
        String branch = scanner.nextLine();

        System.out.print("Enter Percentage: ");
        BigDecimal percentage = scanner.nextBigDecimal();
        scanner.nextLine();

        Trainee trainee = new Trainee();
        trainee.setTraineeName(name);
        trainee.setBranch(branch);
        trainee.setPercentage(percentage);

        try {
			service.addTrainee(trainee);
		} catch (TraineeDataAccessException e) {
			e.printStackTrace();
		}
        System.out.println("✅ Trainee added successfully!");
    }

    private static void findTrainee(Scanner scanner, TraineeService service) throws TraineeDataAccessException {

        System.out.print("Enter Trainee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Trainee trainee = service.findTraineeById(id);

        if (trainee != null) {
            System.out.println("\n--- Trainee Details ---");
            System.out.println("ID: " + trainee.getTraineeId());
            System.out.println("Name: " + trainee.getTraineeName());
            System.out.println("Branch: " + trainee.getBranch());
            System.out.println("Percentage: " + trainee.getPercentage());
        } else {
            System.out.println("❌ Trainee not found");
        }
    }
}
