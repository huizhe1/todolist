package xyz.huizhe.todo.todolist.aop;

import com.sun.tools.corba.se.idl.constExpr.Times;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xyz.huizhe.todo.todolist.datacode.DataCode;
import xyz.huizhe.todo.todolist.model.Userinfo;
import xyz.huizhe.todo.todolist.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * @author huizhe
 * @date 2018/9/19
 * @time 9:03
 */
@Aspect
@Component
public class PermissionProxy {

    @Autowired
    private UserService userService;

    @Pointcut(value = "execution(public * xyz.huizhe.todo.todolist.controller.MattersController.*(..))")
    public void checkPression() {}

    @Around("checkPression()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取请求参数
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 检测是否带有 token 头
        if(request.getHeader("token")==null) {
            return DataCode.getERROR()[5];
        }
        // 检测 token 有效性
        Userinfo userinfo = userService.checkPrimession(request.getHeader("token"));
        if (userinfo==null) {
            return DataCode.getERROR()[3];
        }
        try{
            // 检测 user_id 是否一致
            Object[] objects = joinPoint.getArgs();
            if (userinfo.getId() != objects[objects.length-1]) {
                return DataCode.getERROR()[3];
            }
            // 检测 token 的时效性 两小时
            Long token_time = userinfo.getUpdateAt().getTime();
            Long now = System.currentTimeMillis()-7200000;
            if (now > token_time) {
                return  DataCode.getERROR()[6];
            }
            return joinPoint.proceed();
        } catch (Exception e) {
            return DataCode.getERROR()[3];
        }
    }
}
