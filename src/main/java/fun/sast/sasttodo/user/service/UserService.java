package fun.sast.sasttodo.user.service;

import fun.sast.sasttodo.user.pojo.dto.UserParam;
import fun.sast.sasttodo.user.pojo.vo.UserVO;

public interface UserService {
    UserVO login(UserParam userParam);

    void register(UserParam userParam);

    void resetPassword(UserParam userParam);

    void deleteUser(String student_id);

}
