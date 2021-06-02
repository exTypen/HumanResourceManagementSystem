package kodlamaio.hrms.business.Concretes;

import kodlamaio.hrms.business.Abstracts.CvService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.Abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;

    @Autowired
    public CvManager(CvDao cvDao) {
        this.cvDao = cvDao;
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(cvDao.findAll());
    }

    @Override
    public DataResult<List<Cv>> getAllByJobSeeker(int id) {
        return new SuccessDataResult<List<Cv>>(cvDao.findAllByJobSeekerId(id));
    }

    @Override
    public Result add(Cv cv) {
        cvDao.save(cv);
        return new SuccessResult();
    }
}
