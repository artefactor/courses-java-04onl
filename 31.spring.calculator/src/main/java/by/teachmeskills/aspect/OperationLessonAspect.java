package by.teachmeskills.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//TODO run, and then rename to operation and show what happens
@Aspect
@Component
public class OperationLessonAspect {

	@Pointcut("execution(*  by.teachmeskills.opetation.ISimpleOperation.process(..))")
	public void allProcessMethods() {
	}

	@Around("@annotation(by.teachmeskills.aspect.CustomOperation)")
	public Object hasAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("hasAnnotation ");
		return joinPoint.proceed();
	}

	@Around(value = "allProcessMethods()")
	public Object aspect(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		System.out.println("args: " + Arrays.toString(args));
		Object proceedResult = joinPoint.proceed();

		System.out.println("result is : " + proceedResult);
		return proceedResult;
	}

	@AfterThrowing(value = "allProcessMethods()", throwing = "e")
	public void afterProcessThrows(Throwable e) {
		e.printStackTrace();
	}

	//    @Pointcut("execution(* by.teachmeskills.opetation.division.DivisionOperation.process(..))")
//    public void divisionProcessMethod() {}

	//    @Before("divisionProcessMethod()")
//    public void beforeDivisionProcess(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        if (((Integer) args[1]) == 0) {
//            args[1] = 1;
//        }
//    }
}
