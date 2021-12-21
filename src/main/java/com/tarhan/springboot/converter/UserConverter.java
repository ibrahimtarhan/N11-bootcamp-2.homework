package com.tarhan.springboot.converter;

import com.tarhan.springboot.dto.CategoryDTO;
import com.tarhan.springboot.dto.UserDTO;
import com.tarhan.springboot.entity.Category;
import com.tarhan.springboot.entity.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Mapping(target = "id", source = "id")
    UserDTO convertUserToUserDTO(User user);

    @Mapping(target = "id", source = "id")
    User convertUserDTOToUser(UserDTO userDTO);

    @Mapping(target = "id", source = "id")
    List<UserDTO> convertAllUserListToUserDTOList(List<User> userList);

//    @AfterMapping
//    default void setNulls(@MappingTarget User user, UserDTO userDTO){
//        if (userDTO.() == null){
//            category.setParentCategory(null);
//        }
//    }
}
