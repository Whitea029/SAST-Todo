package fun.sast.sasttodo.service;

import fun.sast.sasttodo.entity.Task;

import java.util.List;

public interface TaskService {

    // getTaskList
    List<Task> getTaskList();

    //getTaskById
    Task getTaskById(int id);

    // addTask
    void addTask(Task task);

    // updateTask
    void updateTask(Task task);

    // deleteTask
    void deleteTask(Long id);

}
