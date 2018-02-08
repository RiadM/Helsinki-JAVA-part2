package movingfigure;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    private Component component;
    private Figure figure;

    public KeyboardListener(Component component, Figure figure) {
        this.component = component;
        this.figure = figure;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyC = e.getKeyCode();
        if(keyC == KeyEvent.VK_LEFT){
            this.figure.move(-1,0);
        }else if(keyC == KeyEvent.VK_RIGHT){
            this.figure.move(1,0);
        } else if(keyC == KeyEvent.VK_UP){
            this.figure.move(0,-1);
        }else if(keyC == KeyEvent.VK_DOWN){
            this.figure.move(0,1);
        }

        this.component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
