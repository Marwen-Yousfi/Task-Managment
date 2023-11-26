package com.yousfi.taskmanagement.repository;

import com.yousfi.taskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {


    // Custom query method to find tasks by title
    List<Task> findByTitle(String title);

    // Custom query method to find tasks by description containing a certain keyword
    List<Task> findByDescriptionContaining(String keyword);

    // Custom query method to find tasks by completion status
    List<Task> findByCompleted(boolean completed);

    // Custom query method to find tasks assigned to a specific user
    List<Task> findByAssigneeId(Long assigneeId);

    // Custom query method to find tasks with a due date before a specified date
    List<Task> findByDueDateBefore(LocalDate dueDate);

    // Custom query method to find tasks with a due date after a specified date
    List<Task> findByDueDateAfter(LocalDate dueDate);

    // Custom query method to find tasks with a due date between two specified dates
    List<Task> findByDueDateBetween(LocalDate startDate, LocalDate endDate);

    // Custom query method to find tasks with a specified priority level
    List<Task> findByPriority(String priority);
}
