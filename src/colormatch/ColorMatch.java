package colormatch;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Miguel Dinis
 */
public class ColorMatch extends JFrame {

    public ColorMatch() {
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        
        setSize(360, 390);
        setUndecorated(true);
        setTitle("ColorMatch");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ColorMatch ex = new ColorMatch();
            ex.setVisible(true);
        });
    }
    
}
