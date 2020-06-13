package com.agileflorin.ppmtool.services;

import com.agileflorin.ppmtool.domain.User;
import com.agileflorin.ppmtool.exceptions.UsernameAlreadyExistsException;
import com.agileflorin.ppmtool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User newUser) {
        try {
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

            newUser.setPassword(newUser.getPassword());
			newUser.setUsername(newUser.getUsername());
            newUser.setConfirmPassword("");

            return userRepository.save(newUser);

        } catch(Exception e) {
            throw new UsernameAlreadyExistsException("Username '"+newUser.getUsername()+ "' already exists");
        }
    }
}
