package kodlamaio.hrms.business.Concretes;

import kodlamaio.hrms.business.Abstracts.UserService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.Abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll());
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult();
    }

    @Override
    public Result delete(User user) {
        this.userDao.delete(user);
        return new SuccessResult();
    }
}
