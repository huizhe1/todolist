package xyz.huizhe.todo.todolist.mapping;

import java.util.List;

import xyz.huizhe.todo.todolist.model.Matters;
import xyz.huizhe.todo.todolist.model.Userinfo;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    List<Userinfo> selectAll();

    int updateByPrimaryKey(Userinfo record);

    Userinfo selectByNameAndPwd(String username);

    Userinfo checkPrimession(String token);

    List<Matters> getAllMatters();
}