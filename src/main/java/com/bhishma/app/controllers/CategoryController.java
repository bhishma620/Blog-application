package com.bhishma.app.controllers;

import com.bhishma.app.payloads.ApiResponse;
import com.bhishma.app.payloads.CategoryDto;
import com.bhishma.app.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories/")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //creating

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){

       CategoryDto createdCategory= this.categoryService.createCategory(categoryDto);

       return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
    }


    //updating

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
        CategoryDto updatedCategory=this.categoryService.updateCategory(categoryDto,categoryId);
        return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);
    }

    //deleting

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted succesfully!!",false),HttpStatus.OK);
    }


    //get single category

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
        CategoryDto category=this.categoryService.getCategory(categoryId);

        return new ResponseEntity<CategoryDto>(category,HttpStatus.OK);
    }

    //get all categories

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> categories=this.categoryService.getCategories();

        return new ResponseEntity<List<CategoryDto>>(categories,HttpStatus.OK);
    }

}
