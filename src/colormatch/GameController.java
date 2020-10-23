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
    private float score = 0f;
    private Color currentColor;
    private JPanel matchingColorPanel;
    private JLabel scoreLabel;
    
    private long startTime = 0;
    private float elapsedTime = 0f;
    
    public GameController() {}
   
    /*
    * This constructor grabs a panel and starts randomizing the colors.
    */
    public GameController(JPanel p[], JPanel matchingColorPanel, JLabel scoreLabel) {
        this.p = p;
        this.matchingColorPanel = matchingColorPanel;
        this.scoreLabel = scoreLabel;
        
        randomizeCurrentColor();
        randomizeColorPanel();
        
        this.startTime = System.currentTimeMillis();
    }
    
    /*
    * This method handles the clicks.
    */
    public void click(JPanel clickedPanel, Color currentColor, boolean pass) {
        if (pass) match(false);
        else {
            this.elapsedTime = (float) (System.currentTimeMillis() - this.startTime) / 1000;
        
            if (clickedPanel.getBackground() == currentColor) match(true);
            else match(false);
        }
        
    }
    
    /*
    * This method checks if the color actually matches.
    */
    private void match(boolean matchColor) {
        
        if (matchColor) this.score += Math.round(10 / (elapsedTime) );
        
        this.scoreLabel.setText("Score: " + (int) this.score);
        
        // reset clock 
        this.startTime = System.currentTimeMillis();
        this.elapsedTime = 0;
        
        // change colors to random
        randomizeColorPanel();
        
        // change currentColor
        randomizeCurrentColor();
    }
    
    private void randomizeCurrentColor() {
        this.currentColor = pickRandomColor();
        this.matchingColorPanel.setBackground(pickRandomColor());
    }
    
    private void randomizeColorPanel() {
        for (JPanel p1 : p) {
            p1.setBackground(pickRandomColor());
        }
    }
    
    private Color pickRandomColor() {
        int randomNumber = (int) (Math.random() * 6);
        
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
