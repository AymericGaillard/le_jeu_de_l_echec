/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

/**
 *
 * @author Aymeric
 */
public class Cavalier extends AbstractPiece {

    public Cavalier() {
        super();
        this.name = "Cavalier";
    }
    
    public Cavalier(int x, int y, Couleur color) {
        super(x, y, color);
        this.name = "Cavalier";
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        boolean horizontal = (abs(this.x-xFinal) == 1 && abs(this.y-yFinal) == 2);
        boolean vertical = (abs(this.x-xFinal) == 2 && abs(this.y-yFinal) == 1);
        return super.isAlgoMoveOK(xFinal, yFinal) && (horizontal || vertical);
    }
    
    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal, ActionType type) {
        return this.isAlgoMoveOK(xFinal, yFinal);
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        return new ArrayList<>();
    }
    
}
