package fun.sast.sasttodo.mapper;

import fun.sast.sasttodo.entity.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {

    // selectList
    @Select("SELECT * FROM task")
    List<Task> selectAll();

    @Select("SELECT * FROM task WHERE id = #{id}")
    Task selectById(int id);

    // insert
    @Insert("INSERT INTO task (userId, title, description, status, dueDate, createTime, lastUpdateTime) VALUE (#{userId}, #{title}, #{description}, #{status}, #{dueDate}, #{createTime}, #{lastUpdateTime})")
    int insertTask(Task task);

    // update
    @Update("UPDATE task SET status = #{status}, lastUpdateTime = #{lastUpdateTime} WHERE id = #{id}")
    int updateTask(Task task);

    // deleteById
    @Delete("DELETE FROM task WHERE id = #{id}")
    int deleteById (Long id);

}
