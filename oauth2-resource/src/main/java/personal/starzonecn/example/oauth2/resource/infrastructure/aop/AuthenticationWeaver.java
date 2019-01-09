package personal.starzonecn.example.oauth2.resource.infrastructure.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import personal.starzonecn.example.oauth2.resource.infrastructure.annotation.AuthenticatedUser;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.security.Principal;

@Aspect
@Component
public class AuthenticationWeaver {

    @Before("@annotation(getMapping)")
    public void fillUserBeforeHandlerRequest(final JoinPoint joinPoint,
                                     GetMapping getMapping) throws InvocationTargetException, IllegalAccessException {
        Parameter[] parameters = ((MethodSignature)joinPoint.getSignature()).getMethod().getParameters();
        if (parameters.length == 0){
            return;
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Principal principal = request.getUserPrincipal();
        Authentication authentication;
        if (principal == null){
            return;
        }
        if (!(principal instanceof Authentication)){
            return;
        } else {
            authentication = (Authentication)principal;
        }
        for (int i=0; i<parameters.length; i++){
            if (parameters[i].getAnnotation(AuthenticatedUser.class) != null
                    && authentication.getPrincipal() != null){
                joinPoint.getArgs()[i] = authentication.getPrincipal();
            }
        }
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        method.invoke(joinPoint.getTarget(), joinPoint.getArgs());
    }

    // private Users fillUsersFromAuthentication(Authentication authentication, Users users){
    //     User user = authentication.getPrincipal();
    //     users.setUsername(aut)
    // }
}
