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
        // todo
        return null;
    }

    @PostMapping
    void addTask(@RequestBody Task todo) {
        // todo
    }

    @PutMapping
    void updateTask(@RequestBody Task todo) {
        // todo
    }

    @DeleteMapping
    void deleteTask(@RequestBody Task todo) {
        // todo
    }


}
