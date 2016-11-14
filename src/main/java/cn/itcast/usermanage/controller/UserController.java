package cn.itcast.usermanage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import cn.itcast.usermanage.bean.EasyUIResult;
import cn.itcast.usermanage.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {
    
    @Resource
    private UserService userService;
    
    @RequestMapping(value="list", method=GET)
    @ResponseBody
    public EasyUIResult queryUserList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        EasyUIResult userList = this.userService.queryUserList(page, rows);
        
        return userList;
        
    }
}
