package com.casestudy.stockexchange.Service;

import com.casestudy.stockexchange.Entity.User;
import com.casestudy.stockexchange.Model.UserRequestModel;
import com.casestudy.stockexchange.Model.UserResponseModel;

import java.util.List;

public interface UserService {
    public List<UserResponseModel> findAll();
    public UserResponseModel findById(int id);
    public UserResponseModel findByUserNameandPassword(String userName, String password);
    public UserResponseModel addUser(UserRequestModel userRequestModel);
}
