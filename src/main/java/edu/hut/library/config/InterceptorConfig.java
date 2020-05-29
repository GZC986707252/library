package edu.hut.library.config;

import edu.hut.library.interceptor.DeleteMethodInterceptor;
import edu.hut.library.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 拦截器配置类
 * @Author: guozongchao
 * @Date: 2020/5/27 23:58
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(new String[]{"/login","/logout","/login.do"});

        registry.addInterceptor(new DeleteMethodInterceptor())
                .addPathPatterns("/book/**")
                .addPathPatterns("/reader/**");
    }

}
