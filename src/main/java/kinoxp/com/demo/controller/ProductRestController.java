package kinoxp.com.demo.controller;

import kinoxp.com.demo.model.BookingsEntity;
import kinoxp.com.demo.model.ProductsEntity;
import kinoxp.com.demo.repositories.ProductRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class ProductRestController {

    @Autowired
    ProductRepository productRepository;

    //see everything in store
    @GetMapping("/products/all")
    public List<ProductsEntity> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/products/type/{productType}")
    public List<ProductsEntity> findByType(@PathVariable String productType) {
        return productRepository.getProductsByType(productType);
    }

    //create product
    @PostMapping(value="/products/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductsEntity postBooking(@RequestBody ProductsEntity product) {
        return productRepository.save(product);
    }

    @GetMapping("/products/id/{productId}")
    public ProductsEntity findById(@PathVariable int productId){
        return productRepository.getProductById(productId);
    }

    //edit product
    @PutMapping("/products/edit/{id}")
    public ResponseEntity<ProductsEntity> editBooking(@PathVariable(value="id") Integer id, @Valid @RequestBody ProductsEntity product) throws ResourceNotFoundException {
        ProductsEntity productsEntity = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("error"));

        if(product.getProductType() != null){
            productsEntity.setProductType(product.getProductType());
        }
        if(product.getProductName() != null){
            productsEntity.setProductName(product.getProductName());
        }
        if(product.getPrice() != 0){
            productsEntity.setPrice(product.getPrice());
        }

        final ProductsEntity updatedProductsEntity = productRepository.save(productsEntity);
        return ResponseEntity.ok(updatedProductsEntity);
    }

    //delete product
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/products/delete/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        try{
            productRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            System.out.println("FEJL I DELETE -" + e.getMessage());
        }
    }
}
