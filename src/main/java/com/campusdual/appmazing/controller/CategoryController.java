package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.ICategoryService;
import com.campusdual.appmazing.model.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories") //controlador de esta clase
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String testController(){
        return "Category controller works";
    }

    @PostMapping
    public String testController(@RequestBody String name){
        return "Category controller works, " + name + "!";
    }

    @GetMapping(value = "/testMethod")
    public String testControllerMethod(){
        return "Category controller method works";
    }

    @PostMapping(value="/get")
    public CategoryDto QueryCategory(@RequestBody CategoryDto category){
        return this.categoryService.queryCategory(category);
    }

    @GetMapping(value="/getAll")
    public List<CategoryDto> queryAllCategories(){
        return this.categoryService.queryAllCategories();
    }

    @PostMapping(value="/add")
    public int insertCategory(@RequestBody CategoryDto category){
        return this.categoryService.insertCategory(category);
    }

    @PutMapping(value = "/update")
    public int updateCategory(@RequestBody CategoryDto category){
        return this.categoryService.updateCategory(category);
    }

    @DeleteMapping(value = "/delete")
    public int deleteCategory(@RequestBody CategoryDto category){
        return this.categoryService.deleteCategory(category);
    }
}
