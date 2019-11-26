public class ShapeFactory {
    public Shape getShape(String shapetype){
        switch(shapetype){
            case "Circle":
                return new Circle();
            case "Rectangle" :
                return new Rectangle();
        }
        return null;
    }
}
