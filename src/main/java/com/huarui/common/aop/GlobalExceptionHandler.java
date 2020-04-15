package com.huarui.common.aop;

import com.huarui.product2020.entity.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
     * 返回的Map对象会被@ResponseBody注解转换为JSON数据返回
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultEntity handleException(HttpServletRequest request, Exception e){
    	// 返回数据
        ResultEntity result = new ResultEntity();
        //logger.error("异常通知------------------------", e);
        String var1 = "";
        
        if (e == null) {
            return null;
        } else {

            try {
                StringWriter var2 = new StringWriter();
                PrintWriter var3 = new PrintWriter(var2);
                e.printStackTrace(var3);

                for(Throwable var4 = e.getCause(); var4 != null; var4 = var4.getCause()) {
                    var4.printStackTrace(var3);
                }

                var1 = var2.toString();
                var3.close();
                var2.close();
            } catch (Exception var5) {
                var5.printStackTrace();
            }
        
        }
        
        result.setCode(0);
        result.setErrorMsg("网络开小差了，请稍候再试！");
        result.setErrorCode(var1);
        return result;
    }
    
    
    
}
