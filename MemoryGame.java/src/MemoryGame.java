import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MemoryGame extends JFrame{
	
	JFrame frame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel Panel1 = new JPanel();
	JPanel Panel2 = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	JButton button5 = new JButton();
	JButton button6 = new JButton();
	JButton button7 = new JButton();
	JButton button8 = new JButton();
	JButton ResetButton = new JButton("Reset");
	JButton ExitButton = new JButton("Exit");
	Random random = new Random();
	Timer timer = new Timer();
	
	String bOne;
	String bTwo;
	String bThree;
	String bFour;
	String bFive;
	String bSix;
	String bSeven;
	String bEight;
	
	int clickedButton = 0;
	int numberClickedButton = 0;
	int clicks = 0;
	int winCount = 0;
	
	public MemoryGame(){
		
		this.setSize(450, 300);
		this.setLocationRelativeTo(null);
		this.setTitle("StudentGUI");
		this.add(mainPanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		mainPanel.setLayout(new GridLayout(2,1));
		mainPanel.add(Panel1);
		mainPanel.add(Panel2);
		
		Panel1.setLayout(new GridLayout(4,4));
		Panel1.setBorder(BorderFactory.createBevelBorder(NORMAL));
		Panel1.setPreferredSize(getPreferredSize());
		Panel2.setLayout(new GridLayout(1,3));
		Panel2.setBorder(BorderFactory.createBevelBorder(NORMAL));
		
		Panel1.add(button1);
		Panel1.add(button2);
		Panel1.add(button3);
		Panel1.add(button4);
		Panel1.add(button5);
		Panel1.add(button6);
		Panel1.add(button7);
		Panel1.add(button8);

		Panel2.add(ResetButton);
		Panel2.add(ExitButton);
		
		ButtonListener buttonl = new ButtonListener();
		ResetButton.addActionListener(buttonl);
		button1.addActionListener(buttonl);
		button2.addActionListener(buttonl);
		button3.addActionListener(buttonl);
		button4.addActionListener(buttonl);
		button5.addActionListener(buttonl);
		button6.addActionListener(buttonl);
		button7.addActionListener(buttonl);
		button8.addActionListener(buttonl);
		ExitButton.addActionListener(buttonl);

		this.setVisible(true);
	}
	
	void reset(){	
		int[] buttonsArray = {1, 1, 2, 2, 3, 3, 4, 4};
		int[] tempArray = new int[8];
		int count = 7;
		for(int i = 0; i <= 7; i++){
			int x = random.nextInt(count);			
			if(count > 1){
				count--;
			}
			tempArray[i] = buttonsArray[x];		
			for(int j = x; j <= count; j++){
				if(j != 7){
					buttonsArray[j] = buttonsArray[j + 1];
				}			
			}
		}
		button1.setText(Integer.toString(tempArray[0]));
		bOne = Integer.toString(tempArray[0]);
		button2.setText(Integer.toString(tempArray[1]));
		bTwo = Integer.toString(tempArray[1]);
		button3.setText(Integer.toString(tempArray[2]));
		bThree = Integer.toString(tempArray[2]);
		button4.setText(Integer.toString(tempArray[3]));
		bFour = Integer.toString(tempArray[3]);
		button5.setText(Integer.toString(tempArray[4]));
		bFive = Integer.toString(tempArray[4]);
		button6.setText(Integer.toString(tempArray[5]));
		bSix = Integer.toString(tempArray[5]);
		button7.setText(Integer.toString(tempArray[6]));
		bSeven = Integer.toString(tempArray[6]);
		button8.setText(Integer.toString(tempArray[7]));
		bEight = Integer.toString(tempArray[7]);
		
		timer.schedule(new TimerTask(){
			public void run(){
				button1.setText(null);
				button2.setText(null);
				button3.setText(null);
				button4.setText(null);
				button5.setText(null);
				button6.setText(null);
				button7.setText(null);
				button8.setText(null);
			}
		}, 5000);
		
		button1.setEnabled(true);
		button2.setEnabled(true);
		button3.setEnabled(true);
		button4.setEnabled(true);
		button5.setEnabled(true);
		button6.setEnabled(true);
		button7.setEnabled(true);
		button8.setEnabled(true);
		winCount = 0;
		
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == ResetButton){
				reset();
			}
			
			if(e.getSource() == button1){
				if(Integer.parseInt(bOne) == numberClickedButton && clickedButton != 1 && clicks == 1){
					button1.setEnabled(false);
					button1.setText(bOne);
					clickedButton = Integer.parseInt(bOne);
					winCount = winCount + 1;
					if(clickedButton == Integer.parseInt(bTwo) && button2.isEnabled()){
						button2.setEnabled(false);
						button2.setText(bTwo);
					}
					if(clickedButton == Integer.parseInt(bThree) && button3.isEnabled()){
						button3.setEnabled(false);
						button3.setText(bThree);
					}
					if(clickedButton == Integer.parseInt(bFour) && button4.isEnabled()){
						button4.setEnabled(false);
						button4.setText(bFour);
					}
					if(clickedButton == Integer.parseInt(bFive) && button5.isEnabled()){
						button5.setEnabled(false);
						button5.setText(bFive);
					}
					if(clickedButton == Integer.parseInt(bSix) && button6.isEnabled()){
						button6.setEnabled(false);
						button6.setText(bSix);
					}
					if(clickedButton == Integer.parseInt(bSeven) && button7.isEnabled()){
						button7.setEnabled(false);
						button7.setText(bSeven);
					}
					if(clickedButton == Integer.parseInt(bEight) && button8.isEnabled()){
						button8.setEnabled(false);
						button8.setText(bEight);
					}
				}
				
				if(button1.getText() == null){
					if(clicks == 1){
						if(button1.isEnabled())
							button1.setText(null);
						if(button2.isEnabled())
							button2.setText(null);
						if(button3.isEnabled())
							button3.setText(null);
						if(button4.isEnabled())
							button4.setText(null);
						if(button5.isEnabled())
							button5.setText(null);
						if(button6.isEnabled())
							button6.setText(null);
						if(button7.isEnabled())
							button7.setText(null);
						if(button8.isEnabled())
							button8.setText(null);
						button1.setText(bOne);
						numberClickedButton = Integer.parseInt(bOne);
						clickedButton = 1;
						clicks = 1;
					}
					else{
						button1.setText(bOne);
						numberClickedButton = Integer.parseInt(bOne);
						clickedButton = 1;
						clicks = 1;
					}
				}
				else if(clicks ==1){
					if(button1.isEnabled())
						button1.setText(null);
					if(button2.isEnabled())
						button2.setText(null);
					if(button3.isEnabled())
						button3.setText(null);
					if(button4.isEnabled())
						button4.setText(null);
					if(button5.isEnabled())
						button5.setText(null);
					if(button6.isEnabled())
						button6.setText(null);
					if(button7.isEnabled())
						button7.setText(null);
					if(button8.isEnabled())
						button8.setText(null);
					clicks = 0;
					

				}
				if(winCount == 4){
					JOptionPane.showMessageDialog(frame, "You Win!");
				}
			}
			
			if(e.getSource() == button2){
				if(Integer.parseInt(bTwo) == numberClickedButton && clickedButton != 2 && clicks == 1){
					button2.setEnabled(false);
					button2.setText(bTwo);
					clickedButton = Integer.parseInt(bTwo);
					winCount = winCount + 1;
					if(clickedButton == Integer.parseInt(bOne) && button1.isEnabled()){
						button1.setEnabled(false);
						button1.setText(bOne);
					}
					if(clickedButton == Integer.parseInt(bThree) && button3.isEnabled()){
						button3.setEnabled(false);
						button3.setText(bThree);
					}
					if(clickedButton == Integer.parseInt(bFour) && button4.isEnabled()){
						button4.setEnabled(false);
						button4.setText(bFour);
					}
					if(clickedButton == Integer.parseInt(bFive) && button5.isEnabled()){
						button5.setEnabled(false);
						button5.setText(bFive);
					}
					if(clickedButton == Integer.parseInt(bSix) && button6.isEnabled()){
						button6.setEnabled(false);
						button6.setText(bSix);
					}
					if(clickedButton == Integer.parseInt(bSeven) && button7.isEnabled()){
						button7.setEnabled(false);
						button7.setText(bSeven);
					}
					if(clickedButton == Integer.parseInt(bEight) && button8.isEnabled()){
						button8.setEnabled(false);
						button8.setText(bEight);
					}
				}
				
				if(button2.getText() == null){
					if(clicks == 1){
						if(button1.isEnabled())
							button1.setText(null);
						if(button2.isEnabled())
							button2.setText(null);
						if(button3.isEnabled())
							button3.setText(null);
						if(button4.isEnabled())
							button4.setText(null);
						if(button5.isEnabled())
							button5.setText(null);
						if(button6.isEnabled())
							button6.setText(null);
						if(button7.isEnabled())
							button7.setText(null);
						if(button8.isEnabled())
							button8.setText(null);
						button2.setText(bTwo);
						numberClickedButton = Integer.parseInt(bTwo);
						clickedButton = 2;
						clicks = 1;
					}
					else{
						button2.setText(bTwo);
						numberClickedButton = Integer.parseInt(bTwo);
						clickedButton = 2;
						clicks = 1;
					}
				}
				else if(clicks == 1){
					if(button1.isEnabled())
						button1.setText(null);
					if(button2.isEnabled())
						button2.setText(null);
					if(button3.isEnabled())
						button3.setText(null);
					if(button4.isEnabled())
						button4.setText(null);
					if(button5.isEnabled())
						button5.setText(null);
					if(button6.isEnabled())
						button6.setText(null);
					if(button7.isEnabled())
						button7.setText(null);
					if(button8.isEnabled())
						button8.setText(null);
					clicks = 0;
				}
				if(winCount == 4){
					JOptionPane.showMessageDialog(frame, "You Win!");
				}
			}
			if(e.getSource() == button3){
				if(Integer.parseInt(bThree) == numberClickedButton && clickedButton != 3 && clicks == 1){
					button3.setEnabled(false);
					button3.setText(bThree);
					clickedButton = Integer.parseInt(bThree);
					winCount = winCount + 1;
					if(clickedButton == Integer.parseInt(bTwo) && button2.isEnabled()){
						button2.setEnabled(false);
						button2.setText(bTwo);
					}
					if(clickedButton == Integer.parseInt(bOne) && button1.isEnabled()){
						button1.setEnabled(false);
						button1.setText(bOne);
					}
					if(clickedButton == Integer.parseInt(bFour) && button4.isEnabled()){
						button4.setEnabled(false);
						button4.setText(bFour);
					}
					if(clickedButton == Integer.parseInt(bFive) && button5.isEnabled()){
						button5.setEnabled(false);
						button5.setText(bFive);
					}
					if(clickedButton == Integer.parseInt(bSix) && button6.isEnabled()){
						button6.setEnabled(false);
						button6.setText(bSix);
					}
					if(clickedButton == Integer.parseInt(bSeven) && button7.isEnabled()){
						button7.setEnabled(false);
						button7.setText(bSeven);
					}
					if(clickedButton == Integer.parseInt(bEight) && button8.isEnabled()){
						button8.setEnabled(false);
						button8.setText(bEight);
					}
				}
				
				if(button3.getText() == null){
					if(clicks == 1){
						if(button1.isEnabled())
							button1.setText(null);
						if(button2.isEnabled())
							button2.setText(null);
						if(button3.isEnabled())
							button3.setText(null);
						if(button4.isEnabled())
							button4.setText(null);
						if(button5.isEnabled())
							button5.setText(null);
						if(button6.isEnabled())
							button6.setText(null);
						if(button7.isEnabled())
							button7.setText(null);
						if(button8.isEnabled())
							button8.setText(null);
						button3.setText(bThree);
						numberClickedButton = Integer.parseInt(bThree);
						clickedButton = 3;
						clicks = 1;
					}
					else{
						button3.setText(bThree);
						numberClickedButton = Integer.parseInt(bThree);
						clickedButton = 3;
						clicks = 1;
					}
				}
				else if(clicks == 1){
					if(button1.isEnabled())
						button1.setText(null);
					if(button2.isEnabled())
						button2.setText(null);
					if(button3.isEnabled())
						button3.setText(null);
					if(button4.isEnabled())
						button4.setText(null);
					if(button5.isEnabled())
						button5.setText(null);
					if(button6.isEnabled())
						button6.setText(null);
					if(button7.isEnabled())
						button7.setText(null);
					if(button8.isEnabled())
						button8.setText(null);
					clicks = 0;
					

				}
				if(winCount == 4){
					JOptionPane.showMessageDialog(frame, "You Win!");
				}
			}
			if(e.getSource() == button4){
				if(Integer.parseInt(bFour) == numberClickedButton && clickedButton != 4 && clicks == 1){
					button4.setEnabled(false);
					button4.setText(bFour);
					clickedButton = Integer.parseInt(bFour);
					winCount = winCount + 1;
					if(clickedButton == Integer.parseInt(bTwo) && button2.isEnabled()){
						button2.setEnabled(false);
						button2.setText(bTwo);
					}
					if(clickedButton == Integer.parseInt(bThree) && button3.isEnabled()){
						button3.setEnabled(false);
						button3.setText(bThree);
					}
					if(clickedButton == Integer.parseInt(bOne) && button1.isEnabled()){
						button1.setEnabled(false);
						button1.setText(bOne);
					}
					if(clickedButton == Integer.parseInt(bFive) && button5.isEnabled()){
						button5.setEnabled(false);
						button5.setText(bFive);
					}
					if(clickedButton == Integer.parseInt(bSix) && button6.isEnabled()){
						button6.setEnabled(false);
						button6.setText(bSix);
					}
					if(clickedButton == Integer.parseInt(bSeven) && button7.isEnabled()){
						button7.setEnabled(false);
						button7.setText(bSeven);
					}
					if(clickedButton == Integer.parseInt(bEight) && button8.isEnabled()){
						button8.setEnabled(false);
						button8.setText(bEight);
					}
				}
				
				if(button4.getText() == null){
					if(clicks == 1){
						if(button1.isEnabled())
							button1.setText(null);
						if(button2.isEnabled())
							button2.setText(null);
						if(button3.isEnabled())
							button3.setText(null);
						if(button4.isEnabled())
							button4.setText(null);
						if(button5.isEnabled())
							button5.setText(null);
						if(button6.isEnabled())
							button6.setText(null);
						if(button7.isEnabled())
							button7.setText(null);
						if(button8.isEnabled())
							button8.setText(null);
						button4.setText(bFour);
						numberClickedButton = Integer.parseInt(bFour);
						clickedButton = 4;
						clicks = 1;
					}
					else{
						button4.setText(bFour);
						numberClickedButton = Integer.parseInt(bFour);
						clickedButton = 4;
						clicks = 1;
					}

				}
				else {
					if(button1.isEnabled())
						button1.setText(null);
					if(button2.isEnabled())
						button2.setText(null);
					if(button3.isEnabled())
						button3.setText(null);
					if(button4.isEnabled())
						button4.setText(null);
					if(button5.isEnabled())
						button5.setText(null);
					if(button6.isEnabled())
						button6.setText(null);
					if(button7.isEnabled())
						button7.setText(null);
					if(button8.isEnabled())
						button8.setText(null);
					clicks = 0;
					

				}
				if(winCount == 4){
					JOptionPane.showMessageDialog(frame, "You Win!");
				}
			}
			
			if(e.getSource() == button5){
				if(Integer.parseInt(bFive) == numberClickedButton && clickedButton != 5 && clicks == 1){
					button5.setEnabled(false);
					button5.setText(bFive);
					clickedButton = Integer.parseInt(bFive);
					winCount = winCount + 1;
					if(clickedButton == Integer.parseInt(bTwo) && button2.isEnabled()){
						button2.setEnabled(false);
						button2.setText(bTwo);
					}
					if(clickedButton == Integer.parseInt(bThree) && button3.isEnabled()){
						button3.setEnabled(false);
						button3.setText(bThree);
					}
					if(clickedButton == Integer.parseInt(bFour) && button4.isEnabled()){
						button4.setEnabled(false);
						button4.setText(bFour);
					}
					if(clickedButton == Integer.parseInt(bOne) && button1.isEnabled()){
						button1.setEnabled(false);
						button1.setText(bOne);
					}
					if(clickedButton == Integer.parseInt(bSix) && button6.isEnabled()){
						button6.setEnabled(false);
						button6.setText(bSix);
					}
					if(clickedButton == Integer.parseInt(bSeven) && button7.isEnabled()){
						button7.setEnabled(false);
						button7.setText(bSeven);
					}
					if(clickedButton == Integer.parseInt(bEight) && button8.isEnabled()){
						button8.setEnabled(false);
						button8.setText(bEight);
					}
				}
				
				if(button5.getText() == null){
					if(clicks == 1){
						if(button1.isEnabled())
							button1.setText(null);
						if(button2.isEnabled())
							button2.setText(null);
						if(button3.isEnabled())
							button3.setText(null);
						if(button4.isEnabled())
							button4.setText(null);
						if(button5.isEnabled())
							button5.setText(null);
						if(button6.isEnabled())
							button6.setText(null);
						if(button7.isEnabled())
							button7.setText(null);
						if(button8.isEnabled())
							button8.setText(null);
						button5.setText(bFive);
						numberClickedButton = Integer.parseInt(bFive);
						clickedButton = 5;
						clicks = 1;
					}
					else{
						button5.setText(bFive);
						numberClickedButton = Integer.parseInt(bFive);
						clickedButton = 5;
						clicks = 1;
					}
				}
				else if(clicks == 1){
					if(button1.isEnabled())
						button1.setText(null);
					if(button2.isEnabled())
						button2.setText(null);
					if(button3.isEnabled())
						button3.setText(null);
					if(button4.isEnabled())
						button4.setText(null);
					if(button5.isEnabled())
						button5.setText(null);
					if(button6.isEnabled())
						button6.setText(null);
					if(button7.isEnabled())
						button7.setText(null);
					if(button8.isEnabled())
						button8.setText(null);
					clicks = 0;
					

				}
				if(winCount == 4){
					JOptionPane.showMessageDialog(frame, "You Win!");
				}
			}
			
			if(e.getSource() == button6){
				if(Integer.parseInt(bSix) == numberClickedButton && clickedButton != 6 && clicks == 1){
					button6.setEnabled(false);
					button6.setText(bSix);
					clickedButton = Integer.parseInt(bSix);
					winCount = winCount + 1;
					if(clickedButton == Integer.parseInt(bTwo) && button2.isEnabled()){
						button2.setEnabled(false);
						button2.setText(bTwo);
					}
					if(clickedButton == Integer.parseInt(bThree) && button3.isEnabled()){
						button3.setEnabled(false);
						button3.setText(bThree);
					}
					if(clickedButton == Integer.parseInt(bFour) && button4.isEnabled()){
						button4.setEnabled(false);
						button4.setText(bFour);
					}
					if(clickedButton == Integer.parseInt(bFive) && button5.isEnabled()){
						button5.setEnabled(false);
						button5.setText(bFive);
					}
					if(clickedButton == Integer.parseInt(bOne) && button1.isEnabled()){
						button1.setEnabled(false);
						button1.setText(bOne);
					}
					if(clickedButton == Integer.parseInt(bSeven) && button7.isEnabled()){
						button7.setEnabled(false);
						button7.setText(bSeven);
					}
					if(clickedButton == Integer.parseInt(bEight) && button8.isEnabled()){
						button8.setEnabled(false);
						button8.setText(bEight);
					}
				}
				
				if(button6.getText() == null){
					if(clicks == 1){
						if(button1.isEnabled())
							button1.setText(null);
						if(button2.isEnabled())
							button2.setText(null);
						if(button3.isEnabled())
							button3.setText(null);
						if(button4.isEnabled())
							button4.setText(null);
						if(button5.isEnabled())
							button5.setText(null);
						if(button6.isEnabled())
							button6.setText(null);
						if(button7.isEnabled())
							button7.setText(null);
						if(button8.isEnabled())
							button8.setText(null);
						button6.setText(bSix);
						numberClickedButton = Integer.parseInt(bSix);
						clickedButton = 6;
						clicks = 1;
					}
					else{
						button6.setText(bSix);
						numberClickedButton = Integer.parseInt(bSix);
						clickedButton = 6;
						clicks = 1;
					}
				}
				else if(clicks == 1){
					if(button1.isEnabled())
						button1.setText(null);
					if(button2.isEnabled())
						button2.setText(null);
					if(button3.isEnabled())
						button3.setText(null);
					if(button4.isEnabled())
						button4.setText(null);
					if(button5.isEnabled())
						button5.setText(null);
					if(button6.isEnabled())
						button6.setText(null);
					if(button7.isEnabled())
						button7.setText(null);
					if(button8.isEnabled())
						button8.setText(null);
					clicks = 0;
					

				}
				if(winCount == 4){
					JOptionPane.showMessageDialog(frame, "You Win!");
				}
			}
			
			if(e.getSource() == button7){
				if(Integer.parseInt(bSeven) == numberClickedButton && clickedButton != 7 && clicks == 1){
					button7.setEnabled(false);
					button7.setText(bSeven);
					clickedButton = Integer.parseInt(bSeven);
					winCount = winCount + 1;
					if(clickedButton == Integer.parseInt(bTwo) && button2.isEnabled()){
						button2.setEnabled(false);
						button2.setText(bTwo);
					}
					if(clickedButton == Integer.parseInt(bThree) && button3.isEnabled()){
						button3.setEnabled(false);
						button3.setText(bThree);
					}
					if(clickedButton == Integer.parseInt(bFour) && button4.isEnabled()){
						button4.setEnabled(false);
						button4.setText(bFour);
					}
					if(clickedButton == Integer.parseInt(bFive) && button5.isEnabled()){
						button5.setEnabled(false);
						button5.setText(bFive);
					}
					if(clickedButton == Integer.parseInt(bSix) && button6.isEnabled()){
						button6.setEnabled(false);
						button6.setText(bSix);
					}
					if(clickedButton == Integer.parseInt(bOne) && button1.isEnabled()){
						button1.setEnabled(false);
						button1.setText(bOne);
					}
					if(clickedButton == Integer.parseInt(bEight) && button8.isEnabled()){
						button8.setEnabled(false);
						button8.setText(bEight);
					}
				}
				
				if(button7.getText() == null){
					if(clicks == 1){
						if(button1.isEnabled())
							button1.setText(null);
						if(button2.isEnabled())
							button2.setText(null);
						if(button3.isEnabled())
							button3.setText(null);
						if(button4.isEnabled())
							button4.setText(null);
						if(button5.isEnabled())
							button5.setText(null);
						if(button6.isEnabled())
							button6.setText(null);
						if(button7.isEnabled())
							button7.setText(null);
						if(button8.isEnabled())
							button8.setText(null);
						button7.setText(bSeven);
						numberClickedButton = Integer.parseInt(bSeven);
						clickedButton = 7;
						clicks = 1;
					}
					else{
						button7.setText(bSeven);
						numberClickedButton = Integer.parseInt(bSeven);
						clickedButton = 7;
						clicks = 1;
					}
				}
				else if(clicks == 1){
					if(button1.isEnabled())
						button1.setText(null);
					if(button2.isEnabled())
						button2.setText(null);
					if(button3.isEnabled())
						button3.setText(null);
					if(button4.isEnabled())
						button4.setText(null);
					if(button5.isEnabled())
						button5.setText(null);
					if(button6.isEnabled())
						button6.setText(null);
					if(button7.isEnabled())
						button7.setText(null);
					if(button8.isEnabled())
						button8.setText(null);
					clicks = 0;
					

				}
				if(winCount == 4){
					JOptionPane.showMessageDialog(frame, "You Win!");
				}
			}
			
			if(e.getSource() == button8){
				if(Integer.parseInt(bEight) == numberClickedButton && clickedButton != 8 && clicks == 1){
					button8.setEnabled(false);
					button8.setText(bEight);
					clickedButton = Integer.parseInt(bEight);
					winCount = winCount + 1;
					if(clickedButton == Integer.parseInt(bTwo) && button2.isEnabled()){
						button2.setEnabled(false);
						button2.setText(bTwo);
					}
					if(clickedButton == Integer.parseInt(bThree) && button3.isEnabled()){
						button3.setEnabled(false);
						button3.setText(bThree);
					}
					if(clickedButton == Integer.parseInt(bFour) && button4.isEnabled()){
						button4.setEnabled(false);
						button4.setText(bFour);
					}
					if(clickedButton == Integer.parseInt(bFive) && button5.isEnabled()){
						button5.setEnabled(false);
						button5.setText(bFive);
					}
					if(clickedButton == Integer.parseInt(bSix) && button6.isEnabled()){
						button6.setEnabled(false);
						button6.setText(bSix);
					}
					if(clickedButton == Integer.parseInt(bSeven) && button7.isEnabled()){
						button7.setEnabled(false);
						button7.setText(bSeven);
					}
					if(clickedButton == Integer.parseInt(bOne) && button1.isEnabled()){
						button1.setEnabled(false);
						button1.setText(bOne);
					}
				}
				
				if(button8.getText() == null){
					if(clicks == 1){
						if(button1.isEnabled())
							button1.setText(null);
						if(button2.isEnabled())
							button2.setText(null);
						if(button3.isEnabled())
							button3.setText(null);
						if(button4.isEnabled())
							button4.setText(null);
						if(button5.isEnabled())
							button5.setText(null);
						if(button6.isEnabled())
							button6.setText(null);
						if(button7.isEnabled())
							button7.setText(null);
						if(button8.isEnabled())
							button8.setText(null);
						button8.setText(bEight);
						numberClickedButton = Integer.parseInt(bEight);
						clickedButton = 8;
						clicks = 1;
					}
					else{
						button8.setText(bEight);
						numberClickedButton = Integer.parseInt(bEight);
						clickedButton = 8;
						clicks = 1;
					}
				}
				else if(clicks == 1){
					if(button1.isEnabled())
						button1.setText(null);
					if(button2.isEnabled())
						button2.setText(null);
					if(button3.isEnabled())
						button3.setText(null);
					if(button4.isEnabled())
						button4.setText(null);
					if(button5.isEnabled())
						button5.setText(null);
					if(button6.isEnabled())
						button6.setText(null);
					if(button7.isEnabled())
						button7.setText(null);
					if(button8.isEnabled())
						button8.setText(null);
					clicks = 0;
					

				}
				if(winCount == 4){
					JOptionPane.showMessageDialog(frame, "You Win!");
				}
			}
			if(e.getSource() == ExitButton){
				int buttons = JOptionPane.YES_NO_OPTION;
				int questionX = JOptionPane.showConfirmDialog(null, "Are you sure you want to close this window?", "Dialog", buttons);
				if(questionX == JOptionPane.YES_OPTION){
				  System.exit(0);
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		new MemoryGame();

	}

}

