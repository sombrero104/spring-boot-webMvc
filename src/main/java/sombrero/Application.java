package sombrero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * welcome page
     * 에러 -> 에러핸들러가 만들어주는 뷰 표시.
     *
     * / 루트 요청 시 -> 정적페이지(기본 4가지 리소스 위치 중 index.html 파일 찾음.), 동적페이지(핸들링 엔진)
     *
     */
}
