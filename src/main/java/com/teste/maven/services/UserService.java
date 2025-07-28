package com.teste.maven.services;

import com.teste.maven.entities.User;
import com.teste.maven.repositories.UserRepository;
import com.teste.maven.services.exception.ResourceCannotBeDeleted;
import com.teste.maven.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findOne(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user ){
        return userRepository.save(user);
    }

    public void delete(Long id ){
        try {
            findOne(id);
            userRepository.deleteById(id);
        }
        catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new ResourceCannotBeDeleted(id);
        }
    }

    public User update(Long id,User user){
        try{
            User entite = userRepository.getReferenceById(id);
            updatedata(entite,user);
            return userRepository.save(entite);

        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }


    }

    public void updatedata(User ent,User user){
        ent.setName(user.getName());
        ent.setEmail(user.getEmail());
        ent.setPhone(user.getPhone());
    }
}
