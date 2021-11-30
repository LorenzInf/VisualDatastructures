package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.view.Animated;
import my_project.view.VisualStack;


public class StackRectangle extends GraphicalObject implements Animated {

    private int alpha;
    private VisualStack<StackRectangle> visualStack;

    public StackRectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        alpha = 0;
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(0,0,128,alpha);
        drawTool.drawFilledRectangle(x,y,width,height);
    }

    public void showPush(){
        visualStack.push(this);
    }

    public void pop(){
        visualStack.pop();
    }

    @Override
    public void update(double dt){

    }
}
