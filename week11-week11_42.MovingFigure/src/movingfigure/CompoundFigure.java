package movingfigure;

import java.awt.*;
import java.util.ArrayList;

public class CompoundFigure extends Figure {

    private ArrayList<Figure> figures;

    public CompoundFigure() {
        super(0,0);
        this.figures = new ArrayList();
    }

    public void add(Figure f){
        this.figures.add(f);
    }

    @Override
    public void move(int dx, int dy) {
        for(Figure figure: this.figures){
            figure.move(dx,dy);
        }
    }

    @Override
    public void draw(Graphics graphics) {
        for(Figure figure: this.figures){
            figure.draw(graphics);
        }
    }
}
