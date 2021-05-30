package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.Abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getAllByActive")
    public DataResult<List<JobAdvertisement>> getAllByActive(@RequestParam boolean active){
        return jobAdvertisementService.getAllByActive(active);
    }

    @GetMapping("/getAllByActiveOrderByCreateDateDesc")
    public DataResult<List<JobAdvertisement>> getAllByActiveOrderByCreateDateDesc(@RequestParam boolean active){
        return jobAdvertisementService.getAllByActiveOrderByCreateDateDesc(active);
    }

    @GetMapping("/getAllByEmployerId")
    public DataResult<List<JobAdvertisement>> getAllByEmployerId(@RequestParam int employerId){
        return jobAdvertisementService.getAllByEmployerId(employerId);
    }

    @GetMapping("/getAllByEmployerIdAndAcitve")
    public DataResult<List<JobAdvertisement>> getAllByEmployerIdAndAcitve(@RequestParam int employerId, boolean active){
        return jobAdvertisementService.getAllByEmployerIdAndAcitve(employerId, active);
    }

    @PostMapping("add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return jobAdvertisementService.add(jobAdvertisement);
    }

    @PostMapping("update")
    public Result update(@RequestBody JobAdvertisement jobAdvertisement){
        return jobAdvertisementService.update(jobAdvertisement);
    }
}
