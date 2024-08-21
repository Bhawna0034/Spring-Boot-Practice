package com.bhawna.First_Task.services;

import com.bhawna.First_Task.DTO.UserDto;
import com.bhawna.First_Task.entities.UserEntity;
import com.bhawna.First_Task.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userEntity -> modelMapper.map(userEntity, UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto createNewUser(UserDto inputUser) {
        UserEntity toCreateUser= modelMapper.map(inputUser, UserEntity.class);
        UserEntity savedUser = userRepository.save(toCreateUser);
        return modelMapper.map(savedUser, UserDto.class);
    }



}
