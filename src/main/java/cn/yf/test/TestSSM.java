package cn.yf.test;

import cn.yf.pojo.Admin;
import cn.yf.service.impl.AdminServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestSSM{

    @Resource
    AdminServiceImpl adminServiceImpl;

    @Test
    public void test1(){
        List<Admin> adminList = adminServiceImpl.getAllAdmin();
        System.out.println(adminList);
    }

    @Test
    public void test2(){
        Admin admin = adminServiceImpl.getAdminById(1);
        System.out.println(admin);
    }

    @Test
    public void test3(){
        Admin admin = new Admin("入职","加油");
        boolean result = adminServiceImpl.addAdmin(admin);
        System.out.println(result);
    }

    @Test
    public void test4(){
        Admin admin = new Admin(3,"加油","入职");
        boolean result = adminServiceImpl.updateAdmin(admin);
        System.out.println(result);
    }

    @Test
    public void test5(){
        boolean result = adminServiceImpl.deleteAdminById(9);
        System.out.println(result);
    }

}

