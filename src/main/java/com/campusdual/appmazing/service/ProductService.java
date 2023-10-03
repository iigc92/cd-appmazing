package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dao.ProductDao;
import com.campusdual.appmazing.model.dto.ProductDto;
import com.campusdual.appmazing.model.dto.dtomapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("ProductService")  //indica que la clase es un service
@Lazy   //evitar sobrecarca y que cargue en cuanto se pida
public class ProductService implements IProductService {

    //aurowired evita que se utilicen los geter y seteer, lo hace internamente
    @Autowired //en el momento que enceuntre una interfaz, debuevle un unico elemento que busca en entre nuestro arbol de interfaces
    private ProductDao productDao;
    @Override
    public ProductDto queryProduct(ProductDto productDto) {
        Product product = ProductMapper.INSTANCE.toEntity(productDto);
        Product productFinal = this.productDao.getReferenceById(product.getId());
        ProductDto dto = ProductMapper.INSTANCE.toDto(productFinal);
        return dto;
    }

    @Override
    public List<ProductDto> queryAllProducts() {
        return ProductMapper.INSTANCE.toDtoList(this.productDao.findAll());
    }

    @Override
    public int insertProduct(ProductDto productDto) { //pasa todos los datos menos el id
        Product product = ProductMapper.INSTANCE.toEntity(productDto);
        Product product1 = this.productDao.saveAndFlush(product);
        return product1.getId();
    }

    @Override
    public int updateProduct(ProductDto productDto) { // devuelve todoo con el id
        return this.insertProduct(productDto);
    }

    @Override
    public int deleteProduct(ProductDto productDto) {
        int id = productDto.getId();
        Product product = ProductMapper.INSTANCE.toEntity(productDto);
        this.productDao.delete(product);
        return id;
    }

    @Override
    public int buyProduct(ProductDto product, int quantity) {
        ProductDto productToBuy = this.queryProduct(product);
        if (productToBuy.isActive() && quantity <= productToBuy.getStock()){
            productToBuy.setStock(productToBuy.getStock()-quantity);
            this.updateProduct(productToBuy);
        }
        return productToBuy.getStock();
    }

    @Override
    public BigDecimal calculateTotalPrice(ProductDto product, int quantity) {
        ProductDto productToBuy = this.queryProduct(product);
        return productToBuy.getPrice().multiply(BigDecimal.valueOf(quantity));

    }

}
