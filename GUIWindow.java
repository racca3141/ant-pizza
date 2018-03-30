import javax.swing.*;
import java.awt.*;

public class GUIWindow{

	public static void main(String[] args){
   		JFrame theGUI = new JFrame();
		theGUI.setTitle("Superman Disassembly");
		theGUI.setSize(500, 300);
		ColorPanel panel = new ColorPanel(Color.yellow);
		Container pane = theGUI.getContentPane();
   		pane.add(panel);
   		theGUI.setVisible(true);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	}

}