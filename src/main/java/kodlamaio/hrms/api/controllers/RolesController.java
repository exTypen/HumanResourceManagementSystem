package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.Abstracts.RoleService;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    private RoleService roleService;

    @Autowired
    public RolesController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/getall")
    public List<JobPosition> getAll(){
        return roleService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody JobPosition role){
        roleService.add(role);
    }
}
