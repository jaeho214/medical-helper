package kr.ac.skuniv.medicalhelper.global.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MethodLogAspect {

    @Before("execution(* kr.ac.skuniv.medicalhelper.domain.*.service.*.*(..))")
    public void printMethodName(JoinPoint jp){
        log.info("메소드 호출 => {}", jp.getSignature().getName());
    }
}
