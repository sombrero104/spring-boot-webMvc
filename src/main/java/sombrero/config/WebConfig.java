package sombrero.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 스프링 웹 MVC가 제공하는 설정에 추가적으로 설정을 하고 싶을 경우 WebMvcConfigurer를 implements 해서 사용.
 */
@Configuration
// @EnableWebMvc // @EnableWebMvc 를 정의할 경우 스프링이 제공하는 설정이 모두 제거되고 직접 모든 설정을 해야 함.
public class WebConfig implements WebMvcConfigurer {


    /**
     * /Users/sombrero104/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/2.1.6.RELEASE/spring-boot-autoconfigure-2.1.6.RELEASE.jar!/META-INF/spring.factories
     *
     * HiddenHttpMethodFilter
     * PUT, DELETE, PATCH 요청(HTTP 요청 METHOD)이 올 경우 _METHOD 라는 히든폼 파라미터로 어떤 METHOD 인지 값을 받아올 수 있음.
     * 그리고 그 값을 받아와서 컨트롤러에 매핑함.
     * 예: @DeleteMapping -> 이런 핸들러를 만들 수 있도록 도와주는 역할을 하는 필터.
     *
     * /Users/sombrero104/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/2.1.6.RELEASE/spring-boot-autoconfigure-2.1.6.RELEASE.jar!/org/springframework/boot/autoconfigure/web/servlet/WebMvcProperties.class
     * WebMvcProperties
     * Web MVC 관련 프로퍼티즈 파일을 읽어오는 역할. (spring.mvc로 시작하는 프로퍼티즈.)
     *
     * /Users/sombrero104/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/2.1.6.RELEASE/spring-boot-autoconfigure-2.1.6.RELEASE.jar!/org/springframework/boot/autoconfigure/web/ResourceProperties.class
     * ResourceProperties
     * (spring.resources로 시작하는 프로퍼티즈.)
     */

    /**
     * 기존에 제공하는 리소스 핸들러를 유지하면서 새로 추가하는 방법.
     * 원하는 리소스 핸들러만 추가할 수 있음.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/m/**")
                .addResourceLocations("classpath:/m/")
                .setCachePeriod(20);
    }

    /**
     * WebJars
     * JQuery, Bootstrap, View.js, Anguler, React.js
     * 모두 jar파일로 dependency를 추가할 수 있음.
     * 템플릿으로 동적으로 리소스를 생성할 때,
     * 혹은 정적 리소스에서 WebJars에 있는 css나 자바스크립트 등을 참조 가능.
     * 메이븐 저장소에서 찾을 수 있음.
     */

}
