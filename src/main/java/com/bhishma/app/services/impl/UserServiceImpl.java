package com.bhishma.app.services.impl;

import com.bhishma.app.entities.User;
import com.bhishma.app.exceptions.ResourceNotFoundException;
import com.bhishma.app.payloads.UserDto;
import com.bhishma.app.repositories.UserRepo;
import com.bhishma.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
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
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "id",userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());

      User updatedUser=  this.userRepo.save(user);

      return this.userTodto(updatedUser);

    }

    @Override
    public UserDto getUserById(Integer userId) {
       User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
       return this.userTodto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User>users=this.userRepo.findAll();

       List<UserDto> userdtos=users.stream().map(user->this.userTodto(user)).collect(Collectors.toList());
    return userdtos;
    }

    @Override
    public void deleteUser(Integer userId) {

        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));

        this.userRepo.delete(user);
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
