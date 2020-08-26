package com.casestudy.stockexchange.Controller;

import com.casestudy.stockexchange.Entity.User;
import com.casestudy.stockexchange.Exception.UserNotFoundException;
import com.casestudy.stockexchange.Model.UserRequestModel;
import com.casestudy.stockexchange.Model.UserResponseModel;
import com.casestudy.stockexchange.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/all")
    public ResponseEntity<List<UserResponseModel>> findAllUsers(){
        return new ResponseEntity<List<UserResponseModel>>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("users/add")
    public  ResponseEntity<UserResponseModel> addNewUser(@RequestBody UserRequestModel userRequestModel){
        return new ResponseEntity<UserResponseModel>(userService.addUser(userRequestModel),HttpStatus.OK);
    }

    @GetMapping("/users/byid/{id}")
    public  ResponseEntity<UserResponseModel> findUserById(@PathVariable Integer id) throws UserNotFoundException {
        UserResponseModel user = userService.findById(id);
        if(user==null)
            throw new UserNotFoundException("No such user by ID = "+String.valueOf(id));
        return new ResponseEntity<UserResponseModel>(userService.findById(id),HttpStatus.OK);
    }

    @GetMapping("users/login/{userName}/{password}")
    public ResponseEntity<UserResponseModel> loginUser(@PathVariable String userName, @PathVariable String password) throws UserNotFoundException{
        UserResponseModel userResponseModel = userService.findByUserNameandPassword(userName,password);
        if(userResponseModel==null)
            throw new UserNotFoundException("UserName or Password does not match please try again");
        return new ResponseEntity<UserResponseModel>(userResponseModel,HttpStatus.OK);
    }
}
