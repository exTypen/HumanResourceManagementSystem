package kodlamaio.hrms.business.Abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> getAllByActive(boolean active);
    DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId);
    DataResult<List<JobAdvertisement>> getAllByEmployerIdAndAcitve(int employerId, boolean active);
    DataResult<List<JobAdvertisement>> getAllByActiveOrderByCreateDateDesc(boolean active);
    Result add(JobAdvertisement jobAdvertisement);
    Result delete(JobAdvertisement jobAdvertisement);
    Result update(JobAdvertisement jobAdvertisement);
}
