/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.lang.Math.abs;
import java.util.List;
import tools.data.Coord;
import tools.data.Couleur;

/**
 *
 * @author Aymeric
 */
public class Roi extends AbstractPiece {

    public Roi() {
        super();
        this.name = "Roi";
    }
    
    public Roi(int x, int y, Couleur color) {
        super(x, y, color);
        this.name = "Roi";
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        return super.isAlgoMoveOK(xFinal, yFinal) && (abs(this.x - xFinal) <= 1 && abs(this.y - yFinal) <= 1 && (this.x != xFinal || this.y != yFinal));
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
