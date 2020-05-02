package edu.mum.dream.aspect;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declarations
	@Pointcut("execution(* edu.mum.dream.rest.*.*(..))")
	private void forRestControllerPackage() {
	}

	// do the same for service and dao
	@Pointcut("execution(* edu.mum.dream.dao.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* edu.mum.dream.service.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forRestControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("data/loggingfile.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter,true);
			// display method we are calling
			String theMethod = theJoinPoint.getSignature().toShortString();
			myLogger.info("=====>> in @Before: calling method: " + theMethod);
			
			printWriter.println("=====>> in @Before: calling method: " + theMethod);
			
			// display the arguments to the method
			// get the arguments
			Object[] args = theJoinPoint.getArgs();

			
			// loop thru and display args
			for (Object tempArg : args) {
				myLogger.info("=====>> argument: " + tempArg);
				printWriter.println("=====>> argument: " + tempArg);
				
			}
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("data/loggingfile.txt",true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
		

		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @AfterReturning: from method: " + theMethod);
		printWriter.println("=====>> in @AfterReturning: from method: " + theMethod);
		
		// display data returned
		myLogger.info("=====>> result: " + theResult);
		printWriter.println("=====>> result: " + theResult);
		
		printWriter.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
