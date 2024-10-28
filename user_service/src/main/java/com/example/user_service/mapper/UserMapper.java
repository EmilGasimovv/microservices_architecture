package com.example.user_service.mapper;

import com.example.user_service.dto.UserDto;
import com.example.user_service.model.UserEnt;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto userToDto(UserEnt userEnt){
        return UserDto.builder()
                .name(userEnt.getName())
                .surname(userEnt.getSurname())
                .email(userEnt.getEmail())
                .build();
    }
}
