package xyz.huizhe.todo.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.huizhe.todo.todolist.mapping.UserinfoMapper;
import xyz.huizhe.todo.todolist.model.Matters;
import xyz.huizhe.todo.todolist.model.Userinfo;
import xyz.huizhe.todo.todolist.utils.MD5Utils;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author huizhe
 * @date 2018/9/18
 * @time 9:28
 */
@Service(value="userService")
public class UserServiceimpl implements UserService {

    @Autowired
    private UserinfoMapper userinfoMapper;
    private final static String str = "qwertyuiopasdfghjklzxcvbnm1234567890";
    private final static Random random = new Random();

    @Override
    public int addUser(Userinfo userinfo) {
         return userinfoMapper.insert(userinfo);
    }

    @Override
    public Userinfo login(String username, String password) {
        Userinfo user = userinfoMapper.selectByNameAndPwd(username);
        if (null == user) {
            user = new Userinfo();
            user.setId(0);
            return user;
        }
        else if (MD5Utils.encode(password).equals(user.getPassword())) {
            updateUserInfo(user);
            return user;
        }else {
            return null;
        }
    }

    @Override
    public Userinfo checkPrimession(String token) {
        return userinfoMapper.checkPrimession(token);
    }

    public void updateUserInfo(Userinfo user) {
        user.setUpdateAt(new Date());
        int len = random.nextInt(30);
        user.setToken(MD5Utils.encode(System.currentTimeMillis()+str.substring(len,len+6)));
        userinfoMapper.updateByPrimaryKey(user);
    }

}
