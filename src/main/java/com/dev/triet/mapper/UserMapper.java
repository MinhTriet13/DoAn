package com.dev.triet.mapper;

import com.dev.triet.entities.User;
import com.dev.triet.dto.UserDto;

public class UserMapper {
    //de convert data tu user sang userDto và tái sử dụng code
    //va de quyet dinh nhung tham so dau ra
    public static UserDto userDto(User user){

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(user.getAddress());
        userDto.setPhone(user.getPhone());

        return userDto;
    }
}
