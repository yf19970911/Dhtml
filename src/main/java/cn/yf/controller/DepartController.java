package cn.yf.controller;

import cn.yf.pojo.Depart;
import cn.yf.service.DepartService;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartController {

    @Autowired
    DepartService departService;

    @ResponseBody
    @RequestMapping("getAllDepart")
    public List<Object> getAllDepart() throws IOException {
        List<Depart> departs = departService.getAllDepart();
        String id = null;
        String pid = null;
        String name = null;
        ArrayList<Object> arrayList = new ArrayList<>();
        for(Depart depart : departs){
            id = depart.getBmdm();
            pid = depart.getFdm();
            name = depart.getBmmc();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",id);
            jsonObject.put("pid",pid);
            jsonObject.put("name",name);
            arrayList.add(jsonObject);
        }
        return arrayList;
    }

}
