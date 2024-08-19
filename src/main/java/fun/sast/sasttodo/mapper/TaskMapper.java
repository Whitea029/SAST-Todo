package fun.sast.sasttodo.mapper;

import fun.sast.sasttodo.entity.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {

    // selectList
    @Select("SELECT * FROM Task")
    public List<Task> selectList();

    // insert
    @Insert("INSERT INTO Task (id, user_id, title, description, status, due_date, create_time, last_update_time) " +
            "VALUES (#{id}, #{userId}, #{title}, #{description}, #{status}, #{dueDate}, #{createTime}, #{lastUpdateTime})")
    public void insert(Task task);

    // update
    @Update("UPDATE Task SET user_id=#{userId}, title=#{title}, description=#{description}, status=#{status}, due_date=#{dueDate}, last_update_time=#{lastUpdateTime} WHERE id = #{id}")
    public void update(Task task);

    // deleteById
    @Delete("DELETE FROM Task WHERE id = #{id}")
    public void deleteById(Integer id);

    // getTaskById
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "due_date", property = "dueDate"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "last_update_time", property = "lastUpdateTime")
    })
    @Select("SELECT * FROM Task WHERE id = #{id}")
    public Task getTaskById(Integer id);

}
