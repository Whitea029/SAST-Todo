package fun.sast.sasttodo.task.service.impl;

import fun.sast.sasttodo.task.mapper.TaskMapper;
import fun.sast.sasttodo.task.pojo.dto.TaskSaveParam;
import fun.sast.sasttodo.task.pojo.dto.TaskQuery;
import fun.sast.sasttodo.task.pojo.dto.TaskUpdateParam;
import fun.sast.sasttodo.task.pojo.vo.TaskVO;
import fun.sast.sasttodo.task.pojo.entity.Task;
import fun.sast.sasttodo.task.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;
    @Override
    public List<TaskVO> selectTask(TaskQuery taskQuery){
        log.debug("查询列表:taskQuery={}",taskQuery);
        List<TaskVO> list = taskMapper.selectTask(taskQuery);
        return list;
    }

    @Override
    public void saveTask(TaskSaveParam taskSaveParam){
        log.debug("创建任务:TaskSaveParam={}",taskSaveParam);
        Task task = new Task();
        BeanUtils.copyProperties(taskSaveParam,task);
            task.setCreate_time(new Date());
            task.setStatus(1);//空闲
            task.setLast_update_time(new Date());
            taskMapper.insertTask(task);
    }
    @Override
    public void updateTask(TaskUpdateParam taskUpdateParam){
        log.debug("更新任务:TaskUpdateParam={}",taskUpdateParam);
        Task task = new Task();
        BeanUtils.copyProperties(taskUpdateParam,task);
            task.setLast_update_time(new Date());
            taskMapper.updateTask(task);
    }

    @Override
    public void deleteTask(Long id){
        log.debug("删除任务:id={}",id);
        taskMapper.deleteTask(id);
    }

    @Override
    public TaskVO detailById(Long id){
        log.debug("任务详情:id={}",id);
        TaskVO taskVO =taskMapper.detailById(id);
        return taskVO;
    }


}
