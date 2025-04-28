package net.aspect.education.integer;

import net.aspect.education.database.connection_pool.ConnectionPool;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

@TestConfiguration
public class TestApplicationRunner {
    @MockitoSpyBean(name = "connectionPool2")
    private ConnectionPool pool1;
}
