package denis.service;


import denis.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
