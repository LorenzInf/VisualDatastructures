package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.Stack;

public class VisualStack<T extends GraphicalObject & VisualStack.Animated> extends GraphicalObject{

    public interface Animated {

        void comeIn();
        void goOut();
    }

    private Stack<T> stack;
    private ViewController viewController;
    private int counter;

    public VisualStack(ViewController viewController){
        counter = 1;
        stack = new Stack<>();
        this.viewController = viewController;
    }

    /**
     * Die Methode pushInVisual() ist ziemlich ähnlich zu der Methode push() von der Datenstruktur Stack.
     * Es wird geprüft, ob das Objekt, welches hinzugefügt werden soll (@param contentType) null ist, wenn nicht, dann wird es:
     * in den Stack getan,
     * comeIn() aufgerufen,
     * x-Koordinate in abhängigkeit von counter gesetzt
     * gezeichnet + der counter um 1 erhöht,
     * Methode comeIn() aufgerufen, die optional was machen kann
     */
    public void pushInVisual(T contentType) {
        // Ich glaube das ist falsch, bin mir aber nicht sicher
        /*if (contentType != null) {
            stack.push(contentType);
            contentType.setX(counter * (contentType.getRadius()*2));
            contentType.setStartHeight(100);
            contentType.setY(contentType.getStartHeight());
            viewController.draw(contentType);
            counter++;
            contentType.comeIn();
        } */

        //PROBLEM: Ich will eigentlich counter in der comeIn Methode haben und das alles darüber machen, aber es funktioniert dann nie, weil der counter nicht erhöht wird.
        // Ich glaube das ist richtig, bin mir aber nicht sicher
        if (contentType != null) {
            stack.push(contentType);
            contentType.comeIn();
            contentType.setX(counter * (contentType.getRadius()*2));
            viewController.draw(contentType);
            counter++;
        }
    }

    /**
     * Die Methode popVisual ist ähnlich zu pop() in Stack.
     * Es wird erst geprüft, ob stack leer ist, wenn ja, dann passiert nichts, sonst:
     * wird goOut() aufgerufen
     * wird die "oberste" Zeichnung entfernt,
     * wird das oberste Objekt von Stack entfernt
     * und der counter -1 gerechnet
     */
    public void popVisual(){
        if(!stack.isEmpty()){
            stack.top().goOut();
            viewController.removeDrawable(stack.top());
            stack.pop();
            counter--;
        }
    }
}