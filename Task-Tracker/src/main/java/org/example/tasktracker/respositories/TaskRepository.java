package org.example.tasktracker.respositories;

import org.example.tasktracker.entities.State;
import org.example.tasktracker.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByState(State state);
}
