package kodlamaio.hrms.business.Concretes;

import kodlamaio.hrms.business.Abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.imageUploaders.ImageService;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.Abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private ImageService imageService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, ImageService imageService) {
        this.jobSeekerDao = jobSeekerDao;
        this.imageService = imageService;
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

    @Override
    public DataResult<JobSeeker> imageUpload(int jobSeekerId, MultipartFile file) throws IOException {
        var jobSeeker = this.jobSeekerDao.getOne(jobSeekerId);
        var imageUrl = uploadImageToCloudinary(file, jobSeeker.getImageUrl());
        var result = BusinessRules.run(checkCandidateHadImageUrl(imageUrl.getMessage(),jobSeeker.getImageUrl()));

        if (!result.isSuccess()){
            return new ErrorDataResult<>(null, result.getMessage());
        }if (!imageUrl.isSuccess()){
            return new ErrorDataResult<>(null, imageUrl.getMessage());
        }
        jobSeeker.setImageUrl(imageUrl.getMessage());
        return new SuccessDataResult<>(this.jobSeekerDao.save(jobSeeker));


    }

    private Result checkCandidateHadImageUrl(String newUrl, String oldUrl){
        if(oldUrl != null && newUrl == null){
            return new ErrorResult("Image must be required");
        }
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

    private  Result uploadImageToCloudinary( MultipartFile file, String imageUrl) throws IOException {

        var result = this.imageService.upload(file);
        if(!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }
        if(imageUrl != null){
            var imageId = imageUrl.split(("/"))[imageUrl.split(("/")).length - 1].split("\\.")[0];
            this.imageService.delete(imageId);
        }
        var url = result.getData().get("url");
        return new SuccessResult(url.toString());
    }
}
