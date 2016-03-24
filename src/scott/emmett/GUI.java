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
	
	private JButton helpButton;
	private JButton replayButton;
	private JButton playersButton;
	
	private ImageIcon image;
	
	private ArrayList<ArrayList<JLabel>> spaces = new ArrayList<>();
	
	public GUI(){
		frame = new JFrame("Connect Four");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(780,680));
		
		panel = new JPanel();
		fillPanel();
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void fillPanel(){
		panel.setPreferredSize(new Dimension(780,680));
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		//add main grid images
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
		
		/*//add left side images
		try{
			image = new ImageIcon("C4LeftSide.png");
		}catch(Exception e){}
		c.gridx = 2;
		for(int j = 3; j < 9; j++){
			c.gridy = j;
			panel.add(new JLabel(image), c);
		}
		
		//add right side images
		try{
			image = new ImageIcon("C4RightSide.png");
		}catch(Exception e){}
		c.gridx = 10;
		for(int j = 3; j < 9; j++){
			c.gridy = j;
			panel.add(new JLabel(image), c);
		}
		
		//add feet
		try{
			image = new ImageIcon("C4LeftLeg.png");
		}catch(Exception e){}
		c.gridx = 2;
		c.gridy = 9;
		panel.add(new JLabel(image), c);
		try{
			image = new ImageIcon("C4RightLeg.png");
		}catch(Exception e){}
		c.gridx = 10;
		c.gridy = 9;
		panel.add(new JLabel(image), c);*/
		//Add game title
		try{
			image = new ImageIcon("C4Title.png");
		}catch(Exception e){}
		c.gridx = 5;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 3;
		panel.add(new JLabel(image), c);
		
		//Add player labels
		try{
			image = new ImageIcon("C4Player1.png");
		}catch(Exception e){}
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 3;
		panel.add(new JLabel(image), c);
		try{
			image = new ImageIcon("C4Player2.png");
		}catch(Exception e){}
		c.gridx = 10;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 3;
		panel.add(new JLabel(image), c);
		
		//Adds bottom buttons
		try{
			image = new ImageIcon("C4Help.png");
		}catch(Exception e){}
		c.gridx = 12;
		c.gridy = 11;
		c.gridheight = 1;
		c.gridwidth = 1;
		helpButton = new JButton(image);
		panel.add(helpButton, c);
		try{
			image = new ImageIcon("C4PlayAgain.png");
		}catch(Exception e){}
		c.gridx = 0;
		c.gridy = 11;
		c.gridheight = 1;
		c.gridwidth = 1;
		replayButton = new JButton(image);
		panel.add(replayButton, c);
		try{
			image = new ImageIcon("C4SinglePlayer.png");
		}catch(Exception e){}
		c.gridx = 1;
		c.gridy = 11;
		c.gridheight = 1;
		c.gridwidth = 1;
		playersButton = new JButton(image);
		panel.add(playersButton, c);
	}
	
	
}
