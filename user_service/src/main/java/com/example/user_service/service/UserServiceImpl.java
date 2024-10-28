package com.example.user_service.service;

import com.example.user_service.dto.UserDto;
import com.example.user_service.mapper.UserMapper;
import com.example.user_service.model.UserEnt;
import com.example.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserEnt userEnt) {
        return userMapper.userToDto(userRepository.save(userEnt));
    }

    @Override
    public UserDto updateUser(Long id, UserEnt userEnt) {
        UserEnt updatedUser = userRepository.findById(id).orElseThrow();
        updatedUser.setName(userEnt.getName());
        updatedUser.setSurname(userEnt.getSurname());
        updatedUser.setEmail(userEnt.getEmail());
        updatedUser.setAge(userEnt.getAge());
        updatedUser.setPassword(userEnt.getPassword());
        return userMapper.userToDto(userRepository.save(updatedUser));
    }

    @Override
    public void deactiveAccount(Long id) {
     UserEnt userEnt = userRepository.findById(id).orElseThrow();
     userEnt.setStatus('D');
     userRepository.save(userEnt);
    }

    @Override
    public UserDto getUserById(Long id) {
        return userMapper.userToDto(userRepository.findById(id).orElseThrow());
    }

    @Override
    public List<UserDto> getUsers() {
        List<UserEnt> userEntList = userRepository.findAll();
        return userEntList.stream().map(userMapper::userToDto).toList();
    }
}
