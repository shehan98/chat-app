package com.company.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Client {


    private DataOutputStream outputStream;
    private BufferedReader bufferedReader;

    ///even we can place this start m
    public void start() throws IOException {
        System.out.println("Server is running...");
        Socket socket = new Socket("localhost", 6000);
        this.outputStream = new DataOutputStream(socket.getOutputStream());
        InputStream inputStream = socket.getInputStream();
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String strFromServer = "", strToClient = "";
        while (!strFromServer.equals("exit"))
        {
            strFromServer = bufferedReader.readLine();
            outputStream.writeUTF(strFromServer);
            outputStream.flush();
            strToClient = this.bufferedReader.readLine();
            System.out.println("Server says: " + strToClient);
        }
    }

    public String sendMessage(Scanner message) throws IOException {
        System.out.println("Client says: " + message);
        this.outputStream.writeBytes(message + "\n");
        String dataFromServer = this.bufferedReader.readLine();
        System.out.println("Server says: " + dataFromServer);
        return dataFromServer;
    }

}
