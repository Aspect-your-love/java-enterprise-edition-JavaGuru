package net.aspect.education;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpSimpleClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*Билдер клиента. Можем указать версию HTTP, которую будем использовать.*/
        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        /*Создание запроса. В него передаём домен, по которому хотим обратиться.
        * Также, выбираем метод HTTP*/
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.example.net")).GET().build();
        /*Получение HTTP ответа после того, как направили запрос.*/
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        /*Выводим ТЕЛО ответа. Так как метод GET, то телом будет
        * HTML страница*/
        System.out.println(response.body());

    }
}
