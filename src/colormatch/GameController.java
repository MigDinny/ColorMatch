/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colormatch;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Miguel Dinis
 */
public class GameController {
   
    private final JPanel p[];
    private int score = 0;
    private Color currentColor;
    private JPanel matchingColorPanel;
    private JLabel scoreLabel;
    
    private long startTime = 0;
    private long elapsedTime = 0;
    
    public GameController(JPanel p[], JPanel matchingColorPanel, JLabel scoreLabel) {
        this.p = p;
        this.matchingColorPanel = matchingColorPanel;
        this.scoreLabel = scoreLabel;
        
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
        if (matchColor) score += Math.round(10 / elapsedTime);
        
        scoreLabel.setText("Score: " + score);
        
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
        matchingColorPanel.setBackground(pickRandomColor());
    }
    
    private void randomizeColorPanel() {
        for (int i = 0; i < p.length; i++) {
            p[i].setBackground(pickRandomColor());
        }
    }
    
    private Color pickRandomColor() {
        int randomNumber = (int) (Math.random() * 6);
        
        System.out.println(randomNumber);
        
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
                // pink
                randomColor = new Color(255, 0, 153);
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
