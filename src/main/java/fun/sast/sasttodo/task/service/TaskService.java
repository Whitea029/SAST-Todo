package fun.sast.sasttodo.task.service;

import fun.sast.sasttodo.task.pojo.dto.TaskQuery;
import fun.sast.sasttodo.task.pojo.dto.TaskSaveParam;
import fun.sast.sasttodo.task.pojo.dto.TaskUpdateParam;
import fun.sast.sasttodo.task.pojo.vo.TaskVO;

import java.util.List;

public interface TaskService {
    List<TaskVO> selectTask(TaskQuery taskQuery);

    void saveTask(TaskSaveParam taskSaveParam);

    void deleteTask(Long id);

    TaskVO detailById(Long id);

    void updateTask(TaskUpdateParam taskUpdateParam);
}
