package com.yousfi.taskmanagement.service;

import com.yousfi.taskmanagement.model.Task;
import com.yousfi.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    public List<Task> findByDescriptionContaining(String keyword) {
        return taskRepository.findByDescriptionContaining(keyword);
    }

    public List<Task> findByCompleted(boolean completed) {
        return taskRepository.findByCompleted(completed);
    }

    public List<Task> findByAssigneeId(Long assigneeId) {
        return taskRepository.findByAssigneeId(assigneeId);
    }

    public List<Task> findByDueDateBefore(String dueDate) {
        LocalDate localDate = LocalDate.parse(dueDate);
        return taskRepository.findByDueDateBefore(localDate);
    }

    public List<Task> findByDueDateAfter(String dueDate) {
        LocalDate localDate = LocalDate.parse(dueDate); // Parse String to LocalDate
        return taskRepository.findByDueDateAfter(localDate);
    }

    public List<Task> findByDueDateBetween(String startDate, String endDate) {
        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);
        return taskRepository.findByDueDateBetween(startLocalDate, endLocalDate);
    }

    public List<Task> findByPriority(String priority) {
        return taskRepository.findByPriority(priority);
    }
}
