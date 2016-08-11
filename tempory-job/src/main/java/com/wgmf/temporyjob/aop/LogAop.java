package com.wgmf.temporyjob.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {
	
	
	//@After(value = "execution(public * *(..))&&@annotation(com.wgmf.temporyjob.aop.Log)")
    private void afterExecuteTargetMethod(JoinPoint joinPoint) {  
		System.out.println(((MethodSignature)joinPoint.getSignature()).getMethod().toString());
        System.out.println("�ڵ���Ŀ�귽��֮�������");  
    }  

	@Around(value = "execution(public * *(..))&&@annotation(com.wgmf.temporyjob.aop.Log)")
	private Object AroundExecuteTargetMethod(ProceedingJoinPoint pjp) throws Throwable {  
        System.out.println("�ڵ���Ŀ�귽��֮ǰ������");  
        Object[] a = {"you"};
        try {
			return pjp.proceed(a);
		} catch (Throwable e) {
			throw e;
		}
    }  
}
