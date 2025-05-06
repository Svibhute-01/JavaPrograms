import java.util.Scanner;

public class MergeArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter the size of the first array: ");
        int size1 = sc.nextInt();
        int[] array1 = new int[size1];
        System.out.println("Enter " + size1 + " elements for the first array:");
        for (int i = 0; i < size1; i++) {
            array1[i] = sc.nextInt();
        }

        
        System.out.print("Enter the size of the second array: ");
        int size2 = sc.nextInt();
        int[] array2 = new int[size2];
        System.out.println("Enter " + size2 + " elements for the second array:");
        for (int i = 0; i < size2; i++) {
            array2[i] = sc.nextInt();
        }

        
        int[] mergedArray = new int[size1 + size2];

        // Copy elements from the first array
        for (int i = 0; i < size1; i++) {
            mergedArray[i] = array1[i];
        }

        // Copy elements from the second array
        for (int i = 0; i < size2; i++) {
            mergedArray[size1 + i] = array2[i];
        }

        
        System.out.println("Merged Array:");
        for (int i = 0; i < mergedArray.length; i++) {
            System.out.print(mergedArray[i] + " ");
        }

        sc.close();
    }
}
