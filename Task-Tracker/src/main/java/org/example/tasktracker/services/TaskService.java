package org.example.tasktracker.services;

import org.example.tasktracker.dtos.TaskDTO;
import org.example.tasktracker.entities.State;
import org.example.tasktracker.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.tasktracker.respositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

   public Task createTask(TaskDTO task) {
        Task taskEntity = new Task();
        taskEntity.setName(task.getName());
        taskEntity.setState(task.getState());
        return this.taskRepository.save(taskEntity);
    }
    public List<Task> getAllTasks() {
        return this.taskRepository.findAll();
    }
    public List<Task> getAllByState(State state) {
        return this.taskRepository.findByState(state);
    }
    public Task getTaskById(Long id) {
        return this.taskRepository.findById(id).orElse(null);
    }
    public Task UpdateTask(Task task) {
        Task taskEntity = this.taskRepository.findById(task.getId()).orElse(null);
        taskEntity.setState(task.getState());
        taskEntity.setName(task.getName());
        return this.taskRepository.save(taskEntity);
    }
    public Boolean deleteTask(Long id) {
        this.taskRepository.deleteById(id);
        return true;

    }
}
