package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Shape;

public class ShapeList extends ArrayList<Shape> {

    // formal term: model view controller --> model info of data in this code, then
    // in ShapePane have the view
    // controller is the one that controls the view and model

    private Random random = new Random();
    private int width;
    private int height;

    // can also have user set size of window, can have attributes that update for
    // this
    // constructor:
    public ShapeList(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    // getters and setters
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // methods:

    // method to generate a random color
    public Color randomColor() {
        // create a random color
        return new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(),
                random.nextDouble() * 0.7 + 0.3);
        // rand 0.0-1.0
        // red, green, bed, and alpha, 4th one is transparency/opacity
        // 0.0 = invisible, 0.1 = barely visible, 1.0 = fully visible

    }

    // generate some shapes
    public void generateShapes(int numShapes) { // param int numShapes because slider will control this
        this.clear(); // clear the list before adding new shapes
        // generate a random shape
        // loop to create the specified number of shapes of different types

        for (int i = 0; i < numShapes; i++) {
            // randomly choose a shape type
            int shapeType = random.nextInt(3); // 0, 1, or 2 for circle, rectangle, or triangle
            Shape shape = null;
            Color color = randomColor();

            // select what shape to create based on the random shapeType
            switch (shapeType) {
                case 0: // circle
                    double radius = random.nextDouble() * Math.min(width, height) / 10; // random radius
                    double centerX = random.nextDouble() * (width - radius * 2) + radius; // random center x
                    double centerY = random.nextDouble() * (height - radius * 2) + radius; // random center y
                    shape = new javafx.scene.shape.Circle(centerX, centerY, radius);
                    break;
                case 1: // rectangle
                    double rectWidth = random.nextDouble() * (width / 5); // random width
                    double rectHeight = random.nextDouble() * (height / 5); // random height
                    double rectX = random.nextDouble() * (width - rectWidth); // random x
                    double rectY = random.nextDouble() * (height - rectHeight); // random y
                    shape = new javafx.scene.shape.Rectangle(rectX, rectY, rectWidth, rectHeight);
                    break;
                case 2: // triangle
                    double x1 = random.nextDouble() * width;
                    double y1 = random.nextDouble() * height;
                    double x2 = random.nextDouble() * width;
                    double y2 = random.nextDouble() * height;
                    double x3 = random.nextDouble() * width;
                    double y3 = random.nextDouble() * height;
                    shape = new javafx.scene.shape.Polygon(x1, y1, x2, y2, x3, y3);
                    break;
            }

            if (shape != null) {
                shape.setFill(color);
                shape.setStroke(Color.BLACK); // set stroke color to black
                shape.setStrokeWidth(2); // set stroke width
                this.add(shape); // add the shape to the list
            }
        }
    }
}