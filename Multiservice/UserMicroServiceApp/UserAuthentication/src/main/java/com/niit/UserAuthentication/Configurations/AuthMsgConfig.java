package com.niit.UserAuthentication.Configurations;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthMsgConfig {

    @Bean
    public Jackson2JsonMessageConverter producerConvertor(){
        return new Jackson2JsonMessageConverter();
    }
}
