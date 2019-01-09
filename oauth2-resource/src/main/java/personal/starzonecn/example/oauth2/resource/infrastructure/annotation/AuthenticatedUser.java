package personal.starzonecn.example.oauth2.resource.infrastructure.annotation;

import org.springframework.web.bind.annotation.RequestParam;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthenticatedUser {
}
