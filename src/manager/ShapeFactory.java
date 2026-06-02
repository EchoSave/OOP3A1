package manager; 
import shapes.*;
import utilities.Shape;

public class ShapeFactory {
    public static Shape createShape(String type, double height, double sideOrRadius) {
        switch (type.toLowerCase()) {
            case "cone": return new Cone(height, sideOrRadius);
            case "cylinder": return new Cylinder(height, sideOrRadius);
            case "pyramid": return new Pyramid(height, sideOrRadius);
            case "octagonalprism": return new OctagonalPrism(height, sideOrRadius);
            case "pentagonalprism": return new PentagonalPrism(height, sideOrRadius);
            case "triangularprism": return new TriangularPrism(height, sideOrRadius);
            case "squareprism": return new SquarePrism(height, sideOrRadius);
            default: throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }
}