package com.niit.UserMovieServices.Services;

import UserDefinedException.UserAlreadyExistsException;
import UserDefinedException.UserNotFoundException;
import com.niit.UserMovieServices.Model.Movie;
import com.niit.UserMovieServices.Model.User;

public interface UserMovieService {

    User saveUserAndMovieDetails(User user) throws UserAlreadyExistsException;
    User updateMovieAndUserDetails(User user, String email) throws UserNotFoundException;
    User saveUserMovieToList(Movie movie, String email) throws UserNotFoundException;
}
