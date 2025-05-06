import java.util.*;
public class Names {
    public static void main(String args[]) 
 	{ 
  String[] names = new String[10];   
  Scanner sc = new Scanner(System.in);  
   for(int i =0;i<10;i++) 
 	 	{ 
 	 	 	names[i] = sc.nextLine(); 
 	 	} 
 	 	int arr[] = new int[10];  	 	
        for(int i =0;i<10;i++){  	 	 	
            arr[i] = (int)names[i].charAt(0); 
 	 	} 
 	 	for(int i=0;i<10;i++) 
 	 	{ 
 	 	 	for(int j = i+1;j<10;j++) 
 	 	 	{ 
 	 	 	 	if(arr[i] > arr[j]) 
 	 	 	 	{ 
 	 	 	 	 	int temp = arr[j];  	 	
                    arr[j] = arr[i];  	 	 	 	 	
                    arr[i] = temp; 
	 	 	} 
	 	} 
} 
 	 	System.out.println(); 
  System.out.println("Names in alphabetical order");  
   for(int i =0;i<10;i++){ 
       for(int j =0;j<10;j++){
        if(arr[i] == (int)names[j].charAt(0)){ 
 	 	 	 	 	System.out.println(""+names[j]); 
 	 	 	 	} 
 	 	 	} 
 	 	} 
		  sc.close();
 	} 
 

    
}
