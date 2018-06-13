/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.lang.Math.abs;
import static java.lang.Math.max;
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
public class Reine extends AbstractPiece {

    public Reine() {
        super();
        this.name = "Reine";
    }
    
    public Reine(int x, int y, Couleur color) {
        super(x, y, color);
        this.name = "Reine";
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        boolean horizontal = (this.x == xFinal && this.y != yFinal); 
        boolean vertical = (this.y == yFinal && this.x != xFinal);
        boolean diagonal = (abs(this.y - yFinal) == abs(this.x - xFinal));
        return super.isAlgoMoveOK(xFinal, yFinal) && (horizontal || vertical || diagonal);
    }
    
    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal, ActionType type) {
        return this.isAlgoMoveOK(xFinal, yFinal);
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        List<Coord> path = new ArrayList<>();
        
        if(this.y == yFinal) {
            for(int i=min(this.x, xFinal)+1; i<max(this.x, xFinal); i++) {
                path.add(new Coord(i, this.y));
            }
        } else if(this.x == xFinal) {
            for(int i=min(this.y, yFinal)+1; i<max(this.y, yFinal); i++) {
                path.add(new Coord(this.x, i));
            }
        } else {
            
            int j = this.y > yFinal ? 1 : -1;

            if(this.x < xFinal) {
                for(int i=1; i<xFinal-this.x; i++) {
                    path.add(new Coord(this.x+i, this.y-(j*i)));
                }
            } else {
                for(int i=1; i<this.x-xFinal; i++) {
                    path.add(new Coord(xFinal+i, yFinal+(j*i)));
                }
            }
            
        }
        for(Coord c : path)
            System.out.println(c);
        return path;
    }
    
}
