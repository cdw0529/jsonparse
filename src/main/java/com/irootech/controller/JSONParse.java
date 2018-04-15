package com.irootech.controller;

import com.alibaba.fastjson.JSON;
import com.irootech.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2018/4/15 0015.
 */
@Controller
public class JSONParse {

    //利用阿里的fastjson进行 json串转化为对象
    @RequestMapping("/jsonToObject")
    @ResponseBody
    public User jsonToObject(){
        String json = "{\"name\":\"张三\",\"age\":18}";
        User user = JSON.parseObject(json,User.class);
        return user;
    }

    //对象转化为JSON
    @RequestMapping("/objectToJSON")
    @ResponseBody
    public String objectToJSON(){
        User user = new User("张三",20);
        String jsonString = JSON.toJSONString(user);
        return jsonString;
    }

    //JSON转数组
    @RequestMapping("/jsonToArray")
    @ResponseBody
    public List<User> jsonToArray(){
        String json =  "[{\"name\":\"张三\",\"age\":18},{'\"name\"':'\"李四\"','\"age\"':19}]";

        List<User> users = JSON.parseArray(json, User.class);

        return users;

    }

    //数组转JSON
    @RequestMapping("/arrayToJSON")
    @ResponseBody
    public String arrayToJSON(){
        User user1 = new User("张三",18);
        User user2 = new User("李四",19);

        List list = new ArrayList();
        list.add(user1);
        list.add(user2);

        String jsonString = JSON.toJSONString(list);
        return jsonString;
    }
}
