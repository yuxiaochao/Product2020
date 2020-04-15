package com.huarui.common.aop;

import com.baomidou.mybatisplus.activerecord.Model;
import com.huarui.common.Req;
import com.huarui.common.utils.ThreadUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@Aspect
@Component
public class ParameterSection {
	private static final Logger logger = LoggerFactory.getLogger(ParameterSection.class);
	private long startTime;
	
	@Pointcut(value = "execution(* com.huarui.web.controller..*.*(..))")
	//定义一个切入点
    private void anyMethod(){}

    @Before("anyMethod()")
    public void doAccessCheck(JoinPoint jp){
    	String className = jp.getTarget().getClass().getSimpleName();
        String mothodName = jp.getSignature().getName();
        logger.debug("2.前置通知 ------------  " + className + "." + mothodName + " ------------");
    }  
      
    @AfterReturning("anyMethod()")
    public void doAfter(JoinPoint jp){
    	String className = jp.getTarget().getClass().getSimpleName();
        String mothodName = jp.getSignature().getName();
		long endTime = System.currentTimeMillis();
        logger.debug("5.后置通知 ---方法执行了" +(endTime - this.startTime) + "ms     " + className + "." + mothodName + " ------------");
    }  
      
    @After("anyMethod()")
    public void after(JoinPoint jp){
    	String className = jp.getTarget().getClass().getSimpleName();
        String mothodName = jp.getSignature().getName();
        logger.debug("4.最终通知------------  " + className + "." + mothodName + " ------------");
    }  
      
    @AfterThrowing(value = "anyMethod()", throwing = "iae")
    public void doAfterThrow(JoinPoint jp, Exception iae){
    	String className = jp.getTarget().getClass().getSimpleName();
        String mothodName = jp.getSignature().getName();
        logger.error("异常通知------------  " + className + "." + mothodName + " ------------", iae);
        
    }
      
    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		this.startTime = System.currentTimeMillis();
    	String className = pjp.getTarget().getClass().getSimpleName();
        String mothodName = pjp.getSignature().getName();
    	logger.debug("1.进入环绕通知------------  " + className + "." + mothodName + " ------------");
        Object object = parameterAutoWired(pjp);
        logger.debug("3.退出方法------------  " + className + "." + mothodName + " ------------");
        return object;
    } 

      
	
    
    /**
	 * 参数自动装配
	 * 
	 * 实体类自动校验 
	 * 
	 * 因为需要自动验证需要打印错误信息所以使用环绕切面
	 * 
	 * @param jp
	 * @throws Throwable
	 */
	public Object parameterAutoWired(ProceedingJoinPoint jp) throws Throwable {
		Object targetObj = jp.getTarget();
		String methodName = jp.getSignature().getName();
		Object[] parameterArray = jp.getArgs();
		Req req = null;
		Model baseEntity = null;
		
		for (Object parameter : parameterArray) {
			if (parameter instanceof Model) {
				baseEntity = (Model)parameter;
			} else if (parameter instanceof Req) {
				req = (Req) parameter;
			}
		}
		
		baseEntityParameterAutoWired(baseEntity);
		
		reqParameterAutoWired(req);
		
		Object value = null;
		if (null == value) {
			value = jp.proceed();
		}
		return value;
	}
	
	/**
	 * 实体类参数注入
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 */
	public void baseEntityParameterAutoWired(Object param) throws SecurityException, IllegalArgumentException,
            NoSuchFieldException, IllegalAccessException, InvocationTargetException {
		if (null != param && param instanceof Model) {
			Map paramMap = ThreadUtils.getWebUtil().getWebParameterMap();
			param = ThreadUtils.getEntityUtil().map2Entity(param, paramMap, true);
		}
	}
	
	/**
	 * req参数自动注入
	 * 
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 */
	public void reqParameterAutoWired(Object param)
			throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException,
            InvocationTargetException, ClassNotFoundException, InstantiationException {
		if (null != param && param instanceof Req) {
			Req req = (Req) param;
			req = ThreadUtils.getWebUtil().getWebReq(req);
		}
	}
	
	
}
