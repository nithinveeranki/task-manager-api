package com.nithin.taskmanager.repository;

import com.nithin.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findByCompleted(boolean completed, Pageable pageable);

}
