package com.dhriti.user.userService.repositories;

import com.dhriti.user.userService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {
 // Add any custom methods for any custom operations on user table/entity
    User findByEmailAndUserId(String email, String userId);
}
