package com.example.demo.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class logBook {
    @AfterReturning("execution(public * com.example.demo.service.BookService.*(..)))")
    public void logBookService(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.err.println("Class là: " + className + " Và medthod là: " + methodName);
    }

    @AfterReturning("execution(public * com.example.demo..service.LibraryService.*(..)))")
    public void logLibraryService(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.err.println("Class là: " + className + " Và medthod là: " + methodName);
    }
}
