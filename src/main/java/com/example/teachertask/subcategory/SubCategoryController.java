package com.example.teachertask.subcategory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/all/subCategories")
public class SubCategoryController {
    private final SubCategoriesService subCategoriesService;
    public SubCategoryController(SubCategoriesService subCategoriesService) {
        this.subCategoriesService = subCategoriesService;
    }
    @GetMapping("/{categoryId}")
    public ResponseEntity<List<SubCategory>> getSubCategoriesByCategoryId(@PathVariable int categoryId) {
        List<SubCategory> subCategories = subCategoriesService.getSubCategoriesByCategoryId(categoryId);
        return ResponseEntity.ok(subCategories);
    }
    @PostMapping("/add")
    public SubCategory addSubCategory(@RequestBody SubCategory subCategory) {
        return subCategoriesService.addSubCategory(subCategory);
    }
}
