package fun.sast.sasttodo.user.controller;

import fun.sast.sasttodo.base.response.JsonResult;
import fun.sast.sasttodo.user.pojo.dto.UserParam;
import fun.sast.sasttodo.user.pojo.vo.UserVO;
import fun.sast.sasttodo.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("login")
    public JsonResult login(@RequestBody UserParam userParam) {
        log.debug("用户登录,userParam={}", userParam);
        UserVO userVO = userService.login(userParam);
        return JsonResult.ok(userVO);
    }

    @PostMapping("register")
    public JsonResult saveUser(UserParam userParam){
        log.debug("注册用户,userParam={}",userParam);
        userService.register(userParam);
        return JsonResult.ok();
    }

    @PostMapping("/resetpassword")
    public JsonResult resetPassword(UserParam userParam){
        log.debug("重置密码,userParam={}",userParam);
        userService.resetPassword(userParam);
        return JsonResult.ok();
    }

    @PostMapping("/delete/{student_id}")
    public JsonResult deleteUser(@PathVariable String student_id){
        log.debug("删除用户,student_id={}",student_id);
        userService.deleteUser(student_id);
        return JsonResult.ok();
    }
}
