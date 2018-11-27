/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colormatch;

import java.awt.Color;
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
        
        randomizeCurrentColor();
        randomizeColorPanel();
        
        startTime = System.currentTimeMillis();
    }
    
    public void click(JPanel clickedPanel) {
        elapsedTime = System.currentTimeMillis() - startTime;
        
        if (clickedPanel.getBackground() == currentColor) match(true);
        else match(false);
    }
    
    private void match(boolean matchColor) {
        if (matchColor) score = Math.round(10 / elapsedTime);
        
        // reset clock 
        startTime = 0;
        elapsedTime = 0;
        
        // change colors to random
        randomizeColorPanel();
        
        // change currentColor
        randomizeCurrentColor();
    }
    
    private void randomizeCurrentColor() {
        currentColor = pickRandomColor();
    }
    
    private void randomizeColorPanel() {
        for (int i = 0; i < p.length; i++) {
            p[i].setBackground(pickRandomColor());
        }
    }
    
    private Color pickRandomColor() {
        int randomNumber = (int) Math.random() * 6;
        
        Color randomColor;
        
        switch (randomNumber) {
            case 0:
                randomColor = Color.RED;
                break;
                
            case 1:
                randomColor = Color.YELLOW;
                break;
                
            case 2:
                randomColor = Color.GREEN;
                break;
            
            case 3:
                randomColor = Color.BLUE;
                break;
                
            case 4:
                randomColor = Color.PINK;
                break;
            
            case 5:
                randomColor = Color.CYAN;
                break;
            
            default:
                randomColor = Color.RED;
        }
        
        return randomColor;
    }
    
    public void closeGame() {
        System.exit(0);
    }
}
