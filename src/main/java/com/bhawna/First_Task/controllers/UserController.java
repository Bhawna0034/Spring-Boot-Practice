package com.bhawna.First_Task.controllers;

import com.bhawna.First_Task.DTO.UserDto;
import com.bhawna.First_Task.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

   
   @GetMapping
    public List<UserDto> getAllUsers(){
       return userService.getAllUsers();

   }

   @PostMapping
    public UserDto createNewUser(@RequestBody UserDto inputUser){
       return userService.createNewUser(inputUser);
   }


}
