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
        Coord coord = chessGridGUI.getSquareCoord(e.getX(),e.getY());
        Couleur color = chessGridGUI.getSquareColor(coord);
        if(!chessGameControler.isPlayerOk(color)){
            return;
        }
        else{
            if (c instanceof JPanel) 
            return;

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
        Component c =  chessGridGUI.findComponentAt(e.getX(), e.getY());

        if (c instanceof JLabel){
            Container parent = c.getParent();
            parent.remove(0);
            parent.add( chessPiece );
        }
        else {
            Container parent = (Container)c;
            parent.add(chessPiece);
        }

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
        if (chessPiece == null) return;
        chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}
