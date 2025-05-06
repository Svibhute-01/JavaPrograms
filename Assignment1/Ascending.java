import java.util.Scanner;

public class Ascending {
    public static void main(String [] args){
        int arr[] = new int[10];
        System.out.println("Enter 10 numbers:");
        Scanner sc = new Scanner(System.in);
        
        // Reading input from user
        for(int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        // Sorting the array in ascending order (Bubble Sort)
        int temp;
        for(int i = 0; i < 10; i++) {
            for(int j = i + 1; j < 10; j++) { // Change j <= 10 to j < 10
                if(arr[i] > arr[j]) {
                    // Swap arr[i] and arr[j]
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // Printing the sorted array
        System.out.println("Sorted array:");
        for(int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}
