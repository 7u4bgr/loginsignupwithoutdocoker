package com.example.teachertask.subcategory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoriesService {
    private final SubCategoriesRepository subCategoriesRepository;
    public SubCategoriesService(SubCategoriesRepository subCategoriesRepository) {
        this.subCategoriesRepository = subCategoriesRepository;
    }





    public List<SubCategory> getSubCategoriesByCategoryId(int categoryId) {
        return subCategoriesRepository.findByCategoryId(categoryId);
    }

    public SubCategory addSubCategory(SubCategory subCategory) {
        return subCategoriesRepository.save(subCategory);
    }
}
