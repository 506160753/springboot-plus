package com.example.aop.aspect;

import com.example.aop.annotation.Log;
import com.example.aop.domain.TbLog;
import com.example.aop.service.TbLogService;
import com.example.aop.util.HttpContextUtils;
import com.example.aop.util.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    private TbLogService tbLogService;

    /**
     * 记录面向开发者的日志
     * 知道前台的请求是否进入了我们控制器中，以及参数的获取情况
     * 建议正式发布注释
     */
    @Pointcut("execution(public * com.example.aop.controller..*.*(..))")
    public void pointcutController() {
    }

    @Before("pointcutController()")
    public void pointcutControllerAround(JoinPoint point) {
        //获取目标方法
        String methodNam = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
        //获取方法参数
        String params = Arrays.toString(point.getArgs());
        log.info("get in {} params :{}", methodNam, params);
    }

    //切入点
    @Pointcut("@annotation(com.example.aop.annotation.Log)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object pointcutAround(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(point, time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        TbLog tbLog = new TbLog();
        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的描述
            tbLog.setDescription(logAnnotation.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        tbLog.setUrl(className + "." + methodName + "()");
        // 请求的方法参数值
//		Object[] args = joinPoint.getArgs();
//		//请求的方法参数名称
//		LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
//		String[] paramNames = u.getParameterNames(method);
//		if (args != null && paramNames != null) {
//			String params = "";
//			for (int i = 0; i < args.length; i++) {
//				params += "  " + paramNames[i] + ": " + args[i];
//			}
//			tbLog.setParams(params);
//		}
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        tbLog.setIp(IPUtils.getIpAddr(request));
        tbLog.setSpendTime(time);
        tbLog.setCreateTime(new Date());
        // 保存系统日志
        tbLogService.insert(tbLog);
    }
}
