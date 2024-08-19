package fun.sast.sasttodo.service;

import fun.sast.sasttodo.entity.Task;

import java.util.List;

public interface TaskService {

    // getTaskList

    public List<Task> getTaskList();

    // addTask

    public void addTask(Task task);

    // updateTask

    public void updateTask(Task task);

    // deleteTask

    public void deleteTask(int id);

    // getTaskById

    public Task getTaskById(int id);

}
