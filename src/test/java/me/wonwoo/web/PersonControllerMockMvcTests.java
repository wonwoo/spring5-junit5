package me.wonwoo.web;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import me.wonwoo.spring.SpringTimingExtension;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringTimingExtension
@WebMvcTest(PersonController.class)
class PersonControllerMockMvcTests {

  @Test
  @DisplayName("😎")
  void persons(@Autowired MockMvc mvc) throws Exception {
    mvc.perform(get("/persons"))
        .andDo(print())
        .andExpect(jsonPath("$[0].name").value("wonwoo"))
        .andExpect(jsonPath("$[1].name").value("kevin"))
        .andExpect(status().isOk());
  }
}