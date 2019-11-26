package com.example.demo;

import com.example.demo.domain.TbUser;
import com.example.demo.service.TbUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = SpringBootTestingApplication.class)
class SpringBootTestingApplicationTests {

    private MockMvc mockMvc;
    private MockHttpSession session;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    ObjectMapper mapper;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession();
        TbUser user = new TbUser();
        user.setLoginName("Dopa");
        user.setPhone("117");
        session.setAttribute("user", user);
    }


    @Test
    void contextLoads() throws Exception {
//		mockMvc.perform(
//				 MockMvcRequestBuilders.get("/user/{id}", "scott")
//				.contentType(MediaType.APPLICATION_JSON_UTF8))
//		.andExpect(MockMvcResultMatchers.status().isOk())
//		.andExpect(MockMvcResultMatchers.jsonPath("$.username").value("scott"))
//		.andDo(MockMvcResultHandlers.print());

//		String jsonStr = "{\"username\":\"Dopa\",\"passwd\":\"ac3af72d9f95161a502fd326865c2f15\",\"status\":\"1\"}";

        TbUser user = new TbUser();
        user.setId(100L);
        user.setLoginName("Dopa");
        user.setPhone("117");
        tbUserService.add(user);

        String userJson = mapper.writeValueAsString(user);
//		mockMvc.perform(MockMvcRequestBuilders.post("/user/save").content(jsonStr.getBytes()));

        mockMvc.perform(
                MockMvcRequestBuilders.post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(userJson.getBytes()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

//		mockMvc.perform(MockMvcRequestBuilders.get("/hello?name={name}","Administrator"));
//		mockMvc.perform(MockMvcRequestBuilders.post("/user/{id}", 1));
//		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/fileupload").file("file", "文件内容".getBytes("utf-8")));
//		mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("message", "hello"));
//		mockMvc.perform(MockMvcRequestBuilders.get("/hobby/save").param("hobby", "sleep", "eat"));

//		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//		params.add("name", "Administrator");
//		params.add("hobby", "sleep");
//		params.add("hobby", "eat");
//		mockMvc.perform(MockMvcRequestBuilders.get("/hobby/save").params(params));
//		mockMvc.perform(MockMvcRequestBuilders.get("/index").sessionAttr(name, value));
//		mockMvc.perform(MockMvcRequestBuilders.get("/index").cookie(new Cookie(name, value)));
//		mockMvc.perform(MockMvcRequestBuilders.get("/index").contentType(MediaType.APPLICATION_JSON_UTF8));
//		mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", 1).accept(MediaType.APPLICATION_JSON));
//		mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", 1).header(name, values));

//		mockMvc.perform(MockMvcRequestBuilders.get("/index"))
//		.andDo(MockMvcResultHandlers.print());
    }

}
