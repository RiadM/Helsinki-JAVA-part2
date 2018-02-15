package wormgame.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import wormgame.game.WormGame;

public class UserInterface implements Runnable {

    private JFrame frame;
    private WormGame game;
    private int sideLength;
    private DrawingBoard drawingBoard;

    public UserInterface(WormGame game, int sideLength) {
        this.game = game;
        this.sideLength = sideLength;
    }

    @Override
    public void run() {
        this.frame = new JFrame("Worm Game");
        int width = (this.game.getWidth() + 1) * this.sideLength + 10;
        int height = (this.game.getHeight() + 2) * this.sideLength + 10;

        this.frame.setPreferredSize(new Dimension(width, height));

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(this.frame.getContentPane());

        this.frame.pack();
        this.frame.setVisible(true);
    }

    public void createComponents(Container container) {
        // Create drawing board first which then is added into container-object.
        this.drawingBoard = new DrawingBoard(this.game,this.sideLength);
        container.add(this.drawingBoard);
        // After this, create keyboard listener which is added into frame-object
        KeyboardListener keyboardListener = new KeyboardListener(this.game.getWorm());
        this.frame.addKeyListener(keyboardListener);
    }

    public Updatable getUpdatable(){
       return this.drawingBoard;
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
