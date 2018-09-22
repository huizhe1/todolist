package xyz.huizhe.todo.todolist.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.huizhe.todo.todolist.model.Userinfo;

import java.util.Date;

/** 
* UserServiceimpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 18, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceimplTest { 

    @Autowired
    private UserService userService;

    /**
    *
    * Method: addUser(Userinfo userinfo)
    *
    */
    @Test
    public void testAddUser() throws Exception {
        Userinfo user = new Userinfo();
        user.setUsername("huiz1231232123asdhe");
        user.setPassword("root");
        user.setUpdateAt(new Date());
        user.setToken("12asdasdas123");
        //userService.addUser(user);
    }

    /**
    *
    * Method: login(String username, String password)
    *
    */
    @Test
    public void testLogin() throws Exception {
        //TODO: Test goes here...
        Userinfo userinfo = userService.login("huizhe","root");
        Assert.assertNotNull(userinfo);
    }

}
