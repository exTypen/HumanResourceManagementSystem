package kodlamaio.hrms.business.Concretes;

import kodlamaio.hrms.business.Abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.Abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll());
    }

    @Override
    public Result add(JobPosition jobPosition) {
        var result = BusinessRules.run(nameExist(jobPosition.getPosition()));
        if (!result.isSuccess()){
            return result;
        }
        jobPositionDao.save(jobPosition);
        return new SuccessResult();
    }

    private Result nameExist(String name){
        var result = this.jobPositionDao.findName(name).isPresent();
        if (result){
            return new ErrorResult("Pozisyon sisteme kayıtlı");
        }
        return new SuccessResult();
    }
}
