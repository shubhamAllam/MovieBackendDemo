package com.niit.UserMovieServices.RabbitMqModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserMovieDTO {

    private String userName, password;
    private int userId;
}
