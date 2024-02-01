package com.example.BlogEngine.services;

import org.springframework.stereotype.Service;

import com.example.BlogEngine.dto.UserDTO;
import com.example.BlogEngine.entities.User;
import com.example.BlogEngine.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
        }

    public User createUser(UserDTO userDTO) {
        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setEmail(userDTO.getEmail());  
        newUser.setPassword(userDTO.getPassword());  
        newUser.setRoles(userDTO.getRoles());
        return userRepository.save(newUser);
    }
    

    public User updateUser(Long id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUsername(userDTO.getUsername());
            existingUser.setEmail(userDTO.getEmail());
            existingUser.setPassword(userDTO.getPassword());
            existingUser.setRoles(userDTO.getRoles());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("Utente da aggiornare non trovato!");
        }
    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException(" Utente da eliminare non trovato! ");
        }
    }
}

