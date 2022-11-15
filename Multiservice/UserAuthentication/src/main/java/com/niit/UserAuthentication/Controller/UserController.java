package com.niit.UserAuthentication.Controller;

import UserDefinedException.UserAlreadyExistsException;
import UserDefinedException.UserNotFoundException;
import com.niit.UserAuthentication.Model.User;
import com.niit.UserAuthentication.Service.SecurityTokenGenerator;
import com.niit.UserAuthentication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController @RequestMapping("/app/authentication/")
public class UserController {
    private UserService userService;
    private ResponseEntity responseEntity;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator){
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("register")
    public ResponseEntity<?> registerAnUser(@RequestBody User user) throws UserAlreadyExistsException {
        try{
            userService.registerAnUser(user);
            responseEntity = new ResponseEntity(user, HttpStatus.CREATED);
        }catch (UserAlreadyExistsException ex1){
            throw new UserAlreadyExistsException();
        }catch (Exception e){
            responseEntity = new ResponseEntity<>("Error while Saving Data!", HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @PostMapping("login")
    public ResponseEntity<?> userLogin(@RequestBody User user) throws UserNotFoundException {
        Map<String, String> map = null;
        if(userService.userLogin(user)==null){
            throw new UserNotFoundException();
        }
        else{
            User tempUser = userService.userLogin(user);
            if(tempUser != null){
                map = securityTokenGenerator.generateToken(tempUser);
                responseEntity = new ResponseEntity<>(map, HttpStatus.OK);
            }else {
                throw new UserNotFoundException();
            }
        }
        return responseEntity;
    }
}
