package com.teste.maven.services;

import com.teste.maven.entities.Category;
import com.teste.maven.repositories.CategoryRepository;
import com.teste.maven.services.exception.ResourceCannotBeDeleted;
import com.teste.maven.services.exception.ResourceCantBeModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository CategoryRepository;

    public List<Category> findAll(){
        return CategoryRepository.findAll();
    }

    public Category findOne(Long id){
        Optional<Category> obj = CategoryRepository.findById(id);
        return obj.get();
    }


}
