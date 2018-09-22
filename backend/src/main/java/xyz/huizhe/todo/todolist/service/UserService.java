package xyz.huizhe.todo.todolist.service;

import xyz.huizhe.todo.todolist.model.Matters;
import xyz.huizhe.todo.todolist.model.Userinfo;

import java.util.List;

/**
 * @author huizhe
 * @date 2018/9/18
 * @time 9:26
 */

public interface UserService {
    int addUser(Userinfo userinfo);

    Userinfo login(String username, String password);

    Userinfo checkPrimession(String token);

}
