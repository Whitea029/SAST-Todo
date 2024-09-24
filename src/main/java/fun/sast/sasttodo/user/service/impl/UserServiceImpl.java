package fun.sast.sasttodo.user.service.impl;

import fun.sast.sasttodo.base.exception.ServiceException;
import fun.sast.sasttodo.base.response.StatusCode;
import fun.sast.sasttodo.user.mapper.UserMapper;
import fun.sast.sasttodo.user.pojo.dto.UserParam;
import fun.sast.sasttodo.user.pojo.entity.User;
import fun.sast.sasttodo.user.pojo.vo.UserVO;
import fun.sast.sasttodo.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserVO login(UserParam userParam) {
        log.debug("登录业务:userParam={}",userParam);
        UserVO userVO = userMapper.selectByStudent_id(userParam.getStudent_id());
        if(userVO==null){
            throw new ServiceException(StatusCode.STUDENT_ID_ERROR);
        }
        if(!userVO.getPassword().equals(userParam.getPassword())){
            throw new ServiceException(StatusCode.PASSWORD_ERROR);
        }
        userVO.setStudent_id(userParam.getStudent_id());
        return userVO;
    }

    @Override
    public void register(UserParam userParam) {
        log.debug("注册业务:userParam={}",userParam);
        User user = new User();
        BeanUtils.copyProperties(userParam,user);
            userMapper.insertUser(user);
    }

    @Override
    public void resetPassword(UserParam userParam) {
        log.debug("重置密码业务:userParam={}",userParam);
        User user = new User();
        BeanUtils.copyProperties(userParam,user);
            userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(String student_id) {
        log.debug("删除用户业务:Student_id={}",student_id);
        userMapper.deleteUser(student_id);
    }
}
