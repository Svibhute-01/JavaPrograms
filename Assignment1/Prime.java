public class Prime {
    public static void main(String args[]){
        int n=Integer.parseInt(args[0]);
        boolean isprime=true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
            isprime=false;
            break;
            }
            
        
    if(isprime && n>1){
        System.out.println(n+ " is prime number");}
        else{
            System.out.println(n+ "is not prime number");
        }

    }
    
}
