package net.aspect.education;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSideSocket {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9912);
             DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
             DataInputStream reader = new DataInputStream(socket.getInputStream());) {
            writer.writeUTF("Привет от клиента!");
            System.out.println("Сервер прислал: " + reader.readUTF());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
