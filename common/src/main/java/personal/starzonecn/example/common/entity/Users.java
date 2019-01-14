package personal.starzonecn.example.common.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author LiHongxing
 * @since 2019-01-07
 */
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Component
@Primary
public class Users implements UserDetails {
    private static final long serialVersionUID = 1L;

    public Users(){}
    @TableId(value = "id", type = IdType.AUTO)
    @Setter@Getter
    private Integer id;

    @TableField("username")
    @Setter@Getter
    private String username;

    @TableField("password")
    @Setter
    @ToString.Exclude
    @JsonIgnore
    private String password;

    @TableField("email")
    @Setter@Getter
    private String email;

    @TableField("mobile")
    @Setter@Getter
    private String mobile;

    @TableField("country_code")
    @Setter@Getter
    private String countryCode;

    @TableField("address")
    @Setter@Getter
    private String address;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @Setter@Getter
    private LocalDateTime createTime;

    @TableField("enabled")
    @TableLogic
    @Setter
    private Boolean enabled;

    @TableField(exist = false)
    @Setter@Getter
    private Set<GrantedAuthority> authorities;
    @TableField(exist = false)
    @Setter
    @NonNull
    @JsonIgnore
    private boolean accountNonExpired;
    @TableField(exist = false)
    @Setter
    @NonNull
    @JsonIgnore
    private boolean accountNonLocked;
    @TableField(exist = false)
    @Setter
    @NonNull
    @JsonIgnore
    private boolean credentialsNonExpired;


    public static final String ID = "id";

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String EMAIL = "email";

    public static final String MOBILE = "mobile";

    public static final String COUNTRY_CODE = "country_code";

    public static final String ADDRESS = "address";

    public static final String CREATE_TIME = "create_time";

    public static final String ENABLED = "enabled";

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
