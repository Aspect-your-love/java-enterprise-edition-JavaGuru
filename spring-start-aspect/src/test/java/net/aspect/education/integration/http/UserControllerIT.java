package net.aspect.education.integration.http;

import lombok.RequiredArgsConstructor;
import net.aspect.education.annotation.IT;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@IT
@AutoConfigureMockMvc   //Создаёт MockMVC для тестирования контроллера
@RequiredArgsConstructor
public class UserControllerIT {
    private final MockMvc mockMvc;

    @Test
    void findAll() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users")) //perfom - вызывает запросы к нашему URL
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.view().name("user/users"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("users"))
                .andExpect((MockMvcResultMatchers.model().attribute("users", IsCollectionWithSize.hasSize(9))));
    }

}
