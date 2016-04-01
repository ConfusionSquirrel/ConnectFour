package scott.emmett;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI {

	//Okay, so remember, all the labels are going to have to be buttons so we can add rollover behavior.
	//They will also have to be stored so we can refer to them and change their icon
	private Grid grid;
	
	private JFrame frame;
	private JPanel panel;
	
	private JButton helpButton;
	private JButton replayButton;
	private JButton playersButton;
	
	private ImageIcon image;
	
	private JLabel leftPlayerLabel;
	private JLabel rightPlayerLabel;
	
	private ArrayList<ArrayList<JButton>> cells = new ArrayList<>();
	private Hashtable<JButton,int[]> coords = new Hashtable<>();
	private Hashtable<String,ImageIcon> pics = new Hashtable<>();
	
	public GUI(Grid g){
		loadImages();
		frame = new JFrame("Connect Four");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(780,680));
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		fillPanel();
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		grid = g;
	}
	
	private void fillPanel(){
		panel.setPreferredSize(new Dimension(880,680));
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		//add main grid images
		JButton but;
		for(int i = 3; i < 10; i++){
			c.gridx = i;
			ArrayList<JButton> column = new ArrayList<>();
			for(int j = 8; j > 2; j--){
				c.gridy = j;but = new JButton(pics.get("Open"));
				but.setBorder(BorderFactory.createEmptyBorder());
				but.setContentAreaFilled(false);
				but.setRolloverEnabled(false);
				if(j == 3){
					but.setRolloverEnabled(true);
					but.setRolloverIcon(pics.get("OpenHighlighted"));
				}
				panel.add(but, c);
				column.add(but);
				int[] coord = {i-3,j-3};
				coords.put(but,coord);
			}
			cells.add(column);
		}
		
		addSides(c);
		addFeet(c);
		addTitle(c);
		addPlayerLabels(c);
		addUtilityClickers(c);
		addOther(c);
	
		addListeners();
	}
	private void addListeners(){
		for(int i = 0; i < 7; i++){
			cells.get(i).get(5).addActionListener(new GridClickListener());
		}
		helpButton.addActionListener(new HelpClickListener());
		replayButton.addActionListener(new ReplayClickListener());
		playersButton.addActionListener(new PlayersClickListener());
	}
	
	private void addSides(GridBagConstraints c){
		//add left side images
		c.gridx = 2;
		for(int j = 3; j < 9; j++){
		c.gridy = j;
		panel.add(new JLabel(pics.get("LeftSide")), c);
		}
		//add right side images
		c.gridx = 10;
		for(int j = 3; j < 9; j++){
			c.gridy = j;
			panel.add(new JLabel(pics.get("RightSide")), c);
		}
	}
	private void addFeet(GridBagConstraints c){
		//add feet
		c.gridx = 2;
		c.gridy = 9;
		panel.add(new JLabel(pics.get("LeftLeg")), c);
		c.gridx = 10;
		c.gridy = 9;
		panel.add(new JLabel(pics.get("RightLeg")), c);
	}
	private void addTitle(GridBagConstraints c){
		//Add game title
		c.gridx = 5;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 3;
		panel.add(new JLabel(pics.get("Title")), c);
	}
	private void addPlayerLabels(GridBagConstraints c){
		//Add player labels
		try{
			image = new ImageIcon("C4Player1.png");
		}catch(Exception e){}
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 3;
		leftPlayerLabel = new JLabel();
		leftPlayerLabel.setIcon(image);
		panel.add(leftPlayerLabel, c);
		try{
			image = new ImageIcon("C4Player2.png");
		}catch(Exception e){}
		c.gridx = 10;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 3;
		rightPlayerLabel = new JLabel();
		rightPlayerLabel.setIcon(image);
		panel.add(rightPlayerLabel, c);
	}
	private void addUtilityClickers(GridBagConstraints c){
		//Add bottom buttons
		c.gridx = 12;
		c.gridy = 10;
		c.gridheight = 1;
		c.gridwidth = 1;
		helpButton = new JButton(pics.get("Help"));
		panel.add(helpButton, c);
		c.gridx = 0;
		c.gridy = 10;
		c.gridheight = 1;
		c.gridwidth = 1;
		replayButton = new JButton(pics.get("PlayAgain"));
		panel.add(replayButton, c);
		c.gridx = 1;
		c.gridy = 10;
		c.gridheight = 1;
		c.gridwidth = 1;
		playersButton = new JButton(pics.get("MultiPlayer"));
		panel.add(playersButton, c);
	}
	private void addOther(GridBagConstraints c){
		//Add necessary blanks
		c.gridx = 11;
		c.gridy = 11;
		c.gridheight = 1;
		c.gridwidth = 1;
		panel.add(new JLabel(pics.get("Blank")), c);
	}
	
	private void loadImages(){
		try{
			pics.put("Blank", new ImageIcon("C4Blank.png"));
			pics.put("Comp", new ImageIcon("C4Comp.png"));
			pics.put("CompHighlighted", new ImageIcon("C4CompHighlighted.png"));
			pics.put("Help", new ImageIcon("C4Help.png"));
			pics.put("LeftLeg", new ImageIcon("C4LeftLeg.png"));
			pics.put("LeftSide", new ImageIcon("C4LeftSide.png"));
			pics.put("MultiPlayer", new ImageIcon("C4MultiPlayer.png"));
			pics.put("Open", new ImageIcon("C4Open.png"));
			pics.put("OpenHighlighted", new ImageIcon("C4OpenHighlighted.png"));
			pics.put("PlayAgain", new ImageIcon("C4PlayAgain.png"));
			pics.put("Player1", new ImageIcon("C4Player1.png"));
			pics.put("Player1Highlighted", new ImageIcon("C4Player1Highlighted.png"));
			pics.put("Player2", new ImageIcon("C4Player2.png"));
			pics.put("Player2Highlighted", new ImageIcon("C4Player2Highlighted.png"));
			pics.put("Red", new ImageIcon("C4Red.png"));
			pics.put("RedHighlighted", new ImageIcon("C4RedHighlighted.png"));
			pics.put("RightLeg", new ImageIcon("C4RightLeg.png"));
			pics.put("RightSide", new ImageIcon("C4RightSide.png"));
			pics.put("SinglePlayer", new ImageIcon("C4SinglePlayer.png"));
			pics.put("Title", new ImageIcon("C4Title.png"));
			pics.put("Yellow", new ImageIcon("C4Yellow.png"));
			pics.put("YellowHighlighted", new ImageIcon("C4YellowHighlighted.png"));
		}catch(Exception e){}
	}
	
	public void togglePlayerLabelHighlight(){
		if(Driver.getWhoseTurn() == 1){
			leftPlayerLabel.setIcon(pics.get("Player1Highlighted"));
			if(Driver.getPlayers() == 1){
				rightPlayerLabel.setIcon(pics.get("Comp"));
			}
			else{
				rightPlayerLabel.setIcon(pics.get("Player2"));
			}
		}
		else{
			leftPlayerLabel.setIcon(pics.get("Player1"));
			if(Driver.getPlayers() == 1){
				rightPlayerLabel.setIcon(pics.get("CompHighlighted"));
			}
			else{
				rightPlayerLabel.setIcon(pics.get("Player2Highlighted"));
			}
		}
	}
	public void fillSpot(int[] coord){
		if(Driver.getWhoseTurn() == 1){
			cells.get(coord[0]).get(coord[1]).setIcon(pics.get("Red"));
			if(coord[1] == 5) cells.get(coord[0]).get(coord[1]).setRolloverIcon(pics.get("RedHighlighted"));
		}
		else{
			cells.get(coord[0]).get(coord[1]).setIcon(pics.get("Yellow"));
			if(coord[1] == 5) cells.get(coord[0]).get(coord[1]).setRolloverIcon(pics.get("YellowHighlighted"));
		}
	}
	public JFrame getFrame(){
		return frame;
	}
	
	public void wipe(){
		System.out.println("gui wipe");
		for(ArrayList<JButton> a : cells){
			System.out.println("got a");
			for(JButton j : a){
				System.out.println("got j");
				j.setIcon(pics.get("Open"));
				if(coords.get(j)[1] == 0) j.setRolloverIcon(pics.get("OpenHighlighted"));
			}
		}
	}
