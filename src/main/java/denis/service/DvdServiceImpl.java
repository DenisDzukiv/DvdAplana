package denis.service;

import denis.dao.DvdDao;
import denis.dao.UserDao;
import denis.model.Dvd;
import denis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Created by Денис on 31.03.2017.
 */
public class DvdServiceImpl implements DvdService{

    @Autowired
    private DvdDao dvdDao;

    public void save(Dvd dvd, User user) {
        dvd.setUser1(user);
        dvd.setGiven(0);
        dvdDao.save(dvd);
    }

    public void updateDvd(Long dvdId) {
        dvdDao.updateDvd(dvdId);
    }

   /* @Override
    public List<String> findBydvdName(){
        List<String> listName = dvdDao.findBydvdName();
        return listName;
    }*/

    @Override
    public List<Dvd> findBygiven(Integer giv){
        List<Dvd> listFree =  dvdDao.findBygiven(giv);
        return listFree;
    }

    @Override
    public List<Dvd> findByuser1(User user){
        List<Dvd> listTakeFromUser = dvdDao.findByuser1(user);
        return listTakeFromUser;
    }
}
