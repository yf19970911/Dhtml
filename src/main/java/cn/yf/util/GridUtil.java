package cn.yf.util;

import cn.yf.pojo.User;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridUtil {

    //将UserList转化成Grid能识别的json
    public static Map<String,Object> listToMap(List<User> users){
        Map<String,Object> map = new HashMap<>();
        JSONArray jsonArray = new JSONArray();
        for(User user:users){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",user.getBs());
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(user.getYhdm());
            arrayList.add(user.getYhxm());
            arrayList.add(user.getYhbm());
            arrayList.add(user.getBs());
            arrayList.add(user.getSfjy());
            arrayList.add(Integer.toString(user.getPxh()));
            jsonObject.put("data",arrayList);
            jsonArray.add(jsonObject);
        }
        map.put("rows",jsonArray);
        return map;
    }

}
