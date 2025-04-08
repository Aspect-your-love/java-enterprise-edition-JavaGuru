package net.aspect.education.relationship.server_and_client;

public class HttpServerRunner {
    /**
     * Производим запуск сервера. Указываем на каком порту будет работать
     * сервер, указываем размер пула потоков.*/
    public static void main(String[] args) {
        HttpServerExample httpServer = new HttpServerExample(8082, 10);
        httpServer.run();
    }
}
