package com.example.user_service.controller;

import com.example.user_service.dto.UserDto;
import com.example.user_service.model.UserEnt;
import com.example.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/save")
    public ResponseEntity<UserDto> createUser(@RequestBody UserEnt userEnt) {
        return ResponseEntity.ok(userService.createUser(userEnt));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/getuser/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public UserDto updateUserById(@PathVariable Long id, @RequestBody UserEnt userEnt) {
        return userService.updateUser(id, userEnt);
    }

    @PostMapping("/deactive/{id}")
    public void deactivateAccount(@PathVariable Long id){
        userService.deactiveAccount(id);
    }
}
