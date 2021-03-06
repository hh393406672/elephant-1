package com.sjhy.platform;

import com.sjhy.platform.biz.utils.GetBeanHelper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Hello world!
 *
 */
@MapperScan("com.sjhy.platform.persist.mysql")
@SpringBootApplication(scanBasePackages = {"com.sjhy.platform"})
@ImportResource("classpath:spring/application-context.xml")
@EnableCaching
public class App extends WebMvcConfigurationSupport
{
    public static void main( String[] args )
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
        GetBeanHelper.setApplicationContext(ac);
        SpringApplication.run(App.class, args);
    }

}
