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
    public List<Task> getTaskList() {
        return taskMapper.selectList();
    }


    // addTask

    @Override
    public void addTask(Task task) {
        taskMapper.insert(task);
    }

    // updateTask

    @Override
    public void updateTask(Task task) {
        taskMapper.update(task);
    }

    // deleteTask

    @Override
    public void deleteTask(int id) {
        taskMapper.deleteById(id);
    }

    // getTaskById

    @Override
    public Task getTaskById(int id) {
        Task taskById = taskMapper.getTaskById(id);
        return taskById;
    }
}
