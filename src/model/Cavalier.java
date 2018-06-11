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
public class Cavalier extends AbstractPiece {

    public Cavalier() {
        super();
        this.name = "Cavalier";
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
