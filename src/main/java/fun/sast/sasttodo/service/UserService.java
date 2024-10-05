package fun.sast.sasttodo.service;

import fun.sast.sasttodo.entity.User;

public interface UserService {

    // register
    void register(String username, String password);

    //updateUser
    void update(User user);

    // login
    int login(String username, String password);

    //deleteUser
    void deleteUser(Long id);
}
