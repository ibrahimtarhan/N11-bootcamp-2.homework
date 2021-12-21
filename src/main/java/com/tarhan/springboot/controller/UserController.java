package com.tarhan.springboot.controller;

import com.tarhan.springboot.converter.CategoryConverter;
import com.tarhan.springboot.converter.UserConverter;
import com.tarhan.springboot.dto.CategoryDTO;
import com.tarhan.springboot.dto.UserDTO;
import com.tarhan.springboot.entity.Category;
import com.tarhan.springboot.entity.User;
import com.tarhan.springboot.entityService.UserEntityService;
import com.tarhan.springboot.exception.CommnetByProductNotFoundException;
import com.tarhan.springboot.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserEntityService userEntityService;

    @GetMapping("")
    public List<UserDTO> findAll(){

        List<User> userList = userEntityService.findAll();

        List<UserDTO> userDTOList = UserConverter.INSTANCE.convertAllUserListToUserDTOList(userList);

        return userDTOList;
    }
    @GetMapping("/username/{username}")
    public UserDTO findByUsername(@PathVariable String username){

        User user = userEntityService.findUserByUsername(username);
        UserDTO userDTO = UserConverter.INSTANCE.convertUserToUserDTO(user);

        return userDTO;
    }
    @GetMapping("/phone/{phone}")
    public UserDTO findByPhone(@PathVariable String phone){

        User user = userEntityService.findUserByPhone(phone);
        UserDTO userDTO = UserConverter.INSTANCE.convertUserToUserDTO(user);

        return userDTO;
    }
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody UserDTO userDTO){

        User user = UserConverter.INSTANCE.convertUserDTOToUser(userDTO);

        user = userEntityService.save(user);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
    @PutMapping("")
    public UserDTO update(@RequestBody UserDTO userDTO){

        User user = UserConverter.INSTANCE.convertUserDTOToUser(userDTO);

        user = userEntityService.save(user);

        UserDTO userDTOResult = UserConverter.INSTANCE.convertUserToUserDTO(user);

        return userDTOResult;
    }
    @DeleteMapping("/{username}/{phone}")
    public void delete(String username, String phone){
        User user = userEntityService.findUserByUsernameandPhone(username,phone);
        if(user == null){
            throw new UserNotFoundException(username + " kullanıcı adı ile " + phone + "telefon numarası eşleşen kayıt bulunamamıştır");
        }

        userEntityService.deleteById(user.getId());
    }
}
