package denis.service;

/**
 * Created by Денис on 31.03.2017.
 */

import denis.model.Dvd;
import denis.model.User;

import java.util.List;

public interface DvdService {
    void save(Dvd dvd, User user);
    void updateDvd(Long dvdId);
    List<Dvd> findBygiven(Integer giv);
    List<Dvd> findByuser1(User user);
    //List<String> findBydvdName();
}
