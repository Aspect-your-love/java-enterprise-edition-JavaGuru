package net.aspect.education.database.repository;


import lombok.ToString;
import net.aspect.education.bpp.InjectBean;
import net.aspect.education.database.connection_pool.ConnectionPool;

@ToString
public class UserRepository {

    @InjectBean
    private ConnectionPool connectionPool;

}
