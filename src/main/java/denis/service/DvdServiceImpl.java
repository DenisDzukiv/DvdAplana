package denis.service;

import denis.dao.DvdDao;
import denis.dao.UserDao;
import denis.model.Dvd;
import denis.model.User;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * Created by Денис on 31.03.2017.
 */
public class DvdServiceImpl implements DvdService{

    /*@Autowired
    private UserDao userDao;*/

    @Autowired
    private DvdDao dvdDao;

    public void save(Dvd dvd, User user) {
        dvd.setUser1(user);
        dvdDao.save(dvd);
    }
}
