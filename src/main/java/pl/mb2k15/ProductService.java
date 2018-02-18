package pl.mb2k15;

import java.util.List;

/**
 * Created by Matt on 2017-10-30.
 */
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    List<ProductModel> getByDescrription(){return productRepository.getByDescrription();}

}
