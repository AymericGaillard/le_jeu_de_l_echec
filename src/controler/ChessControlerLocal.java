/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import javax.swing.JLayeredPane;
import model.ChessGameModel;
import tools.data.Coord;
import tools.data.Couleur;
import vue.ChessGridGUI;

/**
 *
 * @author theot
 */
public class ChessControlerLocal implements ChessGameControlerModelVue{

    private ChessGameModel chessGame;
    private ChessGridGUI chessGridGUI;
    
    public ChessControlerLocal(ChessGameModel chessGame) {
        this.chessGame = chessGame;
    }

    @Override
    public void setGridPanel(JLayeredPane panel) {
        this.chessGridGUI=(ChessGridGUI) panel;
    }

    @Override
    public boolean isPlayerOk(Couleur pieceToMoveCouleur) {
        return pieceToMoveCouleur == this.chessGame.getColorCurrentPlayer();
    }

    @Override
    public void setGridPanel(ChessGridGUI chessGridGUI) {
        this.chessGridGUI= chessGridGUI;
    }

    @Override
    public void actionsWhenPieceIsSelectedOnGUI(Coord pieceToMoveCoord, Couleur pieceToMoveCouleur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionsWhenPieceIsMovedOnGUI(Coord pieceToMoveCoord, Coord targetCoord) {
        chessGame.move(pieceToMoveCoord.getX(),pieceToMoveCoord.getY(),targetCoord.getX(),targetCoord.getY());
    }
    
}
