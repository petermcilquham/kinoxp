package kinoxp.com.demo.controller;

import kinoxp.com.demo.model.ProductsEntity;
import kinoxp.com.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class ProductRestController {

    @Autowired
    ProductRepository productRepository;

    //see everything in store
    @GetMapping("/products/type/all")
    public List<ProductsEntity> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/products/type/{productType}")
    public List<ProductsEntity> findByType(@PathVariable String productType) {
        return productRepository.getProductsByType(productType);
    }

    @GetMapping("/products/id/{productId}")
    public ProductsEntity findById(@PathVariable int productId){
        return productRepository.getProductById(productId);
    }
}
