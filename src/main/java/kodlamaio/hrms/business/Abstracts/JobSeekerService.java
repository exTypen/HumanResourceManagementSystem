package kodlamaio.hrms.business.Abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface JobSeekerService {
    DataResult<List<JobSeeker>> getAll();
    Result add(JobSeeker jobSeeker);
    Result delete(JobSeeker jobSeeker);
    DataResult<JobSeeker> imageUpload(int candidateId, MultipartFile file) throws IOException;
}
