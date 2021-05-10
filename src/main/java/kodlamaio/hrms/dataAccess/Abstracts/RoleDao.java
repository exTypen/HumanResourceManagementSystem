package kodlamaio.hrms.dataAccess.Abstracts;

import kodlamaio.hrms.entities.concretes.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
}
