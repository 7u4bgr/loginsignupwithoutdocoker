package com.example.teachertask.subcategory;

import com.example.teachertask.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubCategoriesRepository extends JpaRepository<SubCategory, Integer> {



    List<SubCategory> findByCategoryId(int categoryId);




    List<SubCategory> findBySubCategoryNameAndCategory(String subCategoryName, Category category);

}
