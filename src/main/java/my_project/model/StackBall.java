package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;


public class StackBall extends GraphicalObject implements VisualStack.Animated {

    private boolean arrived;
    private int startHeight;


    public StackBall(int radius){
        this.radius = radius;
        arrived = false;
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(0,0,128,255);
        drawTool.drawFilledCircle(x,y,radius);
    }

    @Override
    public void update(double dt){
        if(!arrived){
            y = y + 50*dt;
            if(y >= 250){
                arrived = true;
            }
        }
    }

    public void comeIn(){
        //Ball entscheidet wie er rein kommt, aber comeIn in VisualStack

    }

    public int getStartHeight() {
        return startHeight;
    }

    public void setStartHeight(int startHeight){
        this.startHeight = startHeight;
    }
}
