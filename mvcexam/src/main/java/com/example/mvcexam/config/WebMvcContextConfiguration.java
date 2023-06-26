package com.example.mvcexam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration      // 이 클래스는 설정 파일임. DispatcherServlet이 실행될 때 읽어들이는 설정 파일
@EnableWebMvc       // 기본적인 설정들을 함
@ComponentScan(basePackages = {"com.example.mvcexam.controller"})       // 스캔해서 Bean들을 찾을 거임
public class WebMvcContextConfiguration implements WebMvcConfigurer {

    // 해당 서브 도메인에 대한 요청은 다음과 같이 지정한 곳에서 찾으라는 설정
    // 만약 이 부분이 없다면, 컨트롤러가 가진 RequestMapping에서 찾으려고 하면서 오류를 발생시킬 것임
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }

    // 매핑 정보가 없는 요청을 처리하기 위해, default servlet handler를 사용하게 함
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }

    // 특정 URL에 대한 처리를 컨트롤러 클래스를 작성하지 않고 매핑할 수 있도록 해줌
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        System.out.println("addViewControllers가 호출됨");
        registry.addViewController("/").setViewName("main");    // "/"로 요청이 들어오면 "main"이라는 뷰를 보여주도록 함
    }

    // 뷰 이름만으로는 실제 뷰 정보를 찾을 수 없기에, ViewResolver를 사용해야 함
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // 뷰 이름 앞뒤로 붙여서 뷰 파일 경로를 찾음
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}
