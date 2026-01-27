package traineeManagement.trainee.dao.jdbc;

import traineeManagement.trainee.dao.TraineeDao;
import traineeManagement.trainee.dto.Trainee;
import traineeManagement.trainee.exception.TraineeDataAccessException;
import traineeManagement.trainee.factory.JdbcConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TraineeJdbcDao implements TraineeDao {
	private static final String INSERT_SQL =
            "INSERT INTO trainee (trainee_name, branch, percentage) VALUES (?, ?, ?)";

    private static final String SELECT_BY_ID_SQL =
            "SELECT trainee_id, trainee_name, branch, percentage FROM trainee WHERE trainee_id = ?";

    @Override
    public void addTrainee(Trainee trainee) throws TraineeDataAccessException {
        try (Connection connection = JdbcConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_SQL)) {

            ps.setString(1, trainee.getTraineeName());
            ps.setString(2, trainee.getBranch());
            ps.setBigDecimal(3, trainee.getPercentage());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new TraineeDataAccessException("Failed to add trainee using JDBC", e);
        }
    }

    @Override
    public Trainee findTraineeById(int traineeId) throws TraineeDataAccessException {
        try (Connection connection = JdbcConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_SQL)) {

            ps.setInt(1, traineeId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Trainee(
                            rs.getInt("trainee_id"),
                            rs.getString("trainee_name"),
                            rs.getString("branch"),
                            rs.getBigDecimal("percentage")
                    );
                }
            }

            return null; 

        } catch (SQLException e) {
            throw new TraineeDataAccessException("Failed to find trainee by ID using JDBC", e);
        }
    }
}
