package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;

    private Worm worm;
    private Apple apple;
    private Random random;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;

        this.worm = new Worm((width/2), (height/2), Direction.DOWN);

        this.random = new Random();
        Apple newApple = new Apple(random.nextInt(width), random.nextInt(height));
        while(this.worm.runsInto(newApple)){
            newApple = new Apple(random.nextInt(width), random.nextInt(height));
        }
        this.apple = newApple;

        addActionListener(this);
        setInitialDelay(2000);
    }


    public boolean continues() {
        return this.continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Worm getWorm(){
        return this.worm;
    }

    public void setWorm(Worm worm){
        this.worm = worm;
    }

    public Apple getApple(){
        return this.apple;
    }

    public void setApple(Apple apple){
        this.apple = apple;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }

        this.worm.move();

        Piece wormHead = this.worm.getPieces().get(this.worm.getLength() - 1);

        if(this.worm.runsInto(this.apple)){
            Apple newApple = this.apple;
            while(this.worm.runsInto(newApple)){
                newApple = new Apple(random.nextInt(width), random.nextInt(height));
            }
            this.worm.grow();
            this.apple = newApple;
        }
        else if(wormHead.getX() < 0  || wormHead.getX() == this.width ){
            this.continues = false;
        }
        else if(wormHead.getY() < 0  || wormHead.getY() == this.height){
            this.continues = false;
        }
        else if(this.worm.runsIntoItself()){
            this.continues = false;
        }

        updatable.update();
        setDelay(1000 / this.worm.getLength());

    }

}
