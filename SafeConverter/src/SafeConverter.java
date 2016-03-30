import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class SafeConverter 
{
	private JPanel panel;
	private JButton button;
	private JButton button2;
	private JButton button3;
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
						msg = String.format("%.2f",fToK(tempInF));//convert double to String and
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
	
	private double fToC(double temp)
	{
		return (temp - 32)*5.0/9;
	}
	
	private double cToF(double temp)
	{
		return temp*9.0/5+32;
	}
	
	private double fToK(double temp)
	{
		return fToC(temp) + 273.15;
	}
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}
