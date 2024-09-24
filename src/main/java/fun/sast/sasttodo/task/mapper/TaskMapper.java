package fun.sast.sasttodo.task.mapper;

import fun.sast.sasttodo.task.pojo.dto.TaskQuery;
import fun.sast.sasttodo.task.pojo.entity.Task;
import fun.sast.sasttodo.task.pojo.vo.TaskVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMapper {
    List<TaskVO> selectTask(TaskQuery taskQuery);

    void insertTask(Task task);

    void updateTask(Task task);

    void deleteTask(Long id);

    TaskVO detailById(Long id);
}
