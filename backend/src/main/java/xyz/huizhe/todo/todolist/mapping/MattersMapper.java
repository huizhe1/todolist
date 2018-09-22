package xyz.huizhe.todo.todolist.mapping;

import java.util.List;

import xyz.huizhe.todo.todolist.model.Matters;

public interface MattersMapper {
    int deleteByPrimaryKey(Matters matters);

    int insert(Matters record);

    Matters selectByPrimaryKey(Matters matters);

    List<Matters> selectAll(Integer id);

    List<Matters> selectAllByStatus(Matters matters);

    List<Matters> selectAllByDate(Matters matters);

    int updateByPrimaryKey(Matters record);

    List<Matters> selectAllforSend();
}