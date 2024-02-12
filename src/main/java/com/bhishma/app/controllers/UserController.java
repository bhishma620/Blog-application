package com.bhishma.app.controllers;

import com.bhishma.app.payloads.ApiResponse;
import com.bhishma.app.payloads.UserDto;
import com.bhishma.app.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
   private UserService userService;

    //creating user
    @PostMapping("/")
    public ResponseEntity<UserDto>  createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUserDto=this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    //updating user

    @PutMapping("/{userId}")

    public ResponseEntity<UserDto> updateUser(@PathVariable Integer userId,@RequestBody UserDto userDto){

      UserDto updatedUser=  this.userService.updateUser(userDto,userId);

      return ResponseEntity.ok(updatedUser);
    }


    //deleting user

    @DeleteMapping ("/{userId}")
    public  ResponseEntity<?> deleteUser(@PathVariable Integer userId){

        this.userService.deleteUser(userId);

        return new ResponseEntity(new ApiResponse("User Deleted SuccessFully",true),HttpStatus.OK);
    }

    //all users get

    @GetMapping("/")
    public  ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    //get single user

    @GetMapping("/{userId}")
    public  ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

}
