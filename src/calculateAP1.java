
abstract class Shape{
    public abstract double calculatearea();
    public abstract double calculateperimeter();
}
class Circle extends Shape{
    double radius;
    public Circle(double radius){
        this.radius=radius;
    }
    public double calculatearea(){
        return Math.PI*radius*radius;
    }
    public double calculateperimeter(){
        return 2*Math.PI*radius;
    }

}
class Rectangle extends Shape{
    double length;
    double width;
    public Rectangle(double length,double width){
        this.length=length;
        this.width=width;
    }
    public double calculatearea(){
        return length*width;
    }
    public double calculateperimeter(){
        return 2*(length+width);
    }
}
class Triangle extends Shape{
    double base;
    double height;
    public Triangle(double base,double height){
        this.base=base;
        this.height=height;
    }
    public double calculatearea(){
        return 0.5*base*height;
    }
    public double calculateperimeter(){
        return 3*base;
    }
}

public class calculateAP1 {
    
}
