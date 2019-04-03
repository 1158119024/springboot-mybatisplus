package com.xiaofeng.mybatisplus.log;

import com.alibaba.fastjson.JSON;
import com.xiaofeng.mybatisplus.config.JSONResult;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.javassist.*;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 晓枫
 * @Date: 2018/10/26 22:21
 * @Description: 控制层日志监听
 */
@Component
@Aspect
@Log4j2
public class ControllerLog {


    @Pointcut("execution(* com.xiaofeng.mybatisplus.web..*.*(..))")
    public void executeService(){
    }

    /**
     * 环绕通知，获取请求参数与返回值
     * @param joinPoint
     */
    @Around("executeService()")
    public Object doBeforeAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        Object[] args = joinPoint.getArgs();
        String classType = joinPoint.getTarget().getClass().getName();
        Class<?> clazz = Class.forName(classType);
        String clazzName = clazz.getName();
        String methodName = joinPoint.getSignature().getName(); // 获取方法名称
        JSONResult result = (JSONResult)joinPoint.proceed();
        // 打印请求内容
        log.info("===============请求内容 start===============");
        log.info("请求地址: " + request.getRequestURL().toString());
        log.info("请求方式: " + request.getMethod());
        log.info("请求的类: " + joinPoint.getTarget().getClass());
        log.info("请求的方法: " + joinPoint.getSignature().getName());
        log.info("请求类方法参数: " + JSON.toJSONString(Arrays.toString(joinPoint.getArgs())));
        // 获取参数名称和值
        StringBuffer sb = getNameAndArgs(this.getClass(), clazzName, methodName, args);
        log.info("请求的参数名称和值: " + sb);
//        log.info("请求token: " + AopUtils.getToken(request));
        log.info("请求返回值: " + JSON.toJSONString(result));
        log.info("===============请求内容 end===============");
        return result;
    }

    public static StringBuffer getNameAndArgs(Class<?> cls, String clazzName, String methodName, Object[] args) throws NotFoundException {

        Map<String, Object> nameAndArgs = new HashMap<String, Object>();

        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(cls);
        pool.insertClassPath(classPath);

        CtClass cc = pool.get(clazzName);
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            // exception
        }
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < cm.getParameterTypes().length; i++) {
            nameAndArgs.put(attr.variableName(i + pos), args[i]);// paramNames即参数名
        }

        // nameAndArgs的两种类型，用实体类接收的类似这样：
        // reqParams=com.whoareyou.fido.rest.User@616b9c0e
        // 用Map<String,Object>接收的是这样：menuNo=56473283，遍历这个map区分两种不同，使用不同的取值方式。
        // 根据获取到的值所属的不同类型通过两种不同的方法获取参数
        boolean flag = false;
        if (nameAndArgs != null && nameAndArgs.size() > 0) {
            for (Map.Entry<String, Object> entry : nameAndArgs.entrySet()) {
                if (entry.getValue() instanceof String) {
                    flag = true;
                    break;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        if (flag) {
            // 从Map中获取
            sb.append(JSON.toJSONString(nameAndArgs));
        } else {
            if (args != null) {
                for (Object object : args) {
                    if (object != null) {
                        if (object instanceof MultipartFile || object instanceof ServletRequest
                                || object instanceof ServletResponse) {
                            continue;
                        }
                        sb.append(JSON.toJSONString(object));
                    }
                }
            }
        }
        return sb;
    }
}
