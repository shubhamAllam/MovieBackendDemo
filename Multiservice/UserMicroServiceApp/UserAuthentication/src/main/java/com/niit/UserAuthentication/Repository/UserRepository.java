package com.niit.UserAuthentication.Repository;

import com.niit.UserAuthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserIdAndPassword(int userId, String password);
}
