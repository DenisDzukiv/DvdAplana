package denis.service;


import denis.model.Dvd;
import denis.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    User findBydvds1(Dvd dvd);

}
