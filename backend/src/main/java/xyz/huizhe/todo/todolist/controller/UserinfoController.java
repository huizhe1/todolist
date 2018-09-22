package xyz.huizhe.todo.todolist.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.huizhe.todo.todolist.datacode.DataCode;
import xyz.huizhe.todo.todolist.model.Userinfo;
import xyz.huizhe.todo.todolist.service.UserService;
import xyz.huizhe.todo.todolist.utils.JsonUtils;

/**
 * @author huizhe
 * @date 2018/9/18
 * @time 18:34
 */
@RequestMapping("/user")
@RestController
public class UserinfoController {

    @Autowired
    private UserService userService;

    @PostMapping(value="/login")
    public String login(String username, String password) throws Exception{
        Userinfo userinfo = userService.login(username, password);
        if (null==userinfo) {
            return DataCode.getERROR()[2];
        }
        if (0 == userinfo.getId()) {
            return DataCode.getERROR()[1];
        }
        return "{\"code\":200,\"data\":"+JsonUtils.getMapper().writeValueAsString(userinfo)+"}";
    }
}
