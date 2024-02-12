package com.bhishma.app.services.impl;

import com.bhishma.app.entities.Category;
import com.bhishma.app.exceptions.ResourceNotFoundException;
import com.bhishma.app.payloads.CategoryDto;
import com.bhishma.app.repositories.CategoryRepo;
import com.bhishma.app.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category=this.modelMapper.map(categoryDto,Category.class);
        Category createdCategory=this.categoryRepo.save(category);

        return this.modelMapper.map(createdCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
       Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category ","Category Id",categoryId));

       category.setCategoryTitle(categoryDto.getCategoryTitle());
       category.setCategoryDescription(category.getCategoryDescription());
      Category updatedCategory= this.categoryRepo.save(category);
       return this.modelMapper.map(updatedCategory, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {

      Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category ","category id",categoryId));
      this.categoryRepo.delete(category);

    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {

        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category ","category id",categoryId));

        return this.modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category>categories=this.categoryRepo.findAll();



        List<CategoryDto>categoryDtos= categories.stream().map((category) ->
           this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());

        return categoryDtos;
    }


}
