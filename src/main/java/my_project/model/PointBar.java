package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import javax.swing.text.View;
import java.awt.*;

public class PointBar extends GraphicalObject implements VisualStack.Animated {

    private static class PointCounter extends GraphicalObject implements VisualStack.Animated{

        private int r, g, b;
        private double rectangleX;
        private int counter;

        public PointCounter(){
            this.r = 255;
            this.g = 122;
            this.b = 0;
            rectangleX = x;

        }

        public void draw(DrawTool drawTool){
            drawTool.setCurrentColor(r, g, b, 255);
            drawTool.drawFilledRectangle(rectangleX, y, width, height);
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getG() {
            return g;
        }

        public void setG(int g) {
            this.g = g;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public double getRectangleX() {
            return rectangleX;
        }

        public void setRectangleX(double rectangleX) {
            this.rectangleX = rectangleX;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }

        public void comeIn(){

        }

        public void goOut(){

        }
    }

    private int startX;
    private PointCounter pC;
    private VisualStack<PointCounter> pCVisualStack;
    private ViewController viewController;

    private boolean full; //zeigt an ob die Leiste voll ist

    public PointBar(double x, double y, double width, double height, int startX, ViewController viewController) {
        this.startX = startX;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        full = false;
        pC = new PointCounter();
        this.viewController = viewController;
        pCVisualStack = new VisualStack<PointCounter>(viewController);
    }

    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(Color.BLACK);
        drawTool.drawRectangle(x, y, width * 10, height);
    }

    public void update(double dt) {
        //TODO Farbe ändern wenn die Leiste voll ist, damit man sieht dass man mehr Punkte hat
        if (pC.getRectangleX() >= x + pC.getCounter()*width) { // Bewegung wenn die Leiste nicht voll ist
            pC.rectangleX = pC.rectangleX + 20 * dt;
            if (pC.getRectangleX() >= width * 10) { // Gucken ob das letzte Rechteck das Ende erreicht hat, wenn ja dann full = true;
                pC.setRectangleX(startX);
                pC.setR((int) (Math.random()* 255+0));
                pC.setB((int) (Math.random()* 255+0));
                pC.setG((int) (Math.random()* 255+0));
                full = true;
            }
        }
    }

    @Override
    public void comeIn() {
        /*pC.setCounter(pC.getCounter()+1);
        setX(pC.getCounter()* width);
        setY(y);
        System.out.println(pC.getCounter()); */
        PointCounter newCounter = new PointCounter();
        pCVisualStack.pushInVisual(newCounter);
        System.out.println(pC.getCounter());
    }

    @Override
    public void goOut() {

    }
}
