package client2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MainClient {
    private static Socket socket;
    private static DataInputStream in;
    private static DataOutputStream out;


    public static void main(String[] args) {
            try {
                socket = new Socket("localhost", 8189);
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                DataInputStream inS = new DataInputStream(socket.getInputStream());
                DataOutputStream outS = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

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
                String str = null;
                try {
                    str = in.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Server: " + str);
            }
    }
}

