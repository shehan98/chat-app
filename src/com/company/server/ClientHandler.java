package com.company.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket client;

    public ClientHandler(Socket socket) {

        this.client = socket;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(30000); //wait for 28 seconds before executing the rest of the code

            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());

            //continuous reading data from client
            String inputData;
            String outputData;
            while ((inputData = bufferedReader.readLine()) != null) {

                /*
                System.out.println("Client says: " + inputData);


                switch (inputData) {
                    case "Hello from the client.":
                        outputStream.writeBytes("Hello from the server..\n");
                        break;
                    case "How are you?":
                        outputStream.writeBytes("I'm fine. How are you?\n");
                        break;
                    case "I'm fine.":
                        outputStream.writeBytes("Okay good to know. \n");
                        break;
                    case "Thank you.":
                        outputStream.writeBytes("Yor are welcome. \n");
                        break;
                    default:
                        outputStream.writeBytes("I didn't understand that. \n");
                }
                 */
                System.out.println("Client says: " + inputData);
                outputData = bufferedReader.readLine();
                outputStream.writeUTF(outputData);
                outputStream.flush();

                if (inputData.equals("exit")){
                    break;
                }
            }

            this.client.close();

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }
}
