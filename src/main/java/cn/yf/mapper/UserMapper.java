package cn.yf.mapper;

import cn.yf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //获得所有用户的list
    public List<User> getAllUser();

    //根据用户代码查询用户
    public List<User> getUserByYhdm(@Param("yhdm") String yhdm);

    //根据用户部门获得所有用户
    public List<User> getUserByYhbm(@Param("yhbm") String yhbm);

    //根据用户部门和代码查询用户
    public List<User> getUserByYhdmAndYhbm(@Param("yhdm") String yhdm,@Param("yhbm") String yhbm);

    //根据用户代码删除用户
    public boolean deleteUserByYhdm(@Param("yhdm") String yhdm);

    //添加用户
    public boolean addUser(User user);

    //更新用户
    public boolean updateUser(User user);

}
