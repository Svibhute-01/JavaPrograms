

import java.util.*;
interface Stack{
    public  int size=5;
    public void push();
    public void pop();
    public void display();
}
class IntegerStack implements Stack{
    int top=-1;
    int [] arr=new int[size];
    int num;
    Scanner sc=new Scanner(System.in);
    public void push(){
        
        if(top==size-1){
            System.out.println("Stack is full");
        }else {
            top++;
            System.out.println("Enter the element to push");
            num=sc.nextInt();
            arr[top]=num;
     }
}
public void pop(){
    if(top==-1){
        System.out.println("Satck is empty");
    }else{
        System.out.println("Element popped is" + arr[top]);
        top--;
    }
   
}
public void display(){
    if(top==-1){
        System.out.println("Stack is empty");
    }else{
        for(int i=top;i>=0;i--){
            System.out.println(arr[i]);
        }
    }
}

}
class StackOp{
    public static void main(String[]args){
        IntegerStack s=new IntegerStack();
        Scanner sc=new Scanner(System.in);
        int ch;
        while (true) { 
            System.out.println("1.push 2.pop 3.display 4.exit");
            System.out.println("Enter your Choice");
            ch=sc.nextInt();
            switch(ch){
                case 1:
                 s.push();
                 break;
                case 2:
                {
                    s.pop();
                }
                break;
                case 3:{
                System.out.println("Elements in Stack:");
                s.display();
                break;}
                case 4:
                System.out.println("exit");
                }
            }
        }
}
    


                
               
                