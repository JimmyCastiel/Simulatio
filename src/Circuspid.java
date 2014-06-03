
import Vue.MainWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 8460P
 */
public class Circuspid {
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() { 
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
        MainWindow window = MainWindow.getInstance();
        	}
		});
    }
}
