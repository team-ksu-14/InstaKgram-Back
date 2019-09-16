package me.instakgram.boot.follow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FollowingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String url = "/api/follow";

    @Test
    public void 팔로잉_조회_테스트() throws Exception {
        mockMvc.perform(get(url + "/1/following"))
                .andDo(print());
    }

    @Test
    public void 팔로워_조회_테스트() throws Exception {
        mockMvc.perform(get(url + "/1/followers"))
                .andDo(print());
    }
}