package com.niit.UserAuthentication.Service;

import UserDefinedException.UserAlreadyExistsException;
import UserDefinedException.UserNotFoundException;
import com.niit.UserAuthentication.Model.User;
import com.niit.UserAuthentication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // for register a new user
    @Override
    public User registerAnUser(User user) throws UserAlreadyExistsException {
        if(userRepository.findById(user.getUserId()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);
    }

    // login Method
    @Override
    public User userLogin(User user) throws UserNotFoundException {
        if(userRepository.findByUserIdAndPassword(user.getUserId(), user.getPassword()) == null){
            throw new UserNotFoundException();                                                                                  // ERROR PRONE
        }
        return userRepository.findByUserIdAndPassword(user.getUserId(), user.getPassword());
    }
}
