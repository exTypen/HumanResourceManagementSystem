package kodlamaio.hrms.business.Abstracts;

import kodlamaio.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    List<Employer> getAll();
    void add(Employer employer);
}
