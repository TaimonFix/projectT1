package ru.online.t1_academy.projectT1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.online.t1_academy.projectT1.dto.Task;
import ru.online.t1_academy.projectT1.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    /**
     * Создание новой задачи
     */
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return service.createTask(task);
    }

    /**
     * Поиск задачи по ID
     */
    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return service.findTaskById(id);
    }

    /**
     * Обновление задачи
     */
    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable("id") Long id) {
        return service.updateTask(task, id);
    }

    /**
     * Удаление задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        service.deleteTaskById(id);
    }

    /**
     * Получение списка всех задач
     */
    @GetMapping
    public List<Task> getTasks() {
        return service.getTasks();
    }
}
