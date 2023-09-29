package com.campusdual.appmazing.model.dto.dtomapper;

import com.campusdual.appmazing.model.Category;
import com.campusdual.appmazing.model.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper //indica que que la libreria mapestruct lo va ejecutar, se necesita hacer clear instal despues de crear el mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    //necesita 3 metodos
    CategoryDto toDto(Category category);               //pasa de modelo a dto
    List<CategoryDto> toDtoList(List<Category> category);
    Category toEntity(CategoryDto categoryDto);        //pasa de dto a modelo
}
