import java.util.*;
import java.net.*;
import java.io.*;

class FactorialServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1520);
            System.out.println("Server started. Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            int num = dis.readInt();
            int result = 1;

            for (int i = 1; i <= num; i++) {
                result *= i;
            }

                        dos.writeUTF("Factorial of " + num + " is " + result);
                                  
           
        } catch (Exception e) {
            
        }
    }
}
