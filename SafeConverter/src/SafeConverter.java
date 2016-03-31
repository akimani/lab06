import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.BorderLayout;

class SafeConverter 
{
	private JPanel panel;
	private JButton button;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JTextField text;
	private JLabel label;

	
	public SafeConverter()
	{
		
		panel = new JPanel(new GridLayout(8,0));
		text = new JTextField(3);
		label = new JLabel("Enter a temperature ");
		button = new JButton("Convert C to F");
		button2 = new JButton("Convert F to C");
		button3 = new JButton("Convert C to K");
		button4 = new JButton("Convert F to K");
		button5 = new JButton("Convert K to C");
		button6 = new JButton("Convert K to F");
		
		//Load the listeners
		button.addActionListener(buttonListener());			
		button2.addActionListener(buttonListener());	
		button3.addActionListener(buttonListener());	
		button4.addActionListener(buttonListener());	
		button5.addActionListener(buttonListener());
		button6.addActionListener(buttonListener());	
		
		//load the panel
		panel.add(text);
		panel.add(label);		
		panel.add(button);		
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		
		
		//panel.add(label);
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
				String action = e.getActionCommand();
								
				
				String msg = "";
				if(input.length() < 1)
				{
					msg = "A value must be entered!!";				
				}
				else
				{
					try
					{
						double temp = Double.parseDouble(input);//convert String to double
						if(action.equals("Convert C to F"))						
							msg = String.format("%.2f",cToF(temp));
						else if(action.equals("Convert F to C"))
							msg = String.format("%.2f",fToC(temp));
						else if(action.equals("Convert C to K"))
							msg = String.format("%.2f",cToK(temp));
						else if(action.equals("Convert F to K"))
							msg = String.format("%.2f",fToK(temp));
						else if(action.equals("Convert K to C"))
							msg = String.format("%.2f",kToC(temp));
						else if(action.equals("Convert K to F"))
							msg = String.format("%.2f",kToF(temp));
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
		return cToK(fToC(temp));
	}
	
	private double cToK(double temp)
	{
		return temp + 273.15;
	}
	
	private double kToC(double temp)
	{
		return temp - 273.15;
	}
	
	private double  kToF(double temp)
	{
		return cToF(kToC(temp));
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}
