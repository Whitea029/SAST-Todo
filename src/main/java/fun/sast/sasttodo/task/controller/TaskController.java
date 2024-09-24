package fun.sast.sasttodo.task.controller;

import fun.sast.sasttodo.base.response.JsonResult;
import fun.sast.sasttodo.task.pojo.dto.TaskQuery;
import fun.sast.sasttodo.task.pojo.dto.TaskSaveParam;
import fun.sast.sasttodo.task.pojo.dto.TaskUpdateParam;
import fun.sast.sasttodo.task.pojo.vo.TaskVO;
import fun.sast.sasttodo.task.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("select")
    public JsonResult selectTask(TaskQuery taskQuery) {
        log.debug("查询列表,taskQuery={}", taskQuery);
        List<TaskVO> list = taskService.selectTask(taskQuery);
        return JsonResult.ok(list);
    }

    @PostMapping("save")
    public JsonResult saveTask(TaskSaveParam taskSaveParam) {
        log.debug("保存任务,taskSaveParam={}", taskSaveParam);
        taskService.saveTask(taskSaveParam);
        return JsonResult.ok(taskSaveParam);
    }

    @PostMapping("delete/{id}")
    public JsonResult deleteTask(@PathVariable Long id) {
        log.debug("删除任务,id={}", id);
        taskService.deleteTask(id);
        return JsonResult.ok();
    }

    @GetMapping("detail")
    public JsonResult detailTask(@RequestParam("id") Long id) {
        log.debug("任务详情,id={}", id);
        TaskVO taskVO =taskService.detailById(id);
        return JsonResult.ok(taskVO);
    }

    @PostMapping("update")
    public JsonResult updateTask(TaskUpdateParam taskUpdateParam) {
        log.debug("更新任务,taskUpdateParam={}", taskUpdateParam);
        return JsonResult.ok();
    }
}
