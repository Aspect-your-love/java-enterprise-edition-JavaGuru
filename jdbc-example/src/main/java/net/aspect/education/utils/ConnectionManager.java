package net.aspect.education.utils;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*Утильный класс для получения подключения*/
public final class ConnectionManager {
    private static final String URL_KEY = "db.url";
    private static final String USERNAME_KEY = "db.username";
    private static final String PASSWORD_KEY = "db.password";
    private static final int DEFAULT_POOL_SIZE = 10;
    private static final String POOL_SIZE_KEY = "db.pool.size";
    private static BlockingQueue<Connection> pool;

    private ConnectionManager() {
    }

    static {
        initConnectionPool();
    }

    ///  Инициализируем пул соединений
    private static void initConnectionPool() {
        String poolSize = PropertiesUtil.get(POOL_SIZE_KEY);
        int size = poolSize == null ? DEFAULT_POOL_SIZE : Integer.parseInt(poolSize);
        pool = new ArrayBlockingQueue<>(size);

        for (int i = 0; i < size; i++) {
//            pool.add(open());
            /*
              Рефлексия.
              Если был вызван метод close у
              объекта Connection, то мы добавляем
              ещё одно соединение, которое является объектом Proxy (кастуем типы).
              Если метод продолжает свою работу, то просто отправляем его работать дальше
              с тем же набором аргументов.
            */
            Connection connection = open();
            Connection proxyConnection = (Connection) Proxy.newProxyInstance(ConnectionManager.class.getClassLoader(),
                    new Class[]{Connection.class}
                    , (proxy, method, args) -> method.getName().equals("close")
                            ? pool.add((Connection) proxy)
                            : method.invoke(connection, args));

            pool.add(proxyConnection);
        }
    }

    public static Connection get() {
        try {
            return pool.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection open() {

        try {
            return DriverManager.getConnection(
                    PropertiesUtil
                            .get(URL_KEY)
                    , PropertiesUtil.get(USERNAME_KEY)
                    , PropertiesUtil.get(PASSWORD_KEY));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
