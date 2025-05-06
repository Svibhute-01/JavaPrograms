import java.util.*;
class Student{
    int roll_no;
    Scanner sc=new Scanner(System.in);
    Student(){
        System.out.println("Enter roll no.");
        roll_no=sc.nextInt();
    }
}
class Test extends Student{
    float sub1;
    float sub2;
    Test(){
        System.out.println("Enter marks out of 50:");
        System.out.println("Subject 1");
        sub1=sc.nextFloat();
        System.out.println("Subject 2");
        sub2=sc.nextFloat();
}

}
class Result extends Test{
    double result;
    double Display_Result(){
        return ((sub1+sub2)/100)*100;

    }

}
public class Multilevel {
    public static void main(String []args){
      Result r=new Result();
        System.out.println("Result"+ r.Display_Result()+"%");

    }
   
}
