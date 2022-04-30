package com.codegym.config;

import com.codegym.service.IServiceMailbox;

import com.codegym.service.ServiceMailboxImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.codegym")
public class AppConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    // Khai báo view
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }




    // Khai báo bean trong file config
//    @Bean
//    @Qualifier("studentService1")
//    public StudentService getStudentService() {
//        return new StudentServiceImpl();
//    }

    @Bean
    public IServiceMailbox getServiceMailbox() {
        return new ServiceMailboxImpl();
    }

//    @Bean
//    public IServicePageSize getServicePageSize() {
//        return new PageSizeServiceImpl();
//    }
//    @Bean
//    public IPageSizeRepository getPageSizeRepository() {
//        return new PageSizeRepositoryImpl();
//    }
//    @Bean
//    public ILanguagesRepository getLanguagesRepository() {
//        return new LanguagesRepository();
//    }
//    @Bean
//    public IServiceLanguages getServiceLanguages() {
//        return new LanguagesServiceImpl();
//    }
}
