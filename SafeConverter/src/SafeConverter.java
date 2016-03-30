import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class SafeConverter 
{
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel label;
	
	public SafeConverter()
	{
		panel = new JPanel();
		button = new JButton("Convert");
		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter a temperature from F to C");
		
		//Load the listener
		button.addActionListener(buttonListener());	
		
		//load the panel
		panel.add(text);
		panel.add(button);
		panel.add(label);
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				
				String msg = "";
				if(input.length() < 1)
				{
					msg = "A value must be entered!!";				
				}
				else
				{
					try
					{
						double tempInF = Double.parseDouble(input);//convert String to double
						double tempInC = (tempInF-32)*(5.0/9.0); //convert F to C
						msg = "Temp in C: " + String.format("%.2f",tempInC);//convert double to String and
					       //only display 2 places past decimal
					}
					catch(Exception exception)
					{
						msg = "Invalid input";
					}
										
				}
				
				label.setText(msg);
				System.out.println(msg);
			}
		};
		
		return listener;
	}
	
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Temperature Converter");
		SafeConverter demo = new SafeConverter();
		
		frame.getContentPane().add(demo.getContent());
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}
