package net.aspect.education.relationship.server_and_client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SuppressWarnings("ALL")
public class HttpClientRunner {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        /*Создаём Http client*/
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        /*Создаём запрос HTTP. Указываем ему URI,
        * в заголовке указываем, что мы хотим отправить,
        * метод выбираем POST, указываем ему,
        * какой файл нужно прочесть.*/
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://127.0.0.1:8082"))
                .header("content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of("src/main/resources/package.json")))
                .build();

        /*Получаем HTTP ответы*/
        CompletableFuture<HttpResponse<String>> httpResponseCompletableFuture1 = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
        CompletableFuture<HttpResponse<String>> httpResponseCompletableFuture2 = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
        CompletableFuture<HttpResponse<String>> httpResponseCompletableFuture3 = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());

        /*В ответе получаем ту HTML страницу, которую отправил сервер. */
        System.out.println(httpResponseCompletableFuture1.get().body());
        System.out.println(httpResponseCompletableFuture2.get().body());
        System.out.println(httpResponseCompletableFuture3.get().body());
    }
}