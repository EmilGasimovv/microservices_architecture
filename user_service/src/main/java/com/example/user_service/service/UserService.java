package com.example.user_service.service;

import com.example.user_service.dto.UserDto;
import com.example.user_service.model.UserEnt;

import java.util.List;

public interface UserService {
   UserDto createUser(UserEnt userEnt);
   UserDto updateUser(Long id,UserEnt userEnt);
   void deactiveAccount(Long id);

   UserDto getUserById(Long id);
   List<UserDto> getUsers();


}
