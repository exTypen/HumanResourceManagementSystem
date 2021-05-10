package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.Abstracts.RoleService;
import kodlamaio.hrms.entities.concretes.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/getall")
    public List<Role> getAll(){
        return roleService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Role role){
        roleService.add(role);
    }
}
