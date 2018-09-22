package xyz.huizhe.todo.todolist.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.huizhe.todo.todolist.datacode.DataCode;
import xyz.huizhe.todo.todolist.model.Matters;
import xyz.huizhe.todo.todolist.model.Userinfo;
import xyz.huizhe.todo.todolist.service.MatterService;
import xyz.huizhe.todo.todolist.utils.JsonUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author huizhe
 * @date 2018/9/18
 * @time 19:23
 */
@RestController
@RequestMapping(value="/matters")
public class MattersController {

    private final static ThreadLocal<SimpleDateFormat> dateformat = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd"));

    @Autowired
    private MatterService matterService;

    @PostMapping(value="/add")
    public String addMatters(String content,Integer user_id){
        Matters matters = new Matters();
        matters.setContent(content);
        matters.setUserId(user_id);
        matters.setCreateDate(new Date());
        matters.setUpdateDate(new Date());
        matters.setStatus((byte)0);
        matterService.addMatters(matters);
        return  "{\"code\":200,\"data\": {\"id\":"+matters.getId()+"}}";
    }

    @PutMapping(value="/{id}")
    public String updateMatters(@PathVariable Integer id, String content, Byte status, Integer user_id) {
        Matters matters = new Matters();
        matters.setId(id);
        matters.setContent(content);
        matters.setStatus(status);
        matters.setUserId(user_id);
        matters.setUpdateDate(new Date());
        matterService.updateMattersById(matters);
        matters = null;
        return DataCode.getERROR()[0];
    }

    @DeleteMapping(value="/{id}/{user_id}")
    public String deleteMatters(@PathVariable Integer id, @PathVariable Integer user_id) {
        Matters matters = new Matters();
        matters.setId(id);
        matters.setUserId(user_id);
        matterService.deleteMattersById(matters);
        matters = null;
        return DataCode.getERROR()[0];
    }

    @GetMapping(value="/status/{user_id}/{status}")
    public String selectAllByStatus(@PathVariable Byte status, @PathVariable Integer user_id) {
        Matters matters = new Matters();
        matters.setStatus(status);
        matters.setUserId(user_id);
        List<Matters> list = matterService.selectAllByStatus(matters);
        if (list.size()!=0) {
            try {
                return "{\"code\":200,\"data\":"+JsonUtils.getMapper().writeValueAsString(list)+"}";
            } catch (JsonProcessingException e) {
                return DataCode.getERROR()[5];
            }
        } else {
            return DataCode.getERROR()[4];
        }
    }

    @GetMapping(value="/date/{user_id}/{date}")
    public String selectAllByDate(@PathVariable String date, @PathVariable Integer user_id) {
        try{
            Matters matters = new Matters();
            matters.setCreateDate(dateformat.get().parse(date));
            matters.setUserId(user_id);
            List<Matters> list = matterService.selectAllByDate(matters);
            if (list.size()!=0) {
                return "{\"code\":200,\"data\":"+JsonUtils.getMapper().writeValueAsString(list)+"}";
            } else {
                return DataCode.getERROR()[4];
            }
        } catch (Exception e) {
            return DataCode.getERROR()[5];
        }
    }
}
