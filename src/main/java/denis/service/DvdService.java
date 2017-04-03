package denis.service;

/**
 * Created by Денис on 31.03.2017.
 */

import denis.model.Dvd;
import denis.model.User;

public interface DvdService {
    void save(Dvd dvd, User user);
}
