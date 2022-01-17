package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import my_project.model.Bar;
import my_project.model.BarField;
import my_project.model.StackBall;
import my_project.model.VisualStack;
import my_project.view.InputManager;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private VisualStack<StackBall> ballStack;
    private VisualStack<Bar> pointBarStack;
    private BarField field;
    private Bar barOrig;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
        ballStack = new VisualStack<>(viewController);
        pointBarStack = new VisualStack<>(viewController);
        new InputManager(this,viewController);
        barOrig = new Bar(20,255,0,0);
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        BarField field = new BarField(viewController);

    }

    public void addRectangle(){
        if(pointBarStack.getCounter() == 11){
            pointBarStack.setCounter(1);
            barOrig.setR((int) (Math.random()*255));
            barOrig.setG((int) (Math.random()*255));
            barOrig.setB((int) (Math.random()*255));
            Bar newRec = new Bar(20,255,0,0);
            newRec.setR(barOrig.getR());
            newRec.setG(barOrig.getG());
            newRec.setB(barOrig.getB());
            pointBarStack.pushInVisual(newRec);
        }else{
            Bar newRec = new Bar(20,255,0,0);
            newRec.setR(barOrig.getR());
            newRec.setG(barOrig.getG());
            newRec.setB(barOrig.getB());
            pointBarStack.pushInVisual(newRec);
        }
    }

    public void deleteRectangle(){
        pointBarStack.popVisual();
    }


   /* public void addBallToVisual(){
        StackBall newBall = new StackBall(20);
        ballStack.pushInVisual(newBall);


    }

    public void deleteBallFromVisual(){
        ballStack.popVisual();
    }
    */



    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){

    }
}
