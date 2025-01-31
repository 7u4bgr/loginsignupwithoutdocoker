package com.example.teachertask.task;



import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private String price;
    private String categoryName;
    private String subCategoryName;
}
