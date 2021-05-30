package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.Abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class JopPositionsController {

    private JobPositionService roleService;

    @Autowired
    public JopPositionsController(JobPositionService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll(){
        return roleService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosition role){
        return roleService.add(role);
    }
}
