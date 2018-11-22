/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colormatch;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Miguel Dinis
 */
public class GameController {
   
    private final JPanel p[];
    private int score = 0;
    private Color currentColor;
    
    private long startTime = 0;
    private long elapsedTime = 0;
    
    public GameController(JPanel p[]) {
        this.p = p;
        
        setRandomColor();
        
        startTime = System.currentTimeMillis();
    }
    
    public void click(JPanel clickedPanel) {
        elapsedTime = System.currentTimeMillis() - startTime;
        
        if (clickedPanel.getBackground() == currentColor) match(true);
        else match(false);
    }
    
    private void match(boolean matchColor) {
        if (matchColor) score = 10 / elapsedTime;
    }
    
    private void setRandomColor() {
        currentColor = Color.BLACK;
    }

    
    public void closeGame() {
        System.exit(0);
    }
}
