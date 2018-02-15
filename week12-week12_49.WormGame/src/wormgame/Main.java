package wormgame;

import javax.swing.SwingUtilities;

import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.UserInterface;
import wormgame.game.WormGame;

public class Main {

    public static void main(String[] args) {
        // write test code here
        Worm m = new Worm(5, 5, Direction.UP);

        m.move(); m.move(); m.grow(); m.move(); m.move();

        m.setDirection(Direction.RIGHT);

        m.grow(); m.move(); m.move();

        m.setDirection(Direction.DOWN);

        m.grow(); m.move(); m.grow(); m.move(); m.move();

        m.getPieces() ;

        System.out.println(m.runsInto(new Piece(5,3)));
    }
}
