package kodlamaio.hrms.business.Concretes;

import kodlamaio.hrms.business.Abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.Abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByActive(boolean active) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByIsActive(active));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByActiveOrderByCreateDateDesc(boolean active) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByIsActiveOrderByCreateDateDesc(active));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByEmployerId(employerId));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByEmployerIdAndAcitve(int employerId, boolean active) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByEmployerIdAndIsActive(employerId, active));
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult();
    }

    @Override
    public Result delete(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.delete(jobAdvertisement);
        return new SuccessResult();
    }

    @Override
    public Result update(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult();
    }

}
