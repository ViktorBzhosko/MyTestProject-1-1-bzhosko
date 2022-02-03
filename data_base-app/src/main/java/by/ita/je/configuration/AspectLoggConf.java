package by.ita.je.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Slf4j
@Component
public class AspectLoggConf {
    private final Logger logger = LoggerFactory.getLogger(AspectLoggConf.class.getName());

    @Pointcut("execution(public * by.ita.je.service.impl..*(..))")
    public void logMethod() {
    }

    @Before("logMethod()")
    public void beforeCall(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        logger.info(jp + args);
    }
}
