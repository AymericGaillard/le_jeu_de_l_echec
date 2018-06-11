/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import tools.data.ChessPiecePos;
import tools.data.Coord;
import tools.factory.ChessImageProvider;

/**
 *
 * @author theot
 */
public class ChessGridGUI extends JLayeredPane implements ChessGameGUI {
    private int length=8;
    public ChessGridGUI() {
        this.setLayout(new GridLayout(length,length));
        setBackgroundChessBoard();
        setPieceChessBoard();
    }
    
    private void setBackgroundChessBoard(){
        ChessSquareGUI square = null;
        Map<Coord, ChessSquareGUI> map = new HashMap<Coord, ChessSquareGUI>();
        
        for (int i = 0; i<length; i++){
            for (int j = 0; j<length; j++) {
		if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)){
                    square = new ChessSquareGUI(new Color(139,69,0), new Coord(i,j));
		}
		else{
                    square = new ChessSquareGUI(new Color(255,250,240), new Coord(i,j));
		}

		// ajout du carre sur le damier
		this.add(square);
                map.put(square.getCoord(),square);
            }   
        }
    }
    
    private void setPieceChessBoard(){
        JPanel square;
        JLabel chessPieceGUI = null;
        int index;
        for (int i = 0; i < ChessPiecePos.values().length; i++) {
            for (int j = 0; j < (ChessPiecePos.values()[i].coords).length; j++) {
		// fabrication de l'image de la pièce
		chessPieceGUI = new ChessPieceGUI(
		ChessPiecePos.values()[i].couleur,
		ChessPiecePos.values()[i].nom,
		new ImageIcon(ChessImageProvider.getImageFile(
		ChessPiecePos.values()[i].nom, 
		ChessPiecePos.values()[i].couleur)));
		// ajout de l'image de piece sur le carre
                index = ChessPiecePos.values()[i].coords[j].getY() * 8 +
                ChessPiecePos.values()[i].coords[j].getX();
		square = (JPanel) this.getComponent(index);
		square.add(chessPieceGUI);
            }
        }
    }
  
    
    @Override
    public void addMouseListener(MouseListener mouseListener) {
        super.addMouseListener(mouseListener);
        //todo
    }

    @Override
    public void addMouseMotionListener(MouseMotionListener mouseMotionListener) {
        super.addMouseMotionListener(mouseMotionListener);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPieceToMove(Coord coord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resetLight(List<Coord> coords, boolean isLight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void movePiece(Coord targetCoord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undoMovePiece(Coord pieceToMoveInitCoord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPromotionType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void promotePiece(Coord coord, String promotionType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
