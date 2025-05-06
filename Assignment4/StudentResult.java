
import java.util.*;
interface Sport{
    public static int smarks=5;
    public abstract void set();
}
class student{
    int roll_no;
    void get_roll(){
        System.out.println("Enter Roll NO:");
        Scanner sc=new Scanner (System.in);
        roll_no=sc.nextInt();

    }
    void set_roll(){
        System.out.println("Roll No is:" + roll_no);
    }
}
class Test extends student{
    double sub1,sub2;
    void get_marks(){
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter marks out of 50:");
        System.out.println(" Subject 1:");
        sub1=sc.nextInt();
        System.out.println(" subject 2:");
        sub2=sc.nextInt();
    }
    void set_marks(){
        Scanner sc=new Scanner (System.in);
        System.out.println(" Marks of Sub 1:" + sub1);
       
        System.out.println(" Marks of sub 2:" + sub2);
        
    }
}
class Result extends Test implements Sport{
    double total;
    
   public  void set(){
    
        System.out.println("Is there any sport achievement?yes/no");
    Scanner sc=new Scanner(System.in);
    String sport=sc.nextLine();
    if(sport.equals("yes")){
        System.out.println("Sport marks:" + smarks);
        total=sub1+sub2+smarks;
    }else{
        total=sub1+sub2;}
        System.out.println("Total Marks:" + total);
    }

    
}

public class StudentResult {
    public static void main(String[]args){
        Result r=new Result();
        r.get_roll();
        r.get_marks();
        System.out.println("---------------");
        r.set_roll();
        r.set_marks();
        
        r.set();

    }
    
}
