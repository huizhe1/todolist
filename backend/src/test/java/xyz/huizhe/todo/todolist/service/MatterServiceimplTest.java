package xyz.huizhe.todo.todolist.service; 

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.huizhe.todo.todolist.mapping.MattersMapper;
import xyz.huizhe.todo.todolist.model.Matters;

import java.util.Date;
import java.util.List;
import java.util.Random;

/** 
* MatterServiceimpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 18, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MatterServiceimplTest {

    @Autowired
    private MatterService matterService;

    /**
    * 
    * Method: addMatters(Matters matters) 
    * 
    */ 
    @Test
    public void testAddMatters() throws Exception {
        Matters matters;
        Random random = new Random();
        //for (int i =0;i<20;++i) {
            matters = new Matters();
            matters.setStatus((byte)random.nextInt(4));
            matters.setContent("test id fanhui ");
            matters.setCreateDate(new Date());
            matters.setUpdateDate(new Date());
            matters.setUserId(1);
            matterService.addMatters(matters);
            System.out.println(matters.getId());
        //}
    } 
    
        /** 
    * 
    * Method: selectAllByStatus(Matters matters) 
    * 
    */ 
    @Test
    public void testSelectAllByStatus() throws Exception {
        Random random = new Random();
        Matters matters = new Matters();
        matters.setUserId(1);
        matters.setStatus((byte)random.nextInt(4));
        List<Matters> list = matterService.selectAllByStatus(matters);
        list.forEach(e-> System.out.println(e));
    } 
    
        /** 
    * 
    * Method: selectAllByDate(Matters matters) 
    * 
    */ 
    @Test
    public void testSelectAllByDate() throws Exception {
        Matters matters = new Matters();
        matters.setUserId(1);
        matters.setCreateDate(new Date());
        List<Matters> list = matterService.selectAllByDate(matters);
        list.forEach(e-> System.out.println(e));
    } 
    
        /** 
    * 
    * Method: updateMattersById(Matters matters) 
    * 
    */ 
    @Test
    public void testUpdateMattersById() throws Exception {
        Matters matters = new Matters();
        matters.setUserId(1);
        matters.setId(21);
        matters.setContent("update test");
        matters.setCreateDate(new Date());
        matterService.updateMattersById(matters);
    } 
    
        /** 
    * 
    * Method: deleteMattersById(Matters matters) 
    * 
    */ 
    @Test
    public void testDeleteMattersById() throws Exception { 
        Matters matters = new Matters();
        matters.setId(21);
        matters.setUserId(1);
        matterService.deleteMattersById(matters);
    }

    @Test
    public void testSelectAllforSend() {
        matterService.selectAllforSend().forEach(e-> System.out.println(e));
    }
}
