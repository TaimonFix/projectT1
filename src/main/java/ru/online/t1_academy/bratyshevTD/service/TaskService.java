package ru.online.t1_academy.bratyshevTD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.online.t1_academy.bratyshevTD.dto.Task;
import ru.online.t1_academy.bratyshevTD.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;


    public void createTask(Task task) {
        repository.save(task);
    }

    public Task findTaskById(Long id) {
        return repository.getReferenceById(id);
    }

    public Task updateTask(Task task, Long id) {
        Task updatedTask = repository.getReferenceById(id);
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setUserId(task.getUserId());
        return repository.save(updatedTask);
    }

    public void deleteTaskById(Long id) {
        repository.deleteById(id);
    }


    public List<Task> getTasks() {
        return repository.findAll();
    }
}
