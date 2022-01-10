package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import my_project.control.ProgramController;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputManager extends InteractiveGraphicalObject {

    private ProgramController programController;
    private ViewController viewController;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManager(ProgramController programController, ViewController viewController){
        this.programController = programController;
        this.viewController = viewController;
        viewController.register(this);
    }

    public void keyReleased(int key){

        if (key == KeyEvent.VK_SPACE) programController.addRectangle();
        if (key == KeyEvent.VK_BACK_SPACE) programController.deleteRectangle();

        /*
        if (key == KeyEvent.VK_SPACE) programController.addBallToVisual();
        if (key == KeyEvent.VK_BACK_SPACE) programController.deleteBallFromVisual();
*/

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

}
