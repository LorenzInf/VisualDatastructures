package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Bar extends GraphicalObject implements VisualStack.Animated{

    private int r,g,b;

    public Bar(double width) {
        this.x = x;
        this.width = width;
        this.r = 255;
        this.g = 0;
        this.b = 0;

    }

    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(r,g,b,255);
        drawTool.drawFilledRectangle(x,y,width,20);
    }

    public void update(double dt){

    }

    public void comeIn(){
        y = 100;
        if(x >= 200){
            r = (int) (Math.random()*255);
            g = (int) (Math.random()*255);
            b = (int) (Math.random()*255);
        }
    }

    public void goOut(){

    }

    public void setG(int g){
        this.g = g;
    }

    public int getG(){
        return g;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
