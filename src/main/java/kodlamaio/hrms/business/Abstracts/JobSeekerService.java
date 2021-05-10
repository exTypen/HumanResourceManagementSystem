package kodlamaio.hrms.business.Abstracts;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {
    List<JobSeeker> getAll();
    boolean add(JobSeeker jobSeeker);
}
