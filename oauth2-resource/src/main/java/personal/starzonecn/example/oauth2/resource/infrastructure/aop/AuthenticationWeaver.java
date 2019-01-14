package personal.starzonecn.example.oauth2.resource.infrastructure.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import personal.starzonecn.example.common.entity.Users;
import personal.starzonecn.example.oauth2.resource.infrastructure.annotation.AuthenticatedUser;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.security.Principal;

@Aspect
@Component
public class AuthenticationWeaver {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationWeaver.class);

    @Around("@annotation(getMapping)")
    public Object fillUserBeforeHandlerRequest(final ProceedingJoinPoint joinPoint,
                                     GetMapping getMapping) throws Throwable {
        Parameter[] parameters = ((MethodSignature)joinPoint.getSignature()).getMethod().getParameters();
        if (parameters.length == 0){
            return joinPoint.proceed();
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Principal principal = request.getUserPrincipal();
        Authentication authentication;
        if (principal == null){
            return joinPoint.proceed();
        }
        if (!(principal instanceof Authentication)){
            return joinPoint.proceed();
        } else {
            authentication = (Authentication)principal;
        }
        Object[] args = new Object[joinPoint.getArgs().length];
        for (int i=0; i<parameters.length; i++){
            if (parameters[i].getAnnotation(AuthenticatedUser.class) != null
                    && authentication.getPrincipal() != null
                    && authentication.getPrincipal() instanceof Users
                    && parameters[i].getType() == Users.class){
                args[i] = authentication.getPrincipal();
            } else {
                args[i] = joinPoint.getArgs()[i];
            }
        }
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        return joinPoint.proceed(args);
    }

    // private Users fillUsersFromAuthentication(Authentication authentication, Users users){
    //     User user = authentication.getPrincipal();
    //     users.setUsername(aut)
    // }
}
