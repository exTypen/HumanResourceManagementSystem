package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.Abstracts.CvService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {

    private CvService cvService;

    @Autowired
    public CvsController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/getall")
    public DataResult<List<Cv>> getAll(){
        return cvService.getAll();
    }

    @GetMapping("/getallbyjobseeker")
    public DataResult<List<Cv>> getAllByJobSeeker(@RequestParam int id){
        return cvService.getAllByJobSeeker(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Cv cv){
        return cvService.add(cv);
    }
}
