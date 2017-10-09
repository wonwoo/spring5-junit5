package me.wonwoo.web;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonController.class)
class PersonControllerMockMvcTests {

  @Test
  void persons(@Autowired MockMvc mvc) throws Exception {
    mvc.perform(get("/persons", 1))
        .andDo(print())
        .andExpect(jsonPath("$[0].name").value("wonwoo"))
        .andExpect(jsonPath("$[1].name").value("kevin"))
        .andExpect(status().isOk());
  }
}