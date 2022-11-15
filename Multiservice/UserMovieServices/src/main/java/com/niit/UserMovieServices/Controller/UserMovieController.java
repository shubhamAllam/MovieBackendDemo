package com.niit.UserMovieServices.Controller;

import UserDefinedException.UserAlreadyExistsException;
import UserDefinedException.UserNotFoundException;
import com.niit.UserMovieServices.Model.User;
import com.niit.UserMovieServices.Services.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/app/services/")
public class UserMovieController {

    private UserMovieService userMovieService;
    private ResponseEntity responseEntity;

    @Autowired
    public UserMovieController(UserMovieService userMovieService){
        this.userMovieService = userMovieService;
    }

    @PostMapping("user")
    public ResponseEntity<?> createUser(@RequestBody User user) throws UserAlreadyExistsException {
        try{
            userMovieService.saveUserAndMovieDetails(user);
            responseEntity = new ResponseEntity(user, HttpStatus.CREATED);
        }catch (UserAlreadyExistsException ex1){
            throw ex1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return responseEntity;
    }

    @PutMapping("user/{email}")
    public ResponseEntity<?> updateAnyDetails(@RequestBody User user, @PathVariable String email) throws UserNotFoundException {
        try{
            userMovieService.updateMovieAndUserDetails(user, email);
            responseEntity = new ResponseEntity(user, HttpStatus.OK);
        }catch (UserNotFoundException ex2){
            throw ex2;
        }catch (Exception e){
            e.printStackTrace();
        }
        return responseEntity;
    }
}
