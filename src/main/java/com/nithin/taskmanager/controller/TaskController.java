package com.nithin.taskmanager.controller;


import com.nithin.taskmanager.model.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;




import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    public TaskController() {
        tasks.add(new Task(1L, "Learn Spring Boot", "Build first REST API", false));
        tasks.add(new Task(2L, "Prepare DSA", "Practice arrays and strings", false));
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return tasks;
    }
    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        task.setId((long) (tasks.size() + 1));
        tasks.add(task);
        return task;
    }
    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                task.setCompleted(updatedTask.isCompleted());
                return task;
            }
        }
        return null;
    }
    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
        return "Task deleted successfully";
    }



}

