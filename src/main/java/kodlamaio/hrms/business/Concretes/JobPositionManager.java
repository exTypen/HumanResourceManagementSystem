package kodlamaio.hrms.business.Concretes;

import kodlamaio.hrms.business.Abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.Abstracts.JopPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JopPositionDao roleDao;

    @Autowired
    public JobPositionManager(JopPositionDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(roleDao.findAll());
    }

    @Override
    public Result add(JobPosition role) {
        roleDao.save(role);
        return new SuccessResult();
    }
}
