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
    
    public Pion(int x, int y, Couleur color) {
        super(x, y, color);
        this.name = "Pion";
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        boolean whitePawn = (this.color == Couleur.BLANC && (this.x == xFinal + 1 || (this.x == 6 && xFinal == 4)));
        boolean blackPawn = (this.color == Couleur.NOIR && (this.x == xFinal - 1 || (this.x == 1 && xFinal == 3)));
        return super.isAlgoMoveOK(xFinal, yFinal) && this.y == yFinal && (whitePawn || blackPawn);
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
