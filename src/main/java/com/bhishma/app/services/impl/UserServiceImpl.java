package com.bhishma.app.services.impl;

import com.bhishma.app.entities.User;
import com.bhishma.app.payloads.UserDto;
import com.bhishma.app.repositories.UserRepo;
import com.bhishma.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
   @Autowired
   private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userdto) {
        User user=this.dtoToUser(userdto);
        User savedUser=this.userRepo.save(user);

        return this.userTodto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto user, Integer userId) {
        return null;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    private User dtoToUser(UserDto userDto){
        User user=new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        return user;
    }

    private UserDto userTodto(User user){
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }
}
