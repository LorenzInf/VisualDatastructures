package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import KAGO_framework.view.DrawTool;

public class VisualStack<T extends GraphicalObject & Animated> extends GraphicalObject{

    private int x;
    private int y;
    private boolean arrived;
    private boolean deleted;
    private int width;
    private int height;
    private int direction; // 0 = up, 1 = right, 2 = down, 3 = left
    private Stack<T> stack;
    private ViewController viewController;

    public VisualStack(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        arrived = false;
        deleted = false;
    }
}