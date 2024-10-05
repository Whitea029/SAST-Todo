package fun.sast.sasttodo.service.impl;

import fun.sast.sasttodo.entity.User;
import fun.sast.sasttodo.mapper.UserMapper;
import fun.sast.sasttodo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    // register
    @Override
    public void register(String username, String password) {
        User user = new User();
        user.setStudentId(username);
        user.setPassword(password);
        userMapper.insertOne(user);
    }

    //update
    @Override
    public void update(User user) {

        userMapper.update(user);
    }

    // login
    @Override
    public int login(String username, String password) {
        return userMapper.login(username, password);
    }

    //deleteUser
    @Override
    public void deleteUser(Long id) {
        userMapper.deleteById(id);
    }
}
