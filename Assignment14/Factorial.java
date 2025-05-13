import java.util.*;
import java.net.*;
import java.io.*;

class Factorial {
    public static void main(String[] args) {
        try {
            Socket s1 = new Socket("localhost", 1520);
            DataInputStream dis = new DataInputStream(s1.getInputStream());
            DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a number: ");
            int num = sc.nextInt();
            dos.writeInt(num); 
           

            String result = dis.readUTF(); 
            System.out.println("Result from server: " + result);

            
        } catch (Exception e) {
            
        }
    }
}
