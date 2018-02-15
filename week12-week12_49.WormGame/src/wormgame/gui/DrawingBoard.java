package wormgame.gui;

import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.game.WormGame;

import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel implements Updatable{

    private WormGame wormGame;
    private int pieceLength;

    public DrawingBoard(WormGame wormGame, int pieceLength) {
        super.setBackground(Color.WHITE);
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Apple apple = this.wormGame.getApple();
        Worm worm   = this.wormGame.getWorm();

        for(Piece piece: worm.getPieces()){
            g.setColor(Color.BLACK);
            g.fill3DRect(piece.getX()*this.pieceLength,piece.getY()*this.pieceLength,this.pieceLength,this.pieceLength,true);
        }
        g.setColor(Color.RED);
        g.fillOval(apple.getX() * this.pieceLength,apple.getY() * this.pieceLength,this.pieceLength,this.pieceLength);
    }

    @Override
    public void update() {
        super.repaint();
    }
}
