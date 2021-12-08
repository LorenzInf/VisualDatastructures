package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.view.Animated;


public class StackBall extends GraphicalObject implements Animated {

    private VisualStack<StackBall> visualStack;

    public StackBall(int x, int y,int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(0,0,128,255);
        drawTool.drawFilledRectangle(x,y,width,height);
    }

    @Override
    public void update(double dt){}
}
