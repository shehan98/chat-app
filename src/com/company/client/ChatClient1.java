package com.company.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient1 {

    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.start();

        /*
        client.sendMessage("Hello from the client.");
        client.sendMessage("How are you?");
        client.sendMessage("I'm fine.");
        client.sendMessage("Thank you.");
        client.sendMessage("exit");

         */

        String strFromServer = "";
        while (!strFromServer.equals("exit"))
        {
            Scanner scanner = new Scanner(System.in);
            String input = client.sendMessage(scanner);
        }

        System.out.println("Client finished the execution...");

    }
}
