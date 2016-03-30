import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Random;

public class Dice {
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel label;
	
	public Dice()
	{
		panel = new JPanel();
		button = new JButton("Roll");
		text = new JTextField(3);
		label = new JLabel("Enter the number of sides for the dice");
		button.addActionListener(buttonListener());
		panel.add(text);
		panel.add(button);
		panel.add(label);
		
	}
	
	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
					String input = text.getText();
					int numSide = Integer.parseInt(input);
					Random rand = new Random();
					int randNum = rand.nextInt(numSide) + 1;
					String newTetx = Integer.toString(randNum);
					label.setText(newTetx);
					System.out.println(newTetx);
					
				}
		};
		return listener;
	}
	
	public Component getContent()
	{
		return (panel);		
	}
	
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Dice Program");
		Dice roll = new Dice();
		frame.getContentPane().add(roll.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();		
	}
	
}
