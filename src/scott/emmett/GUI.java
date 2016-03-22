package scott.emmett;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI {

	private JFrame frame;
	private JPanel panel;
	
	private ImageIcon image;
	
	private ArrayList<ArrayList<JButton>> spaces = new ArrayList<>();
	
	public GUI(){
		frame = new JFrame("Connect Four");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(780,720));
		
		panel = new JPanel();
		fillPanel();
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void fillPanel(){
		panel.setPreferredSize(new Dimension(780,720));
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		try{
			image = new ImageIcon("C4Open.png");
		}catch(Exception e){}
		
		for(int i = 3; i < 10; i++){
			c.gridx = i;
			for(int j = 3; j < 9; j++){
				c.gridy = j;
				panel.add(new JLabel(image), c);
			}
		}
		
		
		
	}
	
	
}
