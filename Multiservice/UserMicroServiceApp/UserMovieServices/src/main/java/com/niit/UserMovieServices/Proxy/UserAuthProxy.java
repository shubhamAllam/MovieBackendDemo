package com.niit.UserMovieServices.Proxy;

import com.niit.UserMovieServices.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "USER-AUTHENTICATION-SERVICE")
public interface UserAuthProxy {
    @PostMapping("/app/authentication/register")
    public ResponseEntity registerAnUser(@RequestBody User user);
}
