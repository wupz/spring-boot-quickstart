package cn.dfun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.dfun.interceptor.LoginInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter { 
  @Override 
  public void addInterceptors(InterceptorRegistry registry) { 
    registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**"); 
    super.addInterceptors(registry); 
  }
}
