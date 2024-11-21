import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
public class StudentControllerTest {

    @Autowired
    private StudentController studentController;

    private MockMvc mockMvc;

    @Test
    public void testGetAllStudents() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddStudent() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"studentId\": 1, \"name\": \"John\", \"age\": 22, \"sexuality\": \"Straight\"}"))
                .andExpect(status().isCreated());
    }
    
}