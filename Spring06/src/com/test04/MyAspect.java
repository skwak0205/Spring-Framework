package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// 참고 - https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop-api-advice


@Aspect
public class MyAspect {
	
	@Before("execution(public * *(..))") // 타겟의 실행 전
	public void before(JoinPoint join) {
		System.out.println("출석카드 찍는다.");
	}
	
	@AfterThrowing("execution(public * *(..))") // 타겟을 호출하는 상황에서 예외가 발생했을 때
	public void throwing(JoinPoint join) {
		System.out.println("쉬는 날 이었다.");
	}
	
	// 정상적으로 실행된 이후에 리턴되는 값이 있으면 실행
	@AfterReturning(pointcut="execution(public * *(..))", returning="returnVal")
	public void returning(JoinPoint join, Object returnVal) {
		System.out.println(returnVal + " 공부하는 날이었다.");
	}
	
	// 타겟 실행 후
	@After("execution(public * *(..))")
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
}
