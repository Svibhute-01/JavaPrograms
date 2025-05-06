abstract class Shape{
    double dim1;
    double dim2;
    abstract double area();
    Shape(double d1,double d2){
        dim1=d1;
        dim2=d2;
    }
}
class Rectangle extends Shape{
    Rectangle(double d1,double d2){
        super(d1,d2);
    }
    double area(){
        return dim1*dim2;
    }
}
class Triangle extends Shape{
    Triangle(double a, double b){
        super(a,b);

    }
    double area( ){
        return 0.5*dim1*dim2;
    }
}
class Area{
    public static void main(String [] args){
        Rectangle rect=new Rectangle(9,4);
        Shape s;
        s=rect;
        System.out.println("Area of rectangle is" + s.area());
        Triangle t=new Triangle(10,5);
        s=t;
        System.out.println("Area of rectangle is" + s.area());
        }

}