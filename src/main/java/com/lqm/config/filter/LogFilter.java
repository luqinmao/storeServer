package com.lqm.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: 日志过滤器
 */
@Aspect
@Component
@Slf4j
public class LogFilter {

	//匹配com.lqm.controller包下的所有方法
//	@Pointcut("execution(public * com.lqm.controller.*.*(..))")
	//匹配com.lqm.controller包及其子包下的所有方法
	@Pointcut("execution(* com.lqm.controller..*.*(..))")
	public void log(){	}

	/**
	 * 请求服务器之前的操作
	 * @author kwum
	 */
	@Before("log()")
	public void logBeforeRequest(JoinPoint joinPoint){
		
		//请求进入服务器

		log.info("=========================================================================");
		log.info("=========================================================================");
		log.info("=========================================================================");

		log.info("request enter");
		
		//获取请求
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		//url
		log.info("url: " + request.getRequestURL());
		
		//method
		log.info("method: " + request.getMethod());
		
		//ip
		log.info("ip: " + request.getRemoteAddr());
		
		//class method
		log.info("class.method: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		
		//args
		for(Object object : joinPoint.getArgs()){
			if(null != object){
				log.info("args: " + object.toString());
			}
		}


		log.info("=========================================================================");
		log.info("=========================================================================");
		log.info("=========================================================================");
	}
	
	/**
	 * 请求服务器之后的操作
	 * @author kwum
	 */
	@After("log()")
	public void logAfterRequest(){
		
	}
	
	
	/**
	 * 服务器响应之后的操作
	 * @author kwum
	 */
	@AfterReturning(returning = "result", pointcut = "log()")
	public void logAfterResponse(String result){
		
		//response
		log.info("response: " + result);
		
		//服务器响应结束
		log.info("response complete");

	}
}
