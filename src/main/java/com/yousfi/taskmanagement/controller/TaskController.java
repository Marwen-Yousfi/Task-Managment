package com.yousfi.taskmanagement.controller;

import com.yousfi.taskmanagement.model.Task;
import com.yousfi.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/by-title/{title}")
    public List<Task> getTasksByTitle(@PathVariable String title) {
        return taskService.findByTitle(title);
    }

    @GetMapping("/by-description/{keyword}")
    public List<Task> getTasksByDescription(@PathVariable String keyword) {
        return taskService.findByDescriptionContaining(keyword);
    }

    @GetMapping("/by-completed/{completed}")
    public List<Task> getTasksByCompletionStatus(@PathVariable boolean completed) {
        return taskService.findByCompleted(completed);
    }

    @GetMapping("/by-assignee/{assigneeId}")
    public List<Task> getTasksByAssignee(@PathVariable Long assigneeId) {
        return taskService.findByAssigneeId(assigneeId);
    }

    @GetMapping("/by-due-date-before/{dueDate}")
    public List<Task> getTasksDueDateBefore(@PathVariable String dueDate) {
        return taskService.findByDueDateBefore(dueDate);
    }

    @GetMapping("/by-due-date-after/{dueDate}")
    public List<Task> getTasksDueDateAfter(@PathVariable String dueDate) {
        return taskService.findByDueDateAfter(dueDate);
    }

    @GetMapping("/by-due-date-between/{startDate}/{endDate}")
    public List<Task> getTasksDueDateBetween(@PathVariable String startDate, @PathVariable String endDate) {
        return taskService.findByDueDateBetween(startDate, endDate);
    }

    @GetMapping("/by-priority/{priority}")
    public List<Task> getTasksByPriority(@PathVariable String priority) {
        return taskService.findByPriority(priority);
    }
}
