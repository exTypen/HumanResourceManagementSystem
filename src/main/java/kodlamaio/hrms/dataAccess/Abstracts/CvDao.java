package kodlamaio.hrms.dataAccess.Abstracts;

import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvDao extends JpaRepository<Cv, Integer> {
    List<Cv> findAllByJobSeekerId(int id);
}
