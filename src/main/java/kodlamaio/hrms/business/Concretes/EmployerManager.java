package kodlamaio.hrms.business.Concretes;

import kodlamaio.hrms.business.Abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.Abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
    }

    @Override
    public Result add(Employer employer) {
        var result = BusinessRules.run(checkIsEmailTrue(employer));
        if (!result.isSuccess()){
            return result;
        }
        this.employerDao.save(employer);
        return new SuccessResult();
    }

    @Override
    public Result delete(Employer employer) {
        this.employerDao.delete(employer);
        return new SuccessResult();
    }

    private Result checkIsEmailTrue(Employer employer){
        var domain = employer.getEmail().split("@",2);
        if (employer.getWebSite().equals(domain[1])){
            return new SuccessResult();
        }
        return new ErrorResult("Email ile website uyuşmuyor.");
    }
}
