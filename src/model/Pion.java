/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import tools.data.Coord;
import tools.data.Couleur;

/**
 *
 * @author Aymeric
 */
public class Pion extends AbstractPiece {

    public Pion() {
        super();
        this.name = "Pion";
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        if (this.color == Couleur.BLANC && (this.y != yFinal + 1 || (this.y == 1 && this.y != yFinal + 2)))
            return false;
        if (this.color == Couleur.NOIR && (this.y != yFinal - 1 || (this.y == 6 && this.y != yFinal - 2)))
            return false;
        return super.isAlgoMoveOK(xFinal, yFinal);
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
