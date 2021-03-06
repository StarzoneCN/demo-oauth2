package personal.starzonecn.example.oauth2.resource.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import personal.starzonecn.example.common.util.StringUtils;
import personal.starzonecn.example.common.entity.Users;
import personal.starzonecn.example.oauth2.resource.infrastructure.annotation.AuthenticatedUser;
import personal.starzonecn.example.common.service.UsersService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户管理
 *
 * @author: LiHongxing
 * @email: lihongxing@bluemoon.com.cn
 * @date: Create in 2019/1/7 13:21
 * @modefied:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private UsersService usersService;
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('user_manage', 'view_user_info')")
    public Users getUserInfoById(HttpServletRequest request, @PathVariable("id") Integer id, @AuthenticatedUser Users userDetails) {
        System.out.println(userDetails);
        QueryWrapper<Users> wrapper = new QueryWrapper<Users>();
        wrapper.select("id", "username", "email", "mobile", "country_code", "address", "create_time", "enabled");
        wrapper.eq("id", id);
        Users users = usersService.getOne(wrapper);
        return users;
    }

    @PostMapping("add")
    @PreAuthorize("hasAnyAuthority('user_manage')")
    public Map<String, Object> addUser(@RequestBody Users users) {
        if (StringUtils.isBlank(users.getUsername()) || StringUtils.isBlank(users.getPassword())) {
            return new HashMap<String, Object>() {{
                this.put("success", false);
                this.put("msg",
                        StringUtils.getMessage(messageSource, "MSG_USERNAME_OR_PASSWORD_CANT_BE_NULL",
                                null));
            }};
        }
        QueryWrapper<Users> wrapper = new QueryWrapper();
        wrapper.eq("username", users.getUsername()).eq("enabled", 1);
        int count = usersService.count(wrapper);
        if (count > 0) {
            return new HashMap<String, Object>() {{
                this.put("success", false);
                this.put("msg",
                        StringUtils.getMessage(messageSource, "MSG_USER_EXISTS",
                                new String[]{users.getUsername()}));
            }};
        }
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        if (usersService.save(users)) {
            return new HashMap<String, Object>() {{
                this.put("success", true);
            }};
        }
        return new HashMap<String, Object>() {{
            this.put("success", false);
            this.put("msg",
                    StringUtils.getMessage(messageSource, "MSG_FAIL_TO_ADD_USER",
                            new String[]{users.getUsername()}));
        }};
    }

    @GetMapping("message")
    public String testMessageSource(String key) {
        return StringUtils.getMessage(messageSource, key, null);
    }
}
