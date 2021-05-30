package kodlamaio.hrms.dataAccess.Abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findAllByEmployerId(int employerId);
    List<JobAdvertisement> findAllByEmployerIdAndIsActive(int employerId, boolean active);
    List<JobAdvertisement> findAllByIsActive(boolean isActive);
    List<JobAdvertisement> findAllByIsActiveOrderByCreateDateDesc(boolean isActive);
}
