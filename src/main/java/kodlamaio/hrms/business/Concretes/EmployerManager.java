package kodlamaio.hrms.business.Concretes;

import kodlamaio.hrms.business.Abstracts.EmployerService;
import kodlamaio.hrms.dataAccess.Abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public List<Employer> getAll() {
        return employerDao.findAll();
    }

    @Override
    public void add(Employer employer) {
        employerDao.save(employer);
    }
}
