package com.niit.UserMovieServices.Services;

import UserDefinedException.UserAlreadyExistsException;
import UserDefinedException.UserNotFoundException;
import com.niit.UserMovieServices.Model.User;
import com.niit.UserMovieServices.Repository.UserAndMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMovieServiceImpl implements UserMovieService {

    private UserAndMovieRepository userAndMovieRepository;
    @Autowired
    public UserMovieServiceImpl(UserAndMovieRepository userAndMovieRepository){
        this.userAndMovieRepository = userAndMovieRepository;
    }

    // method for saving details of movie and user for first time
    @Override
    public User saveUserAndMovieDetails(User user) throws UserAlreadyExistsException {
        if(userAndMovieRepository.findById(user.getEmail()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        return userAndMovieRepository.save(user);
    }

    // method for editing user amd movie Details
    @Override
    public User updateMovieAndUserDetails(User user, String email) throws UserNotFoundException {
        if(userAndMovieRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        return userAndMovieRepository.save(user);
    }
}
