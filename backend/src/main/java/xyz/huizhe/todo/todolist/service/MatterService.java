package xyz.huizhe.todo.todolist.service;

import xyz.huizhe.todo.todolist.model.Matters;

import java.sql.Date;
import java.util.List;

/**
 * @author huizhe
 * @date 2018/9/18
 * @time 10:56
 */
public interface MatterService {

    public Integer addMatters(Matters matters);

    public List<Matters> selectAllByStatus(Matters matters);

    public List<Matters> selectAllByDate(Matters matters);

    public void updateMattersById(Matters matters);

    public void deleteMattersById(Matters matters);

    /**
     * 检测昨天未完成的任务，并发送短信
     * @return
     */
    public List<Matters> selectAllforSend();
}
