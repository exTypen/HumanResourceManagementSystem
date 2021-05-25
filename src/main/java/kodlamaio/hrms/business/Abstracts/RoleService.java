package kodlamaio.hrms.business.Abstracts;

import kodlamaio.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface RoleService {
    List<JobPosition> getAll();
    void add(JobPosition role);
}
