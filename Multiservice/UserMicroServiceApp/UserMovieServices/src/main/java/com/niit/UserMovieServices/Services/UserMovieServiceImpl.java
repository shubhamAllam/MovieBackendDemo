package com.niit.UserMovieServices.Services;

import UserDefinedException.UserAlreadyExistsException;
import UserDefinedException.UserNotFoundException;
import com.niit.UserMovieServices.Configuration.Producer;
import com.niit.UserMovieServices.Model.Movie;
import com.niit.UserMovieServices.Model.User;
import com.niit.UserMovieServices.Proxy.UserAuthProxy;
import com.niit.UserMovieServices.RabbitMqModel.UserMovieDTO;
import com.niit.UserMovieServices.Repository.UserAndMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserMovieServiceImpl implements UserMovieService {

    private UserAndMovieRepository userAndMovieRepository;
    private UserAuthProxy userAuthProxy;
    private Producer producer;
    @Autowired
    public UserMovieServiceImpl(UserAndMovieRepository userAndMovieRepository, UserAuthProxy userAuthProxy, Producer producer){
        this.userAndMovieRepository = userAndMovieRepository;
        this.userAuthProxy = userAuthProxy;
        this.producer = producer;
    }

    // method for saving details of movie and user for first time
    @Override
    public User saveUserAndMovieDetails(User user) throws UserAlreadyExistsException {

        UserMovieDTO userDTO = new UserMovieDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        userDTO.setPassword(user.getPassword());

        if(userAndMovieRepository.findById(user.getEmail()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        //
        else{
            userAndMovieRepository.save(user);
            producer.sendMsgToRabbitMqServer(userDTO);
        }
        return user;
        //
        /*ResponseEntity<?> response = userAuthProxy.registerAnUser(user);
        if(response.getStatusCodeValue() == 200){
            return userAndMovieRepository.save(user);
        }else{
            return null;
        }*/
        //return userAndMovieRepository.save(user);
    }

    // method for editing user amd movie Details
    @Override
    public User updateMovieAndUserDetails(User user, String email) throws UserNotFoundException {
        if(userAndMovieRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        return userAndMovieRepository.save(user);
    }

    @Override
    public User saveUserMovieToList(Movie movie, String email) throws UserNotFoundException {
        if(userAndMovieRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        User user = userAndMovieRepository.findByEmail(email);
        if(user.getMovieList() == null){
            user.setMovieList(Arrays.asList(movie));
        }else {
            List<Movie> movies = user.getMovieList();
            movies.add(movie);
            user.setMovieList(movies);
        }
        return userAndMovieRepository.save(user);
    }
}
