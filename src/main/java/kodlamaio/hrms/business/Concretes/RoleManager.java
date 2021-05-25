package kodlamaio.hrms.business.Concretes;

import kodlamaio.hrms.business.Abstracts.RoleService;
import kodlamaio.hrms.dataAccess.Abstracts.RoleDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleManager implements RoleService {

    private RoleDao roleDao;

    @Autowired
    public RoleManager(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<JobPosition> getAll() {
        return roleDao.findAll();
    }

    @Override
    public void add(JobPosition role) {
        roleDao.save(role);
    }
}
