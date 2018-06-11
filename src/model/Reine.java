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
public class Reine extends AbstractPiece {

    public Reine() {
        super();
        this.name = "Reine";
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        boolean horizontal = (this.x == xFinal && this.y != yFinal); 
        boolean vertical = (this.y == yFinal && this.x != xFinal);
        boolean diagonal = (abs(this.y - yFinal) == abs(this.x - xFinal));
        return horizontal || vertical || diagonal;
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
