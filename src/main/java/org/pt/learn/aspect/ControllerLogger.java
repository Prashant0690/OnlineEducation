package org.pt.learn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerLogger {
	
	@Pointcut ("within(org.pt.learn.controller.*)")
	public void commonControllerLogging(){}
	
	@Pointcut ("within(org.pt.learn.service.*)")
	public void commonServiceLogging(){}
	
	
	// ----------------------------------------------
	// Controller Logging
	@Before ("commonControllerLogging()")
	public void controllerLoggerBefore(JoinPoint joinPoint){
		System.out.println("===============Controller Before===================>");
		System.out.println(joinPoint.toString());
	}
	
	@AfterReturning ("commonControllerLogging()")
	public void controllerLoggerAfterReturning(JoinPoint joinPoint){
		System.out.println("===============Controller After Return===================>");
		System.out.println(joinPoint.toString());
	}
	
	@AfterThrowing("commonControllerLogging()")
	public void controllerLoggerException(){
		System.out.println("===============Controller Exception===================>");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	
	}
	// Controller Logging Ends
	//----------------------------------------------
	
	@Before ("commonServiceLogging()")
	public void serviceLoggerBefore(JoinPoint joinPoint){
		System.out.println("===============Service Before===================>");
		System.out.println(joinPoint.toString());
	}
	
	@AfterReturning("commonServiceLogging()")
	public void serviceLoggerAfterReturn(JoinPoint joinPoint){
		System.out.println("===============Service After Return===================>");
		System.out.println(joinPoint.toString());
	}
	
	@AfterThrowing("commonServiceLogging()")
	public void serviceLoggerException(){
		System.out.println("===============Service Exception===================>");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	}
	

}
