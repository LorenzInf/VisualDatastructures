package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import KAGO_framework.view.DrawTool;
import my_project.view.Animated;

import javax.swing.text.View;

public class VisualStack<T extends GraphicalObject & Animated> extends GraphicalObject{

    // private int direction; // 0 = up, 1 = right, 2 = down, 3 = left
    private Stack<T> stack;
    private ViewController viewController;
    private int counter;

    public VisualStack(ViewController viewController){
        counter = 0;
        stack = new Stack<>();
        this.viewController = viewController;
    }

    public void pushInVisual(T contentType) {
        /*if (contentType != null) {
            if (stack.isEmpty()) {
                contentType.setX(radius * 2 + 5);
                contentType.setY(radius * 2 + 30);
                stack.push(contentType);
            } else {
                contentType.setX(counter * (radius * 2 + 5));
                contentType.setY(radius * 2 + 30);
                stack.push(contentType);
            }
            viewController.draw(contentType);
        }
        counter++; */

        // Ich weiß nicht welche Version besser ist, also lasse ich beide
        if (contentType != null) {
            stack.push(contentType);
            contentType.setX(counter * (radius * 2 + 5));
            contentType.setY(radius * 2 + 30);
            viewController.draw(contentType);
            counter++;
        }
    }

    public void pop(){
        if(!stack.isEmpty()){
            viewController.removeDrawable(stack.top());
            stack.pop();
            counter--;
            // Alles bewegen
            Stack<T> temp = new Stack<>();
            while(!stack.isEmpty()){
                stack.top().setX(counter * (radius*2+5));
                temp.push(stack.top());
                stack.pop();
            }
            stack = temp;
        }
    }

}