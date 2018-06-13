/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import java.util.ArrayList;
import java.util.List;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

/**
 *
 * @author Aymeric
 */
public class Fou extends AbstractPiece {

    public Fou() {
        super();
        this.name = "Fou";
    }
    
    public Fou(int x, int y, Couleur color) {
        super(x, y, color);
        this.name = "Fou";
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        return super.isAlgoMoveOK(xFinal, yFinal) && (abs(this.y - yFinal) == abs(this.x - xFinal));
    }
    
    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal, ActionType type) {
        return this.isAlgoMoveOK(xFinal, yFinal);
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        List<Coord> path = new ArrayList<>();
        
        if(min(this.x, xFinal)==this.x) {
            for(int i=1; i<abs(this.x-xFinal); i++) {
                path.add(new Coord(this.x+i, this.y+i));
            }
        } else {
            for(int i=1; i<abs(this.x-xFinal); i++) {
                path.add(new Coord(xFinal+i, yFinal+i));
            }
        }
        
        
        return path;
    }
    
}
