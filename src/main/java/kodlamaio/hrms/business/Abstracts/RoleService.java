package kodlamaio.hrms.business.Abstracts;

import kodlamaio.hrms.entities.concretes.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    void add(Role role);
}
