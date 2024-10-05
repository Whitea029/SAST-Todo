package fun.sast.sasttodo.mapper;

import fun.sast.sasttodo.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    // insertOne
    @Insert("INSERT INTO user ( student_id, password) VALUES (#{student_id}, #{password})")
    int insertOne(User user);

    // update
    @Update("UPDATE user SET student_id = #{student_id} WHERE id = #{id}")
    int update(User user);

    // login
    @Select("SELECT COUNT(*) FROM user WHERE student_id = #{student_id} AND password = #{password}")
    int login(String student_id, String password);

    // deleteById
    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteById(Long id);
}
