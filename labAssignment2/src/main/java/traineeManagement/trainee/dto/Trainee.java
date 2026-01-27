
package traineeManagement.trainee.dto;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "trainee")
public class Trainee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainee_id")
    private int traineeId;

    @Column(name = "trainee_name", nullable = false)
    private String traineeName;

    @Column(name = "branch", nullable = false)
    private String branch;

    @Column(name = "percentage", precision = 5, scale = 2)
    private BigDecimal percentage;

    public Trainee() {
    }

    public Trainee(String traineeName, String branch, BigDecimal percentage) {
        this.traineeName = traineeName;
        this.branch = branch;
        this.percentage = percentage;
    }

    public Trainee(int traineeId, String traineeName, String branch, BigDecimal percentage) {
        this.traineeId = traineeId;
        this.traineeName = traineeName;
        this.branch = branch;
        this.percentage = percentage;
    }

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "traineeId=" + traineeId +
                ", traineeName='" + traineeName + '\'' +
                ", branch='" + branch + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
