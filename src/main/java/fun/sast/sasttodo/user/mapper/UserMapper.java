package fun.sast.sasttodo.user.mapper;

import fun.sast.sasttodo.user.pojo.dto.UserQuery;
import fun.sast.sasttodo.user.pojo.entity.User;
import fun.sast.sasttodo.user.pojo.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    UserVO selectByStudent_id(String student_id);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(String student_id);
}
