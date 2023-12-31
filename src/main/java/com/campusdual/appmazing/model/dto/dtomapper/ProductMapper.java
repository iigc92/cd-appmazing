package com.campusdual.appmazing.model.dto.dtomapper;

import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper //indica que mapestruct la libreria lo va ejecutar
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    //necesita 3 metodos
    ProductDto toDto(Product product); //pasa de modelo a dto
    List<ProductDto> toDtoList(List<Product> products);
    Product toEntity(ProductDto productDto); //pasa de dto a modelo
}
