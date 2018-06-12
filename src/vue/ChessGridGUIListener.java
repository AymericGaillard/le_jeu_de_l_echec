/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.ChessGameControlerModelVue;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import tools.data.Coord;
import tools.data.Couleur;

/**
 *
 * @author theot
 */
public class ChessGridGUIListener implements MouseListener,MouseMotionListener{
    private ChessGridGUI chessGridGUI;
    private ChessGameControlerModelVue chessGameControler;
    private JLabel chessPiece;
    private int xAdjustment;
    private int yAdjustment;
    private int xOld;
    private int yOld;
    private Coord coord;
    
    public ChessGridGUIListener(ChessGridGUI chessGridGUI, ChessGameControlerModelVue chessGameControler) {
        this.chessGridGUI=chessGridGUI;
        this.chessGameControler = chessGameControler;
    }    

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        chessPiece = null;
        Component c =  chessGridGUI.findComponentAt(e.getX(), e.getY());
        
        this.coord = chessGridGUI.getSquareCoord(e.getX(),e.getY());
        Couleur color = chessGridGUI.getPieceColor(coord);
        
        chessGameControler.actionsWhenPieceIsSelectedOnGUI(coord, color);
        
        if(chessGameControler.isPlayerOk(color)&& !(c instanceof JPanel)){
            Point parentLocation = c.getParent().getLocation();
            xAdjustment = parentLocation.x - e.getX();
            yAdjustment = parentLocation.y - e.getY();
            chessPiece = (JLabel)c;
            chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
            chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
            chessGridGUI.add(chessPiece, JLayeredPane.DRAG_LAYER);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(chessPiece == null) return;
        chessPiece.setVisible(false);
        
        Coord coord = chessGridGUI.getSquareCoord(e.getX(),e.getY());
        
        chessGameControler.actionsWhenPieceIsMovedOnGUI(this.coord, coord);
        
        chessPiece.setVisible(true);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (chessPiece != null)
            chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}
