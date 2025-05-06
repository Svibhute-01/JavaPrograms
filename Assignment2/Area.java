public class Area {
    double length;
    double breadth;
   
    void setDim(double l,double b){
        length=l;
        breadth=b;
    }
    double get_area(){
        System.out.println("lenght" + length);
        System.out.println("Breadth" + breadth);
        return length*breadth;
    }
    public static void main(String[] args) {
        Area a=new Area();
        a.setDim(23.9, 13.4);
    

       System.out.println("Area:" + a.get_area());

    }

}
