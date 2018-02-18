package pl.mb2k15;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Matt on 2015-10-04.
 */
@Service
public interface ProductRepository extends CrudRepository <ProductModel , Integer > {

    @Query("select p from ProductModel p where p.price > 1000")
    List<ProductModel> getByDescrription();

}
