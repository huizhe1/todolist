package xyz.huizhe.todo.todolist.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* MD5Utils Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 19, 2018</pre> 
* @version 1.0 
*/ 
public class MD5UtilsTest { 
    
    @Before
    public void before() throws Exception { 
    } 
    
    @After
    public void after() throws Exception { 
    } 
    
        /** 
    * 
    * Method: encode(String password) 
    * 
    */ 
    @Test
    public void testEncode() throws Exception {
        System.out.println(MD5Utils.encode("root"));
    }
}
