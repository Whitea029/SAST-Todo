package fun.sast.sasttodo.service.impl;

import fun.sast.sasttodo.entity.Task;
import fun.sast.sasttodo.mapper.TaskMapper;
import fun.sast.sasttodo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    // getTaskList
    @Override
    public List<Task> getTaskList(){
        return taskMapper.selectAll();
    }

    //getTaskById
    @Override
    public Task getTaskById(int id){return taskMapper.selectById(id);}

    // addTask
    @Override
    public void addTask(Task task) {
        taskMapper.insertTask(task);
    }

    // updateTask
    @Override
    public void updateTask(Task task){
        taskMapper.updateTask(task);
    }

    // deleteTask
    @Override
    public void deleteTask(Long id){
        taskMapper.deleteById(id);
    }

}
