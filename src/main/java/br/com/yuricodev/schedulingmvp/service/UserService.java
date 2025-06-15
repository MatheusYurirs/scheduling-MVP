package br.com.yuricodev.schedulingmvp.service;

import br.com.yuricodev.schedulingmvp.entity.User;
import br.com.yuricodev.schedulingmvp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        User createUser = userRepository.save(user);
        return createUser;
    }

    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public void deleteById(Long id){
        User user =userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario com o id "+ id +" não encontrado"));
        userRepository.deleteById(id);
    }

}
