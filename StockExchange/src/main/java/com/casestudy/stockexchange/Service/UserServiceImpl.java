package com.casestudy.stockexchange.Service;

import com.casestudy.stockexchange.Entity.User;
import com.casestudy.stockexchange.Model.UserRequestModel;
import com.casestudy.stockexchange.Model.UserResponseModel;
import com.casestudy.stockexchange.Repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public List<UserResponseModel> findAll() {
        List<User> userList = userRepository.findAll();
        Type tokentype = new TypeToken<List<UserResponseModel>>(){}.getType();
        return modelMapper.map(userList,tokentype);
    }

    @Override
    public UserResponseModel findById(int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return  modelMapper.map(user.get(),UserResponseModel.class);
        }
        return null;
    }

    @Override
    public UserResponseModel findByUserNameandPassword(String userName, String password) {
        Optional<User> user = userRepository.findByUserNameAndPassword(userName,password);
        if(user.isPresent()){
            return  modelMapper.map(user.get(),UserResponseModel.class);
        }
        return null;
    }

    @Override
    public UserResponseModel addUser(UserRequestModel userRequestModel) {
        User ret = userRepository.save(modelMapper.map(userRequestModel,User.class));
        return modelMapper.map(ret,UserResponseModel.class);
    }
}
