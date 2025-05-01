package net.aspect.education.integration;

import net.aspect.education.database.connection_pool.ConnectionPool;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

@TestConfiguration
public class TestApplicationRunner {
    // Создали нвоый бин, чтобы не перезапускать
    // контекст заново
    @MockitoSpyBean(name = "connectionPool2")
    private ConnectionPool pool1;
}
