package kodlamaio.hrms.business.Abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Cv;

import java.util.List;

public interface CvService {
    DataResult<List<Cv>> getAll();
    Result add(Cv cv);
}
