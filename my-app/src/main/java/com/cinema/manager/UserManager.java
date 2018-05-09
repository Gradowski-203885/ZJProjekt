package com.cinema.manager;

import com.cinema.model.User;
import com.cinema.repository.UserRepository;
import com.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User getUser(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public Long updateUser(User user) {
        User toUpdate = userRepository.findOne(user.getId());
        toUpdate.setEmail(user.getEmail());
        toUpdate.setFirstName(user.getFirstName());
        toUpdate.setLastName(user.getLastName());
        toUpdate.setPassword(user.getPassword());
        toUpdate.setPhoneNumber(user.getPhoneNumber());
        toUpdate.setTickets(user.getTickets());

        return userRepository.save(toUpdate).getId();
    }

    @Override
    public Long addUser(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
