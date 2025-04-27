package net.aspect.education.database.repository;


import lombok.ToString;
import net.aspect.education.database.connection_pool.ConnectionPool;
import net.aspect.education.database.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@ToString
@Repository
public class UserRepository {

    private ConnectionPool connectionPool;

    @Autowired
    public UserRepository(ConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }
}
