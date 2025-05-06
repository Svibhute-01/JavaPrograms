import java.util.*;
public class Factorial {
    public static void main(String args[]){
        int n;
        int fact=1;
        System.out.print("Enter Number:");
        Scanner sc =new Scanner(System.in);
        n=sc.nextInt();
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        System.out.println("Factorial of Number is:"+fact);
    }
}
