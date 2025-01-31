package com.example.teachertask.task;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


    List<Task> findByCategory_CategoryName(String category);

    List<Task> findBySubCategory_SubCategoryName(String subCategoryName);

}
