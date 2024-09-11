package az.ingress.aspect;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class ElapsedTimeLogger {
    @Pointcut(value = "execution(* az.ingress.service.abstraction.PaymentService.*(..))")
    public void elapsedTimePointCut() {

    }

    @SneakyThrows
    @Around(value = "elapsedTimePointCut()")
    public Object around(ProceedingJoinPoint joinPoint){
        var startTime = System.currentTimeMillis();
        var response = joinPoint.proceed();
        var endTime = System.currentTimeMillis();
        log.info("Elapsed time:{} ", endTime - startTime);
        return response;
    }
}
