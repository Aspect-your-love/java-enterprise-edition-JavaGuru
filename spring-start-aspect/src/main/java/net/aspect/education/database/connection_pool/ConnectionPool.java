package net.aspect.education.database.connection_pool;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionPool {
    private String username;
    private String password;
    private Integer poolSize;
    private String url;
}
