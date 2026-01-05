package org.example.gestion_de_budget.service;

import org.example.gestion_de_budget.model.User;
import org.example.gestion_de_budget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User createUser(User user){
        return userRepository.save(user);
    }
    public List<User>getALLusers(){
        return userRepository.findAll();
    }
   public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    public User updateUser(Long id, User user){
        return userRepository.save(user);
   } public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
