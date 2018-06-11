/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.lang.Math.abs;
import java.util.List;
import tools.data.Coord;

/**
 *
 * @author Aymeric
 */
public class Fou extends AbstractPiece {

    public Fou() {
        super();
        this.name = "Fou";
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        return(abs(this.y - yFinal) == abs(this.x - xFinal));
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
