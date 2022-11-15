package com.niit.UserAuthentication.Configurations;

import UserDefinedException.UserAlreadyExistsException;
import com.niit.UserAuthentication.RabbitMqModel.UserDTO;
import com.niit.UserAuthentication.model.User;

import com.niit.UserAuthentication.Service.UserServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private UserServiceImpl userService;

    @RabbitListener(queues="producer_queue")
    public void getDataFromRabbitMq(UserDTO userDTO) throws UserAlreadyExistsException {

        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());

        userService.registerAnUser(user);
    }
}
