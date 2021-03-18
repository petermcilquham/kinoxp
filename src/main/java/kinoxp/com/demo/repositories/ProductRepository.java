package kinoxp.com.demo.repositories;

import kinoxp.com.demo.model.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductsEntity, Integer> {

    //get All products by type of product (merch, sweet, drink and food)
    @Query("FROM ProductsEntity WHERE productType like %?1%")
    List<ProductsEntity> getProductsByType(String productType);

    @Query("FROM ProductsEntity WHERE productId = ?1")
    ProductsEntity getProductById(int productId);
}
