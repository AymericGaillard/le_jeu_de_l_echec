/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import tools.data.Coord;

/**
 *
 * @author theot
 */
public class ChessSquareGUI extends JPanel{
    private Color color;
    private Coord coord;
    
    public ChessSquareGUI(Color color, Coord coord){
        this.setBackground(color);
        this.color=color;
        this.coord=coord;
    }

    public Coord getCoord() {
        return coord;
    }
    
   

}
