package sombrero.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * HttpMessageConverters 사용.
     * 요청인 @RequestBody의 Content Type이 JSON이고 본문도 JSON일 경우 JSON Converter가 사용이 되어 객체로 만들어줌.
     * 응답인 @ResponseBody는 반환 객체가 Composition Type(속성을 가진) 객체일 경우에는 기본적으로 JSON 타입으로 반환됨.
     *  그냥 숫자나 문자열일 경우에는 String Message Converter가 사용됨.
     *
     *  @RestController 가 붙어있으면 @ResponseBody를 생략해도 됨.
     *  @ResponseBody 가 생략되어 있는 것.
     *  그냥 @Controller인 경우에는 리졸버를 Bean Name Resolver를 사용해서 반환하는 값의 이름을 가진 뷰를 찾으려고 시도함.
     *  @RestController를 붙이면 Bean Name Resolver를 타지 않고 Message Converter를 타서
     *  응답 본문으로 내용이 들어가게 됨.
     */
    /*@PostMapping("/user")
    public @ResponseBody User create(@RequestBody User user) {
        return null;
    }*/

    @PostMapping("/users/create")
    public User create(@RequestBody User user) {
        return user;
    }

    /**
     *
     * 정적 리소스 맵핑 “/**”
     *
     * ● 기본 리소스 위치
     * ○ classpath:/static
     * ○ classpath:/public
     * ○ classpath:/resources/
     * ○ classpath:/META-INF/resources
     *
     * ○ 예) “/hello.html” => /static/hello.html
     *
     * ○ spring.mvc.static-path-pattern: 맵핑 설정 변경 가능
     * ○ spring.mvc.static-locations: 리소스 찾을 위치 변경 가능
     * ● Last-Modified 헤더를 보고 304 응답을 보냄.
     * ● ResourceHttpRequestHandler가 처리함.
     * ○ WebMvcConfigurer의 addRersourceHandlers로 커스터마이징 할 수 있음
     *
     *
     * 정적 리소스 지원 (동적으로 생성한 리소스가 아닌 것.)
     * 브라우저, 클라이언트에서 요청이 왔을 때 만들어져 있는 리소스를 보내주는 것.
     * 요청이 왔을 때 서버에서 작업을 처리해서 뷰를 만드는 것이 아니라 이미 만들어진 리소스를 제공.
     */

}
