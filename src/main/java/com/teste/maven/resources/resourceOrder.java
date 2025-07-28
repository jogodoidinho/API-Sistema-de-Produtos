package com.teste.maven.resources;

import com.teste.maven.entities.Order;
import com.teste.maven.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class resourceOrder {

    @Autowired
    private OrderService service;


    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> lista = service.findAll();

        return ResponseEntity.ok().body(lista);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findOne(@PathVariable Long id){
        Order Order = service.findOne(id);
        return ResponseEntity.ok().body(Order);
    }


}