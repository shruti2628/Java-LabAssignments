package traineeManagement.trainee.dao.jpa;

import traineeManagement.trainee.dao.TraineeDao;
import traineeManagement.trainee.dto.Trainee;
import traineeManagement.trainee.exception.TraineeDataAccessException;
import traineeManagement.trainee.util.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import traineeManagement.trainee.dao.TraineeDao;

public class TraineeJpaDAO implements TraineeDao {
	
	@Override
    public void addTrainee(Trainee trainee) throws TraineeDataAccessException {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = JpaUtil.getEntityManager();
            tx = em.getTransaction();

            tx.begin();
            em.persist(trainee);
            tx.commit();

        } catch (PersistenceException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new TraineeDataAccessException("Failed to add trainee using JPA", e);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Trainee findTraineeById(int traineeId) throws TraineeDataAccessException {
        EntityManager em = null;

        try {
            em = JpaUtil.getEntityManager();
            return em.find(Trainee.class, traineeId);

        } catch (PersistenceException e) {
            throw new TraineeDataAccessException("Failed to find trainee using JPA", e);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
