/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import tools.data.Couleur;

/**
 *
 * @author theot
 */
public class ChessImplementor implements ChessGameImplementor {
    
    private List<Pieces> whitePieces;
    private List<Pieces> blackPieces;
    
    public ChessImplementor() {
        this.whitePieces = new ArrayList<Pieces>();
        this.blackPieces = new ArrayList<Pieces>();
        this.whitePieces.add(new Tour(0, 0, Couleur.BLANC));
        this.whitePieces.add(new Cavalier(1, 0, Couleur.BLANC));
        this.whitePieces.add(new Fou(2, 0, Couleur.BLANC));
        this.whitePieces.add(new Reine(3, 0, Couleur.BLANC));
        this.whitePieces.add(new Roi(4, 0, Couleur.BLANC));
        this.whitePieces.add(new Fou(5, 0, Couleur.BLANC));
        this.whitePieces.add(new Cavalier(6, 0, Couleur.BLANC));
        this.whitePieces.add(new Tour(7, 0, Couleur.BLANC));
        this.whitePieces.add(new Pion(0, 1, Couleur.BLANC));
        this.whitePieces.add(new Pion(1, 1, Couleur.BLANC));
        this.whitePieces.add(new Pion(2, 1, Couleur.BLANC));
        this.whitePieces.add(new Pion(3, 1, Couleur.BLANC));
        this.whitePieces.add(new Pion(4, 1, Couleur.BLANC));
        this.whitePieces.add(new Pion(5, 1, Couleur.BLANC));
        this.whitePieces.add(new Pion(6, 1, Couleur.BLANC));
        this.whitePieces.add(new Pion(7, 1, Couleur.BLANC));
        this.blackPieces.add(new Tour(0, 7, Couleur.NOIR));
        this.blackPieces.add(new Cavalier(1, 7, Couleur.NOIR));
        this.blackPieces.add(new Fou(2, 7, Couleur.NOIR));
        this.blackPieces.add(new Reine(3, 7, Couleur.NOIR));
        this.blackPieces.add(new Roi(4, 7, Couleur.NOIR));
        this.blackPieces.add(new Fou(5, 7, Couleur.NOIR));
        this.blackPieces.add(new Cavalier(6, 7, Couleur.NOIR));
        this.blackPieces.add(new Tour(7, 7, Couleur.NOIR));
        this.blackPieces.add(new Pion(0, 6, Couleur.NOIR));
        this.blackPieces.add(new Pion(1, 6, Couleur.NOIR));
        this.blackPieces.add(new Pion(2, 6, Couleur.NOIR));
        this.blackPieces.add(new Pion(3, 6, Couleur.NOIR));
        this.blackPieces.add(new Pion(4, 6, Couleur.NOIR));
        this.blackPieces.add(new Pion(5, 6, Couleur.NOIR));
        this.blackPieces.add(new Pion(6, 6, Couleur.NOIR));
        this.blackPieces.add(new Pion(7, 6, Couleur.NOIR));
    }

    @Override
    public String toString() {
        String whitePiecesString = "";
        String blackPiecesString = "";
        
        for(Pieces whitePiece : this.whitePieces) {
            whitePiecesString += whitePiece.toString() + "\n";
        }
        for(Pieces blackPiece : this.blackPieces) {
            blackPiecesString += blackPiece.toString() + "\n";
        }
        
        return "ChessImplementor{" + "whitePieces=list<Pieces>\n" + whitePiecesString + ", blackPieces=list<Pieces>\n" + blackPiecesString + '}';
    }
    
    public static void main(String[] args) {
        ChessImplementor ci = new ChessImplementor();
        System.out.println(ci.toString());
    }
    
}
