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
					String newText = "";
					//Test the input to make sure is positive integer
					try
					{
						int numSide = Integer.parseInt(input);
						if(numSide < 1 )
						{
							newText = "Invalid input, must be atleast 1";
						}
						else
						{
							newText = Integer.toString(drawRandom(numSide));
						}
					}
					catch(NumberFormatException exception)
					{
						newText = "Invalid input, must be an integer";
					}					
					 
					label.setText(newText);
					System.out.println(newText);
					
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private int drawRandom(int num)
	{
		Random rand = new Random();
		return rand.nextInt(num) + 1;
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();		
	}
	
}
