package cn.yf.service.impl;

import cn.yf.mapper.UserMapper;
import cn.yf.pojo.User;
import cn.yf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public List<User> getUserByYhdm(String yhdm) {
        return userMapper.getUserByYhdm(yhdm);
    }

    @Override
    public List<User> getUserByYhbm(String yhbm) {
        return userMapper.getUserByYhbm(yhbm);
    }

    @Override
    public List<User> getUserByYhdmAndYhbm(String yhdm, String yhbm) {
        return userMapper.getUserByYhdmAndYhbm(yhdm,yhbm);
    }

    @Override
    public boolean deleteUserByYhdm(String yhdm) {
        return userMapper.deleteUserByYhdm(yhdm);
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

}
