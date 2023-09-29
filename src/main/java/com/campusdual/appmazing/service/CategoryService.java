package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.ICategoryService;
import com.campusdual.appmazing.model.Category;
import com.campusdual.appmazing.model.dao.CategoryDao;
import com.campusdual.appmazing.model.dto.CategoryDto;
import com.campusdual.appmazing.model.dto.dtomapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CategoryService")  //indica que la clase es un service
@Lazy   //evitar sobrecarca y que cargue en cuanto se pida
public class CategoryService implements ICategoryService {

    //aurowired evita que se utilicen los geter y seteer, lo hace internamente
    @Autowired//en el momento que encuentre una interfaz, debuevle un unico elemento que busca en entre nuestro arbol de interfaces
    private CategoryDao productDao;
    @Override
    public CategoryDto queryCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDto);
        Category categoryFinal = this.productDao.getReferenceById(category.getId());
        CategoryDto dto = CategoryMapper.INSTANCE.toDto(categoryFinal);
        return dto;
    }

    @Override
    public List<CategoryDto> queryAllCategories() {
        return CategoryMapper.INSTANCE.toDtoList(this.productDao.findAll());
    }

    @Override
    public int insertCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDto);
        Category category1 = this.productDao.saveAndFlush(category);
        return category1.getId();
    }

    @Override
    public int updateCategory(CategoryDto categoryDto) {
        return this.insertCategory(categoryDto);
    }

    @Override
    public int deleteCategory(CategoryDto categoryDto) {
        int id = categoryDto.getId();
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDto);
        this.productDao.delete(category);
        return id;
    }
}
