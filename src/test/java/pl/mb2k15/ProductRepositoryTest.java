package pl.mb2k15;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by Matt on 2017-10-30.
 */
public class ProductRepositoryTest {


    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void init(){
        initMocks(this);
        productService = new ProductService(productRepository);
    }

    @Test
    public void shouldReturnAllOfProductsFromList(){
        List<ProductModel>list = getProducts();
        Mockito.when(productRepository.getByDescrription()).thenReturn(list);

        List<ProductModel> listTest = productRepository.getByDescrription();

        Assert.assertEquals(list,listTest);
        Mockito.verify(productRepository,Mockito.times(1)).getByDescrription();

    }

    private List <ProductModel> getProducts (){
        return Arrays.asList(new ProductModel.Builder("jakas_nazwa")
        .category("mediacl").build());
    }

}
