package spacex.nanlabs.recruitment;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.Charset;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import spacex.nanlabs.recruitment.controller.TaskController;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskTest {

	@Autowired
	private TaskController controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void whenUserControllerInjected_thenNotNull() {
		assertThat(controller).isNotNull();
	}

	@Test
	 public void whenPostRequestToCreateTaskAndValidTask_thenCorrectResponse() throws Exception {
        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
        String task = "{\"type\": \"bug\", \"description\" : \"test para bug\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/")
                .content(task)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(textPlainUtf8));
    }
	
	

}
