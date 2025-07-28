package com.teste.maven.resources;

import com.teste.maven.entities.Product;
import com.teste.maven.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class resourceProduct {

    @Autowired
    private ProductService service;


    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> lista = service.findAll();

        return ResponseEntity.ok().body(lista);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findOne(@PathVariable Long id) {
        Product Product = service.findOne(id);
        return ResponseEntity.ok().body(Product);
    }
}