interface Shape{
    public final double PI=3.14;
    public abstract  double area(double d1,double d2);
}
class Rectangle implements Shape{
    public double  area(double x,double y){
        return x*y;
    }
}
class Circle implements Shape{
    public double area(double x,double y){
        return PI*x*y;
    }
}
class Triangle implements Shape{
    public double area(double x,double y){
        return x*y;
    }
}

public class Area4 {
   public static void main(String[] args){
    Shape s;
    Rectangle r=new Rectangle();
    s=r;
    System.out.println("Area of Rectangle is" + s.area(6,3));
    Circle c=new Circle();
    s=c;
    System.out.println("Area of Circle is" + s.area(3,3));
    Triangle t=new Triangle();
    s=t;
    System.out.println("Area of Triangle is" + s.area(9,5));


   }

    
}
