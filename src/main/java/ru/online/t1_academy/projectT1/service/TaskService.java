package ru.online.t1_academy.projectT1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.online.t1_academy.projectT1.aspect.annotation.CustomLogging;
import ru.online.t1_academy.projectT1.aspect.annotation.ExceptionAnnotation;
import ru.online.t1_academy.projectT1.aspect.annotation.TrackingAnnotation;
import ru.online.t1_academy.projectT1.dto.Task;
import ru.online.t1_academy.projectT1.exception.NullTaskException;
import ru.online.t1_academy.projectT1.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    @CustomLogging
    @TrackingAnnotation
    public void createTask(Task task) {
        repository.save(task);
    }

    @CustomLogging
    @ExceptionAnnotation
    @TrackingAnnotation
    public Task findTaskById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NullTaskException("Task doesn't exists"));
    }

    @CustomLogging
    @ExceptionAnnotation
    @TrackingAnnotation
    public Task updateTask(Task task, Long id) {
        Task updatedTask = repository.findById(id)
                .orElseThrow(() -> new NullTaskException("Task doesn't exists"));
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setUserId(task.getUserId());
        return repository.save(updatedTask);
    }

    @CustomLogging
    @ExceptionAnnotation
    @TrackingAnnotation
    public void deleteTaskById(Long id) {
        if (!repository.existsById(id)) {
            throw new NullTaskException("Task doesn't exists");
        }
        repository.deleteById(id);
    }

    @CustomLogging
    @TrackingAnnotation
    public List<Task> getTasks() {
        return repository.findAll();
    }
}
