package com.teste.maven.services;

import com.teste.maven.entities.Product;
import com.teste.maven.repositories.ProductRepository;
import com.teste.maven.services.exception.ResourceCantBeModifier;
import com.teste.maven.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findOne(Long id){
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public Product changePrice(Long Id,Double price){
        if(price <= 0){
            throw new ResourceCantBeModifier("Value Cant Be Less Than Zero");
        }
        Product x = findOne(Id);
        x.setPrice(price);
        return productRepository.save(x);
    }
    public Product addProduct(Product product){
        try {
            return productRepository.save(product);
        }catch (RuntimeException e){
            return null;
        }
    }
    public Product modifierProduct(Product product){
        try {
            return productRepository.save(product);
        }catch (RuntimeException e){
            return null;
        }
    }

}
