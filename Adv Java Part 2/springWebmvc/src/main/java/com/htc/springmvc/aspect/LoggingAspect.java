package com.htc.springmvc.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class LoggingAspect implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice
{
	public void before(Method method, Object[] params, Object target) throws Throwable
	{	
		Log logger = LogFactory.getLog(target.getClass().toString());
		logger.info("Calling - " +target.getClass().toString() + "--" +method.getName());
		logger.info("Params-" + Arrays.toString(params));
		logger.info("-------------------------------------------------------------------");
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] params, Object target) throws Throwable 
	{
		Log logger = LogFactory.getLog(target.getClass().toString());
		logger.info("Calling - " +target.getClass().toString() + "--" +method.getName());
		logger.info("Params-" + Arrays.toString(params));
		logger.info("-------------------------------------------------------------------");
	}

	public void afterThrowing(Method method, Object[] args, Object target, Exception ex)
	{
		Log logger = LogFactory.getLog(target.getClass().toString());
		logger.info(method.getName() + " throws exception");
		logger.error("Error :" + ex.toString());
		logger.info("-------------------------------------------------------------------");
	}
}
