package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.CategoryDto;

import java.util.List;

public interface ICategoryService {

    public CategoryDto queryCategory(CategoryDto categoryDto); //le pasamos el dto (un name p.ej) y el nos da toda la info
    List<CategoryDto> queryAllCategories();

    int insertCategory(CategoryDto categoryDto);

    int updateCategory(CategoryDto categoryDto);

    int deleteCategory(CategoryDto categoryDto);
}
