package com.tarhan.springboot.dao;

import com.tarhan.springboot.entity.Category;
import com.tarhan.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    @Query("select user from User user where user.username = :username")
    User findUserByUsername(String username);

    @Query("select user from User user where user.phone = :phone")
    User findUserByPhone(String phone);

    @Query("select user from User user where user.phone = :phone and user.username =:username")
    User findUserByUsernameandPhone(String username,String phone);
}
