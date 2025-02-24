package ru.online.t1_academy.projectT1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.online.t1_academy.projectT1.aspect.annotation.CustomLogging;
import ru.online.t1_academy.projectT1.aspect.annotation.ExampleAnnotation;
import ru.online.t1_academy.projectT1.dto.Task;
import ru.online.t1_academy.projectT1.example.NullTaskException;
import ru.online.t1_academy.projectT1.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    @CustomLogging
    public void createTask(Task task) {
        repository.save(task);
    }

    @CustomLogging
    public Task findTaskById(Long id) {
        return repository.getReferenceById(id);
    }

    @CustomLogging
    @ExampleAnnotation
    public Task updateTask(Task task, Long id) {

        throw new NullTaskException("Task doesn't exists");
//        Task updatedTask = repository.getReferenceById(id);
//        updatedTask.setTitle(task.getTitle());
//        updatedTask.setDescription(task.getDescription());
//        updatedTask.setUserId(task.getUserId());
//        return repository.save(updatedTask);
    }

    @CustomLogging
    public void deleteTaskById(Long id) {
        repository.deleteById(id);
    }

    @CustomLogging
    public List<Task> getTasks() {
        return repository.findAll();
    }
}
