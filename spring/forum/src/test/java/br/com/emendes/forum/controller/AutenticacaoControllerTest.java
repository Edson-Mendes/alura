package br.com.emendes.forum.controller;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AutenticacaoControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void deveriaDevolver400CasoDadosDeAuthEstejamIncorretos() throws Exception {
    URI uri = new URI("/auth");
    String json = "{\"email\":\"invalid@email.com\",\"senha\":\"1234\"}";

    mockMvc
        .perform(MockMvcRequestBuilders
            .post(uri)
            .content(json)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers
            .status()
            .is(400));
  }

  @Test
  public void deveriaDevolver200QuandosForemValidos() throws Exception {
    URI uri = new URI("/auth");
    String json = "{\"email\":\"aluno@email.com\",\"senha\":\"123456\"}";

    mockMvc
        .perform(MockMvcRequestBuilders
            .post(uri)
            .content(json)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers
            .status()
            .is(200));
  }

}
