package site.mingsha.boot.example.actuator.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ActuatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetInfo() throws Exception {
        mockMvc.perform(get("/api/actuator/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mingsha Actuator Example"));
    }

    @Test
    void testHealth() throws Exception {
        mockMvc.perform(get("/api/actuator/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }

    @Test
    void testGetStatus() throws Exception {
        mockMvc.perform(get("/api/actuator/status"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.memory").exists());
    }
} 