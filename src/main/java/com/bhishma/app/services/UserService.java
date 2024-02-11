package com.bhishma.app.services;

import com.bhishma.app.entities.User;
import com.bhishma.app.payloads.UserDto;

import java.util.List;

public interface UserService {

   UserDto createUser(UserDto user);

   UserDto updateUser(UserDto user,Integer userId);

   UserDto getUserById(Integer userId);

   List<UserDto> getAllUsers();

   void deleteUser(Integer userId);
}
