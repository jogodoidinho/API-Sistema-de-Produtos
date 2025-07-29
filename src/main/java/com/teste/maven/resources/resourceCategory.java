package com.teste.maven.resources;

import com.teste.maven.entities.Category;
import com.teste.maven.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class resourceCategory {

    @Autowired
    private CategoryService service;


    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> lista = service.findAll();

        return ResponseEntity.ok().body(lista);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findOne(@PathVariable Long id){
        Category Category = service.findOne(id);
        return ResponseEntity.ok().body(Category);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody @Valid Category category){
        Category x = service.create(category);
        return ResponseEntity.ok().body(x);
    }
}