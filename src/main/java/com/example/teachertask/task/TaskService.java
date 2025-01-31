package com.example.teachertask.task;

import com.example.teachertask.allusers.User;
import com.example.teachertask.allusers.UserRepository;
import com.example.teachertask.category.Category;
import com.example.teachertask.category.CategoryRepository;
import com.example.teachertask.subcategory.SubCategoriesRepository;
import com.example.teachertask.subcategory.SubCategory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;
    private final SubCategoriesRepository subCategoriesRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, CategoryRepository categoryRepository, SubCategoriesRepository subCategoriesRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
        this.subCategoriesRepository = subCategoriesRepository;
        this.userRepository = userRepository;
    }

    public Task createTask(TaskDTO taskDTO, Long userId) {
        User user = userRepository.findById(userId).get();
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Category category = categoryRepository.findByCategoryName(taskDTO.getCategoryName());

        List<SubCategory> subCategories = subCategoriesRepository.findBySubCategoryNameAndCategory(
                taskDTO.getSubCategoryName(), category
        );
        if (subCategories.isEmpty()) {
            throw new RuntimeException("SubCategory not found");
        }
        if (subCategories.size() > 1) {
            throw new RuntimeException("Multiple SubCategories found for the given name and category");
        }
        SubCategory subCategory = subCategories.get(0);
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setPrice(taskDTO.getPrice());
        task.setCategory(category);
        task.setSubCategory(subCategory);
        task.setUsers(user);
        return taskRepository.save(task);
    }


    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> taskDTOs = new ArrayList<>();
        for (Task task : tasks) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setTitle(task.getTitle());
            taskDTO.setDescription(task.getDescription());
            taskDTO.setPrice(task.getPrice());
            if (task.getCategory() != null) {
                taskDTO.setCategoryName(task.getCategory().getCategoryName());
            } else {
                taskDTO.setCategoryName("Kategori Yok");
            }

            if (task.getSubCategory() != null) {
                taskDTO.setSubCategoryName(task.getSubCategory().getSubCategoryName());
            } else {
                taskDTO.setSubCategoryName("Alt Kategori Yok");
            }

            taskDTOs.add(taskDTO);
        }

        return taskDTOs;
    }


    public void deleteTaskById(Long taskId, Long userId) {
        User user = userRepository.findById(userId).get();
        Task task = taskRepository.findById(taskId).get();
        if (!task.getUsers().getId().equals(user.getId())) {
            throw new RuntimeException("You are not allowed to delete this task");
        }
        taskRepository.deleteById(taskId);
    }

    public Task updateTask(Long userId, Long taskId, Task taskDTO) {
        User user = userRepository.findById(userId).get();
        Task taskToUpdate = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));
        if (!taskToUpdate.getUsers().getId().equals(userId)) {
            throw new RuntimeException("You do not have permission to update this task!");
        }
        taskToUpdate.setTitle(taskDTO.getTitle());
        taskToUpdate.setDescription(taskDTO.getDescription());
        taskToUpdate.setPrice(taskDTO.getPrice());

        return taskRepository.save(taskToUpdate);
    }




    public List<Task> getTasksByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return user.getTasks();
    }

    public List<TaskDTO> getTaskByCategory(String categoryName) {
        List<Task> tasks = taskRepository.findByCategory_CategoryName(categoryName);
        List<TaskDTO> taskDTOs = new ArrayList<>();
        for (Task task : tasks) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setTitle(task.getTitle());
            taskDTO.setDescription(task.getDescription());
            taskDTO.setPrice(task.getPrice());
            if (task.getCategory() != null) {
                taskDTO.setCategoryName(task.getCategory().getCategoryName());

            }
            if (task.getSubCategory() != null) {
                taskDTO.setSubCategoryName(task.getSubCategory().getSubCategoryName());
            } else {
                taskDTO.setSubCategoryName("Alt Kategori Yok");
            }
            taskDTOs.add(taskDTO);
        }
        return taskDTOs;
    }



    public List<TaskDTO> getTaskBySubCategoryName(String subCategoryName) {
        List<Task> tasks = taskRepository.findBySubCategory_SubCategoryName(subCategoryName);

        return tasks.stream().map(task -> {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setTitle(task.getTitle());
            taskDTO.setDescription(task.getDescription());
            taskDTO.setPrice(task.getPrice());

            if (task.getCategory() != null) {
                taskDTO.setCategoryName(task.getCategory().getCategoryName());
            }
            if (task.getSubCategory() != null) {
                taskDTO.setSubCategoryName(task.getSubCategory().getSubCategoryName());
            }
            return taskDTO;
        }).collect(Collectors.toList());
    }

    public TaskDTO getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setPrice(task.getPrice());


        if (task.getCategory() != null) {
            taskDTO.setCategoryName(task.getCategory().getCategoryName());
        } else {
            taskDTO.setCategoryName("Kategori Yok");
        }


        if (task.getSubCategory() != null) {
            taskDTO.setSubCategoryName(task.getSubCategory().getSubCategoryName());
        } else {
            taskDTO.setSubCategoryName("Alt Kategori Yok");
        }

        return taskDTO;
    }

}

