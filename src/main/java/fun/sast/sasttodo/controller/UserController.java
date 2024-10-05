package fun.sast.sasttodo.controller;

import fun.sast.sasttodo.entity.User;
import fun.sast.sasttodo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("register")
    String register(String username, String password) {

        userService.register(username, password);
        return null;
    }

    @PutMapping("update")
    void update(User user) {
        userService.update(user);
    }
    @PostMapping("/login")
    void login(String username, String password) {

        userService.login(username, password);
    }

    @DeleteMapping("delete")
    void delete(User user) {
        userService.deleteUser(user.getId());
    }

    @GetMapping
    void logout() {
    }

}
