package game;

import gameoflife.GameOfLifeBoard;

import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard{


    private int width;
    private int height;

    public PersonalBoard(int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;
    }

    @Override
    public void turnToLiving(int x, int y) {
        if(x < this.width && y < this.height && x >= 0 && y >= 0){
            super.getBoard()[x][y] = true;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if(x < this.width && y < this.height && x >= 0 && y >= 0){
            super.getBoard()[x][y] = false;
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if(x < this.width && y < this.height && x >= 0 && y >= 0){
            return super.getBoard()[x][y];
        }else{
            return false;
        }
    }

    @Override
    public void initiateRandomCells(double v) {
        int totalMax = (int)(v * this.width * this.height);
        int number = 0;
        if(v > 0 && v < 1){
            while(number < totalMax){
                Random random = new Random();
                int x = random.nextInt(this.width - 1);
                int y = random.nextInt(this.height - 1);
                if(!isAlive(x,y)){
                    super.getBoard()[x][y] = true;
                    number++;
                }
            }
        }
        if(v == 1){
            for(int i = 0; i < this.width; i++){
                for(int j = 0; j < this.height; j++){
                    super.getBoard()[i][j] = true;
                }
            }
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int minX = 0;
        int maxX = this.width - 1;
        int minY = 0;
        int maxY = this.height - 1;

        if(x - 1 >= 0 ){
            minX = x-1;
        }
        if(x + 1 <= maxX){
            maxX = x + 1;
        }
        if(y - 1 >= 0){
            minY = y-1;
        }
        if(x + 1 <= maxX){
            maxY = y + 1;
        }
        int living = 0;

        for(int i = minX; i <= maxX; i++){
            for(int j = minY; j <= maxY; j++){
                if(isAlive(i,j)){
                    living++;
                }
            }
        }
        if(super.getBoard()[x][y]){
            return living - 1;
        }else{
            return living;
        }
    }

    @Override
    public void manageCell(int x, int y, int var3) {
        if(!isAlive(x,y)){
            if(var3 == 3){
                turnToLiving(x,y);
            }
        }else{
            if(var3 < 2 || var3 > 3){
                turnToDead(x,y);
            }
        }
    }
}
