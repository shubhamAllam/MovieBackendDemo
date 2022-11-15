package com.niit.UserMovieServices.Repository;


import com.niit.UserMovieServices.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserAndMovieRepository extends MongoRepository<User, String> {

    User findByEmail(String email);
}
