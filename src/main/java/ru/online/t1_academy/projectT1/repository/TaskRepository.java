package ru.online.t1_academy.projectT1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.online.t1_academy.projectT1.dto.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
