package kodlamaio.hrms.business.Concretes;

import kodlamaio.hrms.business.Abstracts.JobSeekerService;
import kodlamaio.hrms.dataAccess.Abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public List<JobSeeker> getAll() {
        return jobSeekerDao.findAll();
    }

    @Override
    public boolean add(JobSeeker jobSeeker) {
        if (checkEmailExist(jobSeeker.email)){
            return false;
        }
        jobSeekerDao.save(jobSeeker);
        return true;
    }

    private boolean checkEmailExist(String email){
        var result = jobSeekerDao.findEmail(email).isPresent();
        if (result){return true;}
        return false;
    }
}
