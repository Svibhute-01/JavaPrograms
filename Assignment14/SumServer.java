import java.io.*;
import java.net.*;

public class SumServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read two integers from the client
            int num1 = dis.readInt();
            int num2 = dis.readInt();
            System.out.println("Received numbers: " + num1 + ", " + num2);

            int sum = num1 + num2;
            dos.writeInt(sum);
            System.out.println("Sent sum: " + sum);

            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}
