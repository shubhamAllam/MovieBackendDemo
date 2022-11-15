package com.niit.UserAuthentication.Service;

import UserDefinedException.UserAlreadyExistsException;
import UserDefinedException.UserNotFoundException;
import com.niit.UserAuthentication.model.User;

public interface UserService {

    User registerAnUser(User user) throws UserAlreadyExistsException;
    User userLogin(User user) throws UserNotFoundException;
}
