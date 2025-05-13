import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SumClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            dos.writeInt(num1);
            dos.writeInt(num2);

            int sum = dis.readInt();
            System.out.println("Sum received from server: " + sum);

            socket.close();
        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}
