package traineeManagement.trainee.factory;

import traineeManagement.trainee.dao.TraineeDao;
import traineeManagement.trainee.dao.jdbc.TraineeJdbcDao;
import traineeManagement.trainee.dao.jpa.TraineeJpaDAO;

import java.io.InputStream;
import java.util.Properties;

public class TraineeDaoFactory {
	private static final Properties properties = new Properties();

    static {
        try (InputStream input = TraineeDaoFactory.class
                .getClassLoader()
                .getResourceAsStream("dao.properties")) {

            if (input == null) {
                throw new RuntimeException("dao.properties file not found");
            }
            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load DAO configuration", e);
        }
    }

    private TraineeDaoFactory() {
    }

    public static TraineeDao getTraineeDAO() {

        String daoType = properties.getProperty("dao.type");

        if ("JPA".equalsIgnoreCase(daoType)) {
            return new TraineeJpaDAO();
        } else if ("JDBC".equalsIgnoreCase(daoType)) {
            return new TraineeJdbcDao();
        } else {
            throw new RuntimeException("Invalid dao.type in dao.properties");
        }
    }
}
