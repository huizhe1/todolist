package xyz.huizhe.todo.todolist.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author huizhe
 * @date 2018/9/19
 * @time 9:21
 */
public class JsonUtils {

    public static ObjectMapper getMapper() {
        return mapper;
    }

    private final static ObjectMapper mapper = new ObjectMapper();

}
