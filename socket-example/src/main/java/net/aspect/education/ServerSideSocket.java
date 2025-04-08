package net.aspect.education;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSideSocket {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9912)) { //Запуск серверного сокета.
            //Ожидаем подключения. Может работать только с одним клиентом.
            Socket accept = serverSocket.accept();
            //Создаём входящие и исходящие потоки
            DataInputStream dataInputStream = new DataInputStream(accept.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(accept.getOutputStream());
            System.out.println("Клиент написал: " + dataInputStream.readUTF());
            //Пишем ответ от сервера
            dataOutputStream.writeUTF("Привет от сервера");
            dataOutputStream.flush();
            dataOutputStream.close();
            dataInputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
