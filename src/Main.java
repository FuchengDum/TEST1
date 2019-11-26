import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        ShapeFactory shapeFactory=new ShapeFactory();
        Shape shape1=shapeFactory.getShape("Circle");
        Shape shape2=shapeFactory.getShape("Rectangle");
        shape1.draw();
        shape2.draw();
        Factory.getShape("CIRCLE").draw();
        Factory.getShape("RECTANGLE").draw();
        Scanner scn= new Scanner(System.in);
        while(scn.hasNext()){
            String str=scn.next();
            System.out.println(str);
        }
        //Factory.getShape("SQUARE").draw();
    }
}
