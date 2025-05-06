import java.util.*;
public class AlphabeticalSort{
    public static boolean isGreater(String s1,String s2){
        int minlen=Math.min(s1.length(),s2.length());
        
        for(int i=0;i<minlen;i++){
        if(s1.charAt(i)>s2.charAt(i)){
        return true;
        }else if(s1.charAt(i)<s2.charAt(i)){
        return false;
        }
        
        
        }
        return s1.length()>s2.length();
        }
public static void main(String []args){
Scanner sc=new Scanner(System.in);
System.out.println("Enter the size of the arry:");
int size=sc.nextInt();
sc.nextLine();
String name[]=new String[size];
for(int i=0;i<size;i++){
name[i]=sc.nextLine();
}

for(int i=0;i<size-1;i++){
for(int j=0;j<size-i-1;j++){
if(isGreater(name[j],name[j+1])){
String temp=name[j];
name[j]=name[j+1];
name[j+1]=temp;
}
}
}
for(int i=0;i<size;i++){
System.out.println(name[i]);
}



}


}