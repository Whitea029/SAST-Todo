package fun.sast.sasttodo.controller;

import fun.sast.sasttodo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("register")
    String register(String username, String password) {
        // todo
        return null;
    }

    @PostMapping("/login")
    void login(String username, String password) {
        // todo
    }

    @GetMapping
    void logout() {
    }

}
