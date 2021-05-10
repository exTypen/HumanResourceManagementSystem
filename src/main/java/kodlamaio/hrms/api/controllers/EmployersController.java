package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.Abstracts.EmployerService;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }


    @PostMapping("/add")
    public void add(@RequestBody Employer employer){
        employerService.add(employer);
    }

    @GetMapping("/getall")
    public List<Employer> getAll(){
        return employerService.getAll();
    }
}