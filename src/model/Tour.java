/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import tools.data.Coord;

/**
 *
 * @author Aymeric
 */
public class Tour extends AbstractPiece {

    public Tour() {
        super();
        this.name = "Tour";
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
