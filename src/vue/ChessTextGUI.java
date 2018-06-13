/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.TextArea;

/**
 *
 * @author theot
 */
public class ChessTextGUI extends TextArea {

    public ChessTextGUI() {
        
    }

    public ChessTextGUI(int hgap, int vgap) {
        super(hgap, vgap);
    }
    
    public void append(String string) {
        super.append(string);
    }
    
}
