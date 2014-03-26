package at.bamgbala.newspaper.rest;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = RestApplicationConfig.class)
@WebAppConfiguration
public class AuthorApiTest {

	@Resource
	private WebApplicationContext webApplicationContext;
	
	@Test
	public void readFromEmptyListOfAuthors() throws Exception{
		MockMvc mockMvc = webAppContextSetup(webApplicationContext).build();
		mockMvc.perform(get("/authors")).andExpect(status().isOk());
	}
	
	@Test
    public void insertNewAuthor() throws Exception {
        MockMvc mockMvc = webAppContextSetup(webApplicationContext).build();
        mockMvc.
                perform(
                        post("/authors").
                                contentType(MediaType.APPLICATION_JSON).
                                content("{\"firstname\":\"Abiola\", \"surname\":\"Bamgbala\", \"username\":\"abi\",\"password\":\"hello\", \"email\":\"abi@hotmail.com\"}")).
                andExpect(status().isCreated());
    }

}
