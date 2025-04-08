package net.aspect.education.relationship.server_and_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerExample {
    private final int port;
    // Создаём пул потоков для того, чтобы можно было выполнять
    // запросы асинхронно
    private final ExecutorService executorService;

    // В конструктор передаём логический порт и размер пула потоков
    public HttpServerExample(int port, int poolSize){
        this.port = port;
        executorService = Executors.newFixedThreadPool(poolSize);
    }

    /**
     * Данный метод служит для получения входящего подключения.
     * Сам он не обрабатывает запрос. Запрос обрабатывается
     * в методе processSocket(Socket)*/
    public void run(){
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            // Перенаправляем выполнение запроса в поток, дальше ждём нового подключения
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress());
                executorService.submit(() -> processSocket(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Выполняет обработку запроса на сокете*/
    private void processSocket(Socket socket){
        try(socket;
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream())){
            Thread.sleep(10000);
            System.out.println(new String(in.readNBytes(400)));

            byte[] bytes = Files.readAllBytes(Path.of("src/main/resources/example-git.html"));
            out.write("""
                    HTTP/1.1 200 OK
                    content-type: text/html
                    content-length: %s
                    """.formatted(bytes.length).getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write(bytes);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
