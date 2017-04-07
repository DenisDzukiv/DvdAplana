package denis.service;


import denis.dao.UserTakeDvdDao;
import denis.model.User;
import denis.model.UserTakeDvd;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Денис on 06.04.2017.
 */
public class UserTakeDvdServiceImpl implements UserTakeDvdService {

    @Autowired
    private UserTakeDvdDao userTakeDvdDao;

    public void save(Long userId, Long dvdId){
        UserTakeDvd locationDisk = new UserTakeDvd();
        locationDisk.setUserId(userId);
        locationDisk.setDvdId(dvdId);
        userTakeDvdDao.save(locationDisk);
    }

    public void delete(Long dvdId){
        userTakeDvdDao.delete(dvdId);
    }
}
