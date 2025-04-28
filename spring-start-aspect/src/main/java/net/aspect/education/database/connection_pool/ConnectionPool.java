package net.aspect.education.database.connection_pool;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@ToString
@Component
public class ConnectionPool {
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.pool.size}")
    private Integer poolSize;
    @Value("${db.url}")
    private String url;

    @PostConstruct
    private void init(){
        log.info("Connection pool initialized");
    }
}
