/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import tools.BoardGameConfig;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

/**
 *
 * @author theot
 */
public class ChessModel implements ChessGameModel {

    private Couleur colorCurrentPlayer;
    private ChessImplementor chessImplementor;

    public ChessModel() {
        //todo
        this.colorCurrentPlayer = BoardGameConfig.getBeginColor();
        this.chessImplementor = new ChessImplementor();
    }
    
    @Override
    public Couleur getColorCurrentPlayer() {
        return colorCurrentPlayer;
    }

    @Override
    public Couleur getPieceColor(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Coord> getPieceListMoveOK(int xInit, int yInit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActionType move(int xInit, int yInit, int xFinal, int yFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean pawnPromotion(int x, int y, String promotionType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
