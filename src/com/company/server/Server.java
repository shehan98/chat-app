package com.company.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException { //main thread

        System.out.println("Server is running...");
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server socket created");

        while (true) {
            //server is running forever...
            Socket client = serverSocket.accept(); //wait until a client connects
            System.out.println("Server accepted a client.");
            ClientHandler clientHandler = new ClientHandler(client);
            Thread thread = new Thread(clientHandler);
            thread.start();

        }

    }
    /// accept the user inputs using command line
    /// use a GUI for client and server
    /// encrypt messages between client and the server
    /// limit the number of clients
}
