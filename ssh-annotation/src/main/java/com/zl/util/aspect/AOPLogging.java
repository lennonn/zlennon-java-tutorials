package com.zl.util.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class AOPLogging {

		@Pointcut("execution(* com.zl.persistence.hibernate.*Impl.*(..))")
		public void cutPersistenceOperator() {

		}

		@Before("cutPersistenceOperator()")
		public void beforeAdvice() {
			System.out.println("*** Logging BEFORE method execution  ***");
		}

		@After("cutPersistenceOperator()")
		public void afterAdvice() {
			System.out.println("*** Logging AFTER method execution ***");
		}

		@AfterReturning(pointcut = "cutPersistenceOperator()", returning = "retVal")
		public void afterReturningAdvice(Object retVal) {
			System.out.println("*** Returning Value : " + retVal.toString()
					+ " ***");
		}
}
