package kodlamaio.hrms.dataAccess.Abstracts;

import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
    @Query("SELECT s FROM JobSeeker s WHERE s.email=?1")
    Optional<JobSeeker> findName(String name);
}
