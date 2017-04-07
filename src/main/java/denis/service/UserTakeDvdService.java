package denis.service;

import denis.model.User;

/**
 * Created by Денис on 06.04.2017.
 */
public interface UserTakeDvdService {
    void save(Long userId, Long dvdId);
    void delete(Long dvdId);
}
