package xyz.huizhe.todo.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.huizhe.todo.todolist.mapping.MattersMapper;
import xyz.huizhe.todo.todolist.model.Matters;

import java.util.List;

/**
 * @author huizhe
 * @date 2018/9/18
 * @time 10:56
 */
@Service(value="MatterService")
public class MatterServiceimpl implements MatterService {

    @Autowired
    private MattersMapper mattersMapper;

    @Override
    public Integer addMatters(Matters matters) {
        return mattersMapper.insert(matters);
    }

    @Override
    public List<Matters> selectAllByStatus(Matters matters) {
        return mattersMapper.selectAllByStatus(matters);
    }

    @Override
    public List<Matters> selectAllByDate(Matters matters) {
        return mattersMapper.selectAllByDate(matters);
    }

    @Override
    public void updateMattersById(Matters matters) {
        mattersMapper.updateByPrimaryKey(matters);
    }

    @Override
    public void deleteMattersById(Matters matters) {
        mattersMapper.deleteByPrimaryKey(matters);
    }

    @Override
    public List<Matters> selectAllforSend() {
        return mattersMapper.selectAllforSend();
    }
}
