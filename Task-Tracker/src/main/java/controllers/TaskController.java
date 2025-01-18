package controllers;

import entities.State;
import entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/task-tracker")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @PostMapping("/create")
    public ResponseEntity<Task> postTask(@RequestBody Task task) {
        Task taskEntity = this.taskService.createTask(task);
        return ResponseEntity.ok(taskEntity);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = this.taskService.getAllTasks();
        if(tasks.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(tasks);
        }
    }

    @GetMapping("/all/{state}")
    public ResponseEntity<List<Task>> getAllByState(@PathVariable State state) {
        List<Task> tasks = this.taskService.getAllByState(state);
        if(tasks.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(tasks);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = this.taskService.getTaskById(id);
        if(task == null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(task);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        Task taskEntity = this.taskService.UpdateTask(task);
        return ResponseEntity.ok(taskEntity);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id) {
        Boolean isDeleted = this.taskService.deleteTask(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        else{
            this.taskService.deleteTask(id);
            return ResponseEntity.ok().build();
        }
    }




}
