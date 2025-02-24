package ru.online.t1_academy.projectT1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.online.t1_academy.projectT1.dto.Task;
import ru.online.t1_academy.projectT1.exception.NullTaskException;
import ru.online.t1_academy.projectT1.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    /**
     * Создание новой задачи
     */
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        service.createTask(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    /**
     * Поиск задачи по ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        try {
            Task task = service.findTaskById(id);
            return ResponseEntity.ok(task);
        } catch (NullTaskException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Обновление задачи
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable("id") Long id) {
        try {
            Task updatedTask = service.updateTask(task, id);
            return ResponseEntity.ok(updatedTask);
        } catch (NullTaskException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Удаление задачи
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id) {
        try {
            service.deleteTaskById(id);
            return ResponseEntity.noContent().build();
        } catch (NullTaskException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Получение списка всех задач
     */
    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> tasks = service.getTasks();

        return ResponseEntity.ok(tasks);
    }
}
