package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.ProductDto;

import java.util.List;

public interface IProductService {


    public ProductDto queryProduct(ProductDto product); //le pasamos el dto un name p.ej y el nos da toda la info
    List<ProductDto> queryAllProducts();

    int insertProduct(ProductDto product);

    int updateProduct(ProductDto product);

    int deleteProduct(ProductDto product);

}
