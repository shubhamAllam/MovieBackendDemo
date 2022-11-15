package com.niit.UserMovieServices.Configuration;

import com.niit.UserMovieServices.RabbitMqModel.UserMovieDTO;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private RabbitTemplate rabbitTemplate;
    private DirectExchange directExchange;

    @Autowired
    Producer(RabbitTemplate rabbitTemplate, DirectExchange directExchange){
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    public void sendMsgToRabbitMqServer(UserMovieDTO userDto){
        rabbitTemplate.convertAndSend(directExchange.getName(), "user_routing", userDto);
    }
}
