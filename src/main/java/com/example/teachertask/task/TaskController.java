package com.example.teachertask.task;



import com.example.teachertask.favorites.Favorites;
import com.example.teachertask.favorites.FavoritesService;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;
    private final FavoritesService favoritesService;



    public TaskController(TaskService taskService, FavoritesService favoritesService) {
        this.taskService = taskService;
        this.favoritesService = favoritesService;
    }

    @PostMapping("/createTask/{userId}")
    public Task createTask(@RequestBody TaskDTO taskDTO,@PathVariable Long userId) {
      return taskService.createTask(taskDTO,userId);
    }
    @GetMapping("/get/{userId}")
    public List<Task> getTasksByUserId(@PathVariable Long userId) {
        return taskService.getTasksByUserId(userId);
    }

    @GetMapping("/allTask")
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/remove/{userId}/{taskId}")
    public void deleteTaskById(@PathVariable Long taskId,@PathVariable Long userId) {
        taskService.deleteTaskById(taskId,userId);
    }

    @PutMapping("/updateTask/{userId}/{taskId}")
    public Task updateTask(@PathVariable Long userId, @PathVariable Long taskId,@RequestBody Task taskDTO) {
        return taskService.updateTask(userId, taskId,taskDTO);
    }

    @GetMapping("/details/{taskId}")
    public TaskDTO getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/task/categories/{categoryName}")
    public List<TaskDTO> getTasksByCategory(@PathVariable String categoryName) {
        return taskService.getTaskByCategory(categoryName);
    }

    @GetMapping("/categories/sub/{subCategoryName}")
    public List<TaskDTO> getTaskBySubCategoryName(@PathVariable String subCategoryName) {
        return taskService.getTaskBySubCategoryName(subCategoryName);
    }
}
