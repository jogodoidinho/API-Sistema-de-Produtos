package com.teste.maven.services;

import com.teste.maven.entities.Order;
import com.teste.maven.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository OrderRepository;

    public List<Order> findAll(){
        return OrderRepository.findAll();
    }

    public Order findOne(Long id){
        Optional<Order> obj = OrderRepository.findById(id);
        return obj.get();
    }
}
