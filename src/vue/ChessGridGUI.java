/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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
import tools.data.Couleur;
import tools.factory.ChessImageProvider;

/**
 *
 * @author theot
 */
public class ChessGridGUI extends JLayeredPane implements ChessGameGUI {
    private int length=8;
    Map map;
    private ChessPieceGUI chessPiece;
    public ChessGridGUI() {
        this.setLayout(new GridLayout(length,length));
        setBackgroundChessBoard();
        setPieceChessBoard();
    }
    
    /**
     * Remplis l'échiquier de cases blanches et noires
     */
    private void setBackgroundChessBoard(){
        ChessSquareGUI square = null;
        map = new HashMap<Coord, ChessSquareGUI>();
        
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
    
    /**
     * Ajoute les pièces à l'échiquier
     */
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
    
    /**
     * Récupère les coordonnées de la case
     * @param x
     * @param y
     * @return 
     */
   public Coord getSquareCoord(int x, int y){
       Component c = this.findComponentAt(x,y);
       ChessSquareGUI square;
       if(c.getClass()==ChessPieceGUI.class){
           square = (ChessSquareGUI) c.getParent();
       }
       else{
           square = (ChessSquareGUI) c;
       }
       return square.getCoord();
   }
   
   /**
    * Récupère la couleur de la pièce
    * @param coord
    * @return 
    */
   public Couleur getPieceColor(Coord coord){
        ChessSquareGUI square = (ChessSquareGUI) map.get(coord);
        if(square.getComponents().length!=0){
            ChessPieceGUI piece = (ChessPieceGUI) square.getComponent(0);
            return piece.getColor();
        }
        return null;
   }
  
    
//    @Override
//    public void addMouseListener(MouseListener mouseListener) {
//        super.addMouseListener(mouseListener);
//        //todo
//    }
//
//    @Override
//    public void addMouseMotionListener(MouseMotionListener mouseMotionListener) {
//        super.addMouseMotionListener(mouseMotionListener);
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void setPieceToMove(Coord coord) {
        ChessSquareGUI square = (ChessSquareGUI) map.get(coord);
        chessPiece = (ChessPieceGUI) square.getComponent(0);
    }

    @Override
    public void resetLight(List<Coord> coords, boolean isLight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void movePiece(Coord targetCoord) {
        ChessSquareGUI square = (ChessSquareGUI) map.get(targetCoord);
        if (square.getComponents().length!=0){
            square.remove(0);
            square.add(chessPiece);
        }
        else{
            square.add(chessPiece);
        }
    }

    @Override
    public void undoMovePiece(Coord pieceToMoveInitCoord) {
        ChessSquareGUI square = (ChessSquareGUI) map.get(pieceToMoveInitCoord);
        if (square.getComponents().length!=0){
            square.remove(0);
            square.add(chessPiece);
        }
        else{
            square.add(chessPiece);
        }
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
