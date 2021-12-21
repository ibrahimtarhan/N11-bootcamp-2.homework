package com.tarhan.springboot.controller;

import com.tarhan.springboot.converter.CategoryConverter;
import com.tarhan.springboot.dto.CategoryDTO;
import com.tarhan.springboot.entity.Category;
import com.tarhan.springboot.entityService.CategoryEntityService;
import com.tarhan.springboot.entityService.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private ProductEntityService productEntityService;

//    @GetMapping("")
//    public String hello(){
//        return "Hello world";
//    }
    @GetMapping("")
    public List<CategoryDTO> findAll(){

        List<Category> categoryList = categoryEntityService.findAll();

        List<CategoryDTO> categoryDTOList = CategoryConverter.INSTANCE.convertAllCategoryListToCategoryDTOList(categoryList);

        return categoryDTOList;
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){

        Category category = categoryEntityService.findById(id);

        return category;
    }


}
