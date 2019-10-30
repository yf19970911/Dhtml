package cn.yf.controller;

import cn.yf.pojo.User;
import cn.yf.service.UserService;
import cn.yf.util.GridUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("getAllUser")
    public Map<String,Object> getAllUser(HttpServletRequest request){
        List<User> users = userService.getAllUser();
        Map<String,Object> map = GridUtil.listToMap(users,request);
        return map;
    }

    @ResponseBody
    @RequestMapping("getUserByYhdm")
    public Map<String,Object> getUserByYhdm(@Param("yhdm") String yhdm,HttpServletRequest request){
        List<User> users = userService.getUserByYhdm(yhdm);
        Map<String,Object> map = GridUtil.listToMap(users,request);
        return map;
    }

    @ResponseBody
    @RequestMapping("getUserByYhbm")
    public Map<String,Object> getUserByYhbm(@Param("yhbm") String yhbm,HttpServletRequest request){
        List<User> users;
        if("1".equals(yhbm)){
            users = userService.getAllUser();
        }else {
            users = userService.getUserByYhbm(yhbm);
        }
        Map<String,Object> map = GridUtil.listToMap(users,request);
        return map;
    }

    @ResponseBody
    @RequestMapping("getUserByYhdmAndYhbm")
    public Map<String,Object> getUserByYhdmAndYhbm(@Param("yhdm") String yhdm,@Param("yhbm") String yhbm,HttpServletRequest request){
        List<User> users;
        if("".equals(yhbm) || null == yhbm || "1".equals(yhbm)){
            users = userService.getUserByYhdm(yhdm);
        }else{
            users = userService.getUserByYhdmAndYhbm(yhdm,yhbm);
        }
        Map<String,Object> map = GridUtil.listToMap(users,request);
        return map;
    }

    @RequestMapping("deleteUserByYhdm")
    public String deleteUserByYhdm(@Param("yhdm") String yhdm){
        boolean result = userService.deleteUserByYhdm(yhdm);
        if(result){
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }
        return "redirect:/index.jsp";
    }

    @RequestMapping("addUser")
    public String addUser(User user){
        boolean result = userService.addUser(user);
        if(result){
            System.out.println("添加成功！");
        }else{
            System.out.println("添加失败！");
        }
        return "redirect:/index.jsp";
    }

    @RequestMapping("updateUser")
    public String update(User user){
        boolean result = userService.updateUser(user);
        if(result){
            System.out.println("更新成功！");
        }else{
            System.out.println("更新失败！");
        }
        return "redirect:/index.jsp";
    }


}
