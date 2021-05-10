package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.Abstracts.JobSeekerService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {
    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @PostMapping("/add")
    public String add(@RequestBody JobSeeker jobSeeker){
        if (jobSeekerService.add(jobSeeker)){
            return "Eklendi";
        }
        return "hata";
    }

    @GetMapping("/getall")
    public List<JobSeeker> getAll(){
        return jobSeekerService.getAll();
    }
}
