package fun.sast.sasttodo.controller;

import fun.sast.sasttodo.entity.Task;
import fun.sast.sasttodo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    List<Task> getTaskList() {

        return taskService.getTaskList();
    }

    @GetMapping("/{id}")
    Task getTask(@PathVariable int id) {

        return taskService.getTaskById(id);
    }

    @PostMapping
    void addTask(@RequestBody Task todo) {

        taskService.addTask(todo);
    }

    @PutMapping
    void updateTask(@RequestBody Task todo) {

        taskService.updateTask(todo);
    }

    @DeleteMapping
    void deleteTask(@RequestBody Task todo) {

        taskService.deleteTask(todo.getId());
    }


}
