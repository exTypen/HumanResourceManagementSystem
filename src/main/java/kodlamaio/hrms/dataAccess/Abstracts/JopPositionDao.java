package kodlamaio.hrms.dataAccess.Abstracts;

import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JopPositionDao extends JpaRepository<JobPosition, Integer> {
}
