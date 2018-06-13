/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

/**
 *
 * @author Aymeric
 */
public abstract class AbstractPiece implements Pieces {

    protected int x;
    protected int y;
    protected Couleur color;
    protected String name;
    
    public AbstractPiece() {
    }
    
    public AbstractPiece(int x, int y, Couleur color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    @Override
    public int getX() {
        if(this.x < 8 && this.x >= -1)
            return x;
        else
            throw new IllegalStateException("x not between 0 and 7");
    }

    @Override
    public int getY() {
        if(this.y < 8 && this.y >= -1) {
            return y;
        }else {
            throw new IllegalStateException("y not between 0 and 7");
        }
    }

    @Override
    public Couleur getCouleur() {
        return this.color;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ActionType doMove(int xFinal, int yFinal) {
        this.x = xFinal;
        this.y = yFinal;
        System.out.println(this.x);
        System.out.println(this.y);
        return ActionType.MOVE;
    }

    @Override
    public boolean catchPiece() {
        if(this.getX() == -1 && this.getY() == -1) {
            return false; /* if already caught, can't be caught again */
        } else {
            this.x = this.y = -1;
            return true;
        }
    }

    public boolean isAlgoMoveOK(int xFinal, int yFinal) {
        return (this.x>=0 && this.x<8 && this.y>=0 && this.y<8 && xFinal>=0 && xFinal<8 && yFinal>=0 && yFinal<8);
    }
    
    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal, ActionType type) {
        return (this.x>=0 && this.x<8 && this.y>=0 && this.y<8 && xFinal>=0 && xFinal<8 && yFinal>=0 && yFinal<8);
    }

    @Override
    public boolean undoLastMove() {
        throw new UnsupportedOperationException("Not supported yet."); //need historic
    }

    @Override
    public boolean undoLastCatch() {
        throw new UnsupportedOperationException("Not supported yet."); //need historic
    }

    @Override
    public boolean samePlayer(Pieces p) {
        AbstractPiece ap = (AbstractPiece) p;
        return this.color == ap.color;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "{" + "x=" + x + ", y=" + y + ", color=" + color + ", name=" + name + '}';
    }
}
