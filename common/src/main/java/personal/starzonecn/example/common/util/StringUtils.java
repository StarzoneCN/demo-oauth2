package personal.starzonecn.example.common.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.Locale;

/**
 * string工具类
 *
 * @author: LiHongxing
 * @email: lihongxing@bluemoon.com.cn
 * @date: Create in 2019/1/7 14:49
 * @modefied:
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 字符串格式化，支持国际化
     * @param messageSource
     * @param params
     * @return
     */
    public static String getMessage(MessageSource messageSource, String code, String[] params){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, params, locale);
    }
}
