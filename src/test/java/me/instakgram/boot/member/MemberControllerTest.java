package me.instakgram.boot.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private final String url = "/api/members";

    @Test
    public void 회원가입_테스트() throws Exception {
        MemberRegisterDto memberRegisterDto = new MemberRegisterDto();
        memberRegisterDto.setEmail("ksyj8256@gmail.com");
        memberRegisterDto.setName("민경환");
        memberRegisterDto.setNickname("MinKH");
        memberRegisterDto.setPassword("1q2w3e4r!");

        mockMvc.perform(post(url)
                    .content(objectMapper.writeValueAsString(memberRegisterDto)).with(csrf())
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void 회원조회_테스트() throws Exception {
        mockMvc.perform(get(url))
                .andDo(print());
    }

}