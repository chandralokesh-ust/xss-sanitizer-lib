package xss.sanitizer.lib.config;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xss.sanitizer.lib.util.XSSFilter;
import xss.sanitizer.lib.util.XSSStringDeserializer;

@Configuration
public class SecuritySanitizerConfig {

    /**
     * XSS Filter for @RequestParam and form data
     */
    @Bean
    public FilterRegistrationBean<XSSFilter> xssFilter() {

        FilterRegistrationBean<XSSFilter> registrationBean =
                new FilterRegistrationBean<>();

        registrationBean.setFilter(new XSSFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);

        return registrationBean;
    }

    /**
     * Jackson sanitizer for @RequestBody
     */
    @Bean
    public SimpleModule xssSanitizerModule() {

        SimpleModule module = new SimpleModule();
        module.addDeserializer(String.class, new XSSStringDeserializer());

        return module;
    }
}