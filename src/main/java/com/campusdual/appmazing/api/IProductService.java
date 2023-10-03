package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.ContactoDto;
import com.campusdual.appmazing.model.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;

public interface IProductService {


    public ProductDto queryProduct(ProductDto productDto); //le pasamos el dto un name p.ej y el nos da toda la info
    List<ProductDto> queryAllProducts();

    int insertProduct(ProductDto productDto);

    int updateProduct(ProductDto productDto);

    int deleteProduct(ProductDto productDto);
    int buyProduct(ProductDto product, int quantity);
    BigDecimal calculateTotalPrice(ProductDto product, int quantity);

}
