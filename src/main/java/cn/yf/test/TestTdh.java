package cn.yf.test;

import cn.yf.pojo.Depart;
import cn.yf.pojo.User;
import cn.yf.service.DepartService;
import cn.yf.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestTdh {

    @Autowired
    UserService userService;
    @Autowired
    DepartService departService;

    @Test
    public void test(){
        List<User> users =  userService.getAllUser();
        System.out.println(users);
    }

    @Test
    public void test2(){
        List<Depart> departs = departService.getAllDepart();
        System.out.println(departs);
    }

    @Test
    public void test3(){
        List<User> users = userService.getUserByYhdm("yf001");
        System.out.println(users);
    }

    @Test
    public void test4(){
        List<User> users = userService.getUserByYhbm("6");
        System.out.println(users);
    }

    @Test
    public void test5(){
        List<User> users = userService.getUserByYhdmAndYhbm("yf001","5");
        System.out.println(users);
    }

    @Test
    public void test6(){
        boolean result = userService.deleteUserByYhdm("2222");
        System.out.println(result);
    }

    @Test
    public void test7(){
        User user = new User("222","22","22","22","1",2);
        boolean result = userService.addUser(user);
        System.out.println(result);
    }

    @Test
    public void test8(){
        User user = new User("222","33","33","33","1",3);
        boolean result = userService.updateUser(user);
        System.out.println(result);
    }

}
