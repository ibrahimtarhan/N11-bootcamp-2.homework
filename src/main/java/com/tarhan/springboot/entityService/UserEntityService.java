package com.tarhan.springboot.entityService;

import com.tarhan.springboot.dao.UserDao;
import com.tarhan.springboot.entity.Category;
import com.tarhan.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityService {
    @Autowired
    private UserDao userDao;

    public List<User> findAll(){

        return (List<User>) userDao.findAll();
    }
    public User findUserByUsername(String username){
        return userDao.findUserByUsername(username);
    }
    public User findUserByPhone(String phone){
        return userDao.findUserByPhone(phone);
    }
    public User save(User user){
        return userDao.save(user);
    }
    public User findUserByUsernameandPhone(String username, String phone){
        return userDao.findUserByUsernameandPhone(username,phone);
    }
    public void deleteById(Long id){
        userDao.deleteById(id);
    }
}
