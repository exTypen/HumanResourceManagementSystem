package kodlamaio.hrms.business.Concretes;

import kodlamaio.hrms.business.Abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.result.*;
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
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        var result = BusinessRules.run(emailExist(jobSeeker.getEmail()), identityExist(jobSeeker.getNationalIdentity()));
        if (!result.isSuccess()){
            return result;
        }
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult();
    }

    @Override
    public Result delete(JobSeeker jobSeeker) {
        this.jobSeekerDao.delete(jobSeeker);
        return new SuccessResult();
    }

    private Result emailExist(String email){
        var result = jobSeekerDao.findEmail(email).isPresent();
        if (result){
            return new ErrorResult("Email sisteme kayıtlı");
        }
        return new SuccessResult();
    }

    private Result identityExist(String identity){
        var result = jobSeekerDao.findNationalIdentity(identity).isPresent();
        if (result){
            return new ErrorResult("TC Kimlik No Kayıtlı");
        }
        return new SuccessResult();
    }
}
