package sombrero.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
       mockMvc.perform(get("/hello"))
               .andExpect(status().isOk())
               .andExpect(content().string("hello"));
    }

    /**
     * ContentNegotiationViewResolver
     * HTTP 요청 accept 헤더(브라우저, 클라이언트가 어떤 타입(json)의 본문의 응답을 원하는지 서버에게 알려줌.)에 따라 응답이 달라짐.
     *
     * 어떠한 요청이 들어오면 그 요청의 응답을 만들 수 있는 모든 뷰를 찾아냄.
     * 최종적으로 accept 헤더의 타입과 비교해서 응답할 뷰를 선택.
     * 클라이언트가 원하는 응답 타입을 알아낼 수 있는 가장 좋은 정보는 accept 헤더.
     * 하지만 accept 헤더 정보가 없는 경우가 있음.
     * 그래서 /path?format=pdf 파라미터를 제공.
     * */

    @Test
    public void createUser_JSON() throws Exception {
        String userJson = "{ \"username\": \"sombrero\", \"password\": \"123\" }";
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username",
                        is(equalTo("sombrero"))))
                .andExpect((jsonPath("$.password",
                        is(equalTo("123")))));
    }

    @Test
    public void createUser_XML() throws Exception {
        String userJson = "{ \"username\": \"sombrero\", \"password\": \"123\" }";
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_XML)
                .content(userJson))
                .andDo(print()) // 설정해주지 않으면 실패했을 때에 자동으로 동작함. 성공시에는 안보여줌.
                .andExpect(status().isOk())
                .andExpect(xpath("/User/username")
                    .string("sombrero"))
                .andExpect((xpath("/User/password")
                    .string("123")));
    }

}
