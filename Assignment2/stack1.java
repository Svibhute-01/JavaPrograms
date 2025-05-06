import java.util.*;
public class stack1 {
   // Push operation
    int push(int n, int[] arr, int top) {
        if (top == n - 1) {
            System.out.println("Overflow condition");
        } else {
            Scanner s = new Scanner(System.in);
            top++;
            System.out.println("Push element at index " + top);
            int num = s.nextInt();
            arr[top] = num;
        }
        return top;
    }
    
    // Display operation
    void display(int n, int[] arr, int top) {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Elements in stack:");
            for (int i = top; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }
    }
    
    // Pop operation
    int pop(int[] arr, int top) {
        if (top == -1) {
            System.out.println("Underflow condition!");
        } else {
            System.out.println("Popped element: " + arr[top]);
            top--;
        }
        return top;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of stack");
        n = sc.nextInt();
        int[] arr = new int[n];
        int top = -1;
        
        Stack obj = new Stack();
        int choice;
      do{  System.out.println("1.perform push");
            System.out.println("2.dispaly");
            System.out.println("3.perform pop");
            System.out.println("4.exit");
            System.out.println("Enter Choice");
            choice=sc.nextInt();


        switch(choice){
            case 1:{
                // Push elements to the stack
        for (int i = 0; i < n; i++) {
            top = obj.push(n, arr, top);
        }
        break;

            }
            case 2:{
                obj.display(n, arr, top);
                break;
            }
            case 3:{
                while (top >= 0) {
                    top = obj.pop(arr, top);
                }
                break;

            }
            case 4:
            {
                System.out.println("Exit");
            }

            

       
        
    }
}while(choice!=4);
    }
}

    