//
private class GridClickListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Driver.isTimeToClick()){
			grid.drop(coords.get(e.getSource())[0]);	
		}
		
	}
	
}
private class HelpClickListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(frame,
			    "Intructions:\n"
				+ "Create a line of four pieces of your colour (vertically, horizontally or diagonally) to win.\n"
			    + "Pieces can't be placed anywhere, they're dropped into the first available space in the column.\n"
				+ "\n"
			    + "The button with the arrow allows you to start a new game at any time.\n"
				+ "The button beside it, with one or more smiling faces, allows you to cycle between multiplayer and singleplayer modes.\n"
			    + "In singleplayer, you can test your skills against the computer.\n"
				+ "\n"
			    + "Have fun!",
			    "Help",
			    JOptionPane.PLAIN_MESSAGE);
		
	}
	
}
private class ReplayClickListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Driver.replay();
		
	}
}
private class PlayersClickListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Driver.getPlayers() == 1){
			Driver.setPlayers(2);
			playersButton.setIcon(pics.get("MultiPlayer"));
			rightPlayerLabel.setIcon(pics.get("Player2"));
		}
		else{
			Driver.setPlayers(1);
			playersButton.setIcon(pics.get("SinglePlayer"));
			rightPlayerLabel.setIcon(pics.get("Comp"));
		}
		
				
	}
}

}
