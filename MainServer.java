package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Long client");
            Socket socket = serverSocket.accept();
            System.out.println("Start");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Scanner scanner = new Scanner(System.in);
                            String str = scanner.nextLine();
                            out.writeUTF(str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            while (true) {
                String str = in.readUTF();
                System.out.println("Client: " + str);
                if (str.equals("end")) break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
