/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import tools.data.Couleur;

/**
 *
 * @author theot
 */
public class ChessPieceGUI extends JLabel {
    private Couleur color;
    private ImageIcon image;
    private String nom;

    public ChessPieceGUI(Couleur color, String nom, ImageIcon image) {
        super(image);
        this.color = color;
        this.nom=nom;
        this.image = image;
    }

    public Couleur getColor() {
        return color;
    }
    
    
}
