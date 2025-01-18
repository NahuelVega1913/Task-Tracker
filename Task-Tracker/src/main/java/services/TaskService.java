package services;

import entities.State;
import entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import respositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

   public Task createTask(Task task) {
        return this.taskRepository.save(task);
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
