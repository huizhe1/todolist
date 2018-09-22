package xyz.huizhe.todo.todolist.datacode;

/**
 * @author huizhe
 * @date 2018/9/19
 * @time 10:47
 */
public class DataCode {

    private static final String[] ERROR = new String[]{
            "{\"code\":200,\"data\":\"null\"}",
            "{\"code\": 1001, \"error\": \"账号错误\"}",
            "{\"code\": 1002, \"error\": \"密码错误\"}",
            "{\"code\":1003,\"error\":\"无权限操作\"}",
            "{\"code\":1004,\"error\":\"无数据\"}",
            "{\"code\":1005,\"error\":\"请求参数错误\"}",
            "{\"code\":1006,\"error\":\"请重新登录\"}"
    };

    public static String[] getERROR() {
        return ERROR;
    }
}
