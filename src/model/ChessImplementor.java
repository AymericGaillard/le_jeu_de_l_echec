/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import tools.data.Couleur;

/**
 *
 * @author theot
 */
public class ChessImplementor implements ChessGameImplementor {
    
    private List<Pieces> whitePieces;
    private List<Pieces> blackPieces;

    public List<Pieces> getWhitePieces() {
        return whitePieces;
    }

    public List<Pieces> getBlackPieces() {
        return blackPieces;
    }
    
    public ChessImplementor() {
        this.whitePieces = new ArrayList<Pieces>();
        this.blackPieces = new ArrayList<Pieces>();
        this.whitePieces.add(new Tour(7, 0, Couleur.BLANC));
        this.whitePieces.add(new Cavalier(7, 1, Couleur.BLANC));
        this.whitePieces.add(new Fou(7, 2, Couleur.BLANC));
        this.whitePieces.add(new Reine(7, 3, Couleur.BLANC));
        this.whitePieces.add(new Roi(7, 4, Couleur.BLANC));
        this.whitePieces.add(new Fou(7, 5, Couleur.BLANC));
        this.whitePieces.add(new Cavalier(7, 6, Couleur.BLANC));
        this.whitePieces.add(new Tour(7, 7, Couleur.BLANC));
        this.whitePieces.add(new Pion(6, 0, Couleur.BLANC));
        this.whitePieces.add(new Pion(6, 1, Couleur.BLANC));
        this.whitePieces.add(new Pion(6, 2, Couleur.BLANC));
        this.whitePieces.add(new Pion(6, 3, Couleur.BLANC));
        this.whitePieces.add(new Pion(6, 4, Couleur.BLANC));
        this.whitePieces.add(new Pion(6, 5, Couleur.BLANC));
        this.whitePieces.add(new Pion(6, 6, Couleur.BLANC));
        this.whitePieces.add(new Pion(6, 7, Couleur.BLANC));
        this.blackPieces.add(new Tour(0, 0, Couleur.NOIR));
        this.blackPieces.add(new Cavalier(0, 1, Couleur.NOIR));
        this.blackPieces.add(new Fou(0, 2, Couleur.NOIR));
        this.blackPieces.add(new Roi(0, 3, Couleur.NOIR));
        this.blackPieces.add(new Reine(0, 4, Couleur.NOIR));
        this.blackPieces.add(new Fou(0, 5, Couleur.NOIR));
        this.blackPieces.add(new Cavalier(0, 6, Couleur.NOIR));
        this.blackPieces.add(new Tour(0, 7, Couleur.NOIR));
        this.blackPieces.add(new Pion(1, 0, Couleur.NOIR));
        this.blackPieces.add(new Pion(1, 1, Couleur.NOIR));
        this.blackPieces.add(new Pion(1, 2, Couleur.NOIR));
        this.blackPieces.add(new Pion(1, 3, Couleur.NOIR));
        this.blackPieces.add(new Pion(1, 4, Couleur.NOIR));
        this.blackPieces.add(new Pion(1, 5, Couleur.NOIR));
        this.blackPieces.add(new Pion(1, 6, Couleur.NOIR));
        this.blackPieces.add(new Pion(1, 7, Couleur.NOIR));
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
    
    public Pieces getPiece(int x, int y) {
        
        /* list of all Pieces that are foud to be at (xInit, yInit) */
        List<Pieces> pickedPieces = new ArrayList<>();
        
        Stream<Pieces> sl = (this.getWhitePieces()
                .stream()
                .filter(p -> (p.getX()==x && p.getY()==y)));
        
        pickedPieces.addAll(sl.collect(Collectors.toList()));
        
        sl = (this.getBlackPieces()
                .stream()
                .filter(p -> (p.getX()==x && p.getY()==y)));
        
        pickedPieces.addAll(sl.collect(Collectors.toList()));
        
        if(pickedPieces.size() != 1) {
            return null;
        }
        
        return pickedPieces.get(0);
    }
    
}
