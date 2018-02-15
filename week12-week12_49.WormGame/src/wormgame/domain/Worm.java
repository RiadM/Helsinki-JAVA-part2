package wormgame.domain;

import wormgame.Direction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Worm {

    private int x;
    private int y;
    private Direction direction;

    private List<Piece> pieces;
    private int length;
    private boolean grow;

    public Worm(int x, int y, Direction originalDirection) {
        this.x = x;
        this.y = y;
        this.direction = originalDirection;

        this.length = 3;

        this.pieces = new ArrayList();
        this.pieces.add(new Piece(this.x,this.y));
        this.grow = false;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction dir){
        this.direction = dir;
    }

    public int getLength(){
        return this.pieces.size();
    }

    public List<Piece> getPieces(){
        return this.pieces;
    }

    public void move(){
        if(this.direction == Direction.UP){
            this.y -= 1;
        }
        else if(this.direction == Direction.DOWN){
            this.y += 1;
        }
        else if(this.direction == Direction.RIGHT){
            this.x += 1;
        }
        else if(this.direction == Direction.LEFT){
            this.x -= 1;
        }

        if(this.pieces.size() > 2 && !grow) {
            this.pieces.remove(0);
        }

        if(grow == true){
            grow = false;
        }

        this.pieces.add(new Piece(this.x, this.y));
    }

    public void grow(){
        this.grow = true;
    }

    public boolean runsInto(Piece piece){
        for(Piece firstPiece: this.pieces){
            if(piece.getX() == firstPiece.getX() && piece.getY() == firstPiece.getY()){
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself(){
        Set<Piece> swap = new HashSet();
        swap.addAll(this.pieces);

        if(swap.size() < this.pieces.size()){
            return true;
        }else{
            return false;
        }
    }
}
