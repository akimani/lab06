import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class VotingSystem extends JFrame implements ActionListener
{
	private JTextField fName;
	private JTextField lName;
	private JLabel firstName;
	
	private Scanner inputStream;
	private PrintWriter outputStream;
	private String FileName;
	public VotingSystem()
	{
		
		
		setSize(600,300);
		setTitle("Voting System");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		
		JPanel messagePanel = new JPanel();
		firstName = new JLabel("Enter First Name, Last Name and choose a candidate");
		messagePanel.add(firstName);
		
		contentPane.add(messagePanel,BorderLayout.NORTH);
		
		
		
		JPanel textPanel = new JPanel();
		fName = new JTextField(15);
		lName = new JTextField(15);
		textPanel.add(fName);
		textPanel.add(lName);
		contentPane.add(textPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton candidate1 = new JButton("Candidate 1");
		candidate1.addActionListener(this);
		buttonPanel.add(candidate1);
		
		JButton candidate2 = new JButton("Candidate 2");
		candidate2.addActionListener(this);
		buttonPanel.add(candidate2);
		
		JButton candidate3 = new JButton("Candidate 3");
		candidate3.addActionListener(this);
		buttonPanel.add(candidate3);
		
		JButton candidate4 = new JButton("Candidate 4");
		candidate4.addActionListener(this);
		buttonPanel.add(candidate4);		
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(this);
		buttonPanel.add(reset);

		contentPane.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	private void castVote(String Candidate)
	{
		try
		{
			inputStream = new Scanner(new File(FileName));
			String line = inputStream.nextLine();
			firstName.setText("You have already voted for " + line);
			inputStream.close();
		}
		
		catch(FileNotFoundException e2)
		{
			//means havent voted yet so create a file
			try
			{
				outputStream = new PrintWriter(FileName);
				outputStream.println(Candidate);
				outputStream.close();
			}
			catch(FileNotFoundException e3)
			{
				firstName.setText("Error, did not save the file");
			}
			firstName.setText("Congratulations for voting");
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();
		FileName = lName.getText() + "_" + fName.getText() + ".txt";
		if(lName.getText().length() < 1 || fName.getText().length() < 1)
		{
			firstName.setText("Must enter your Fist Name and last Name before choosing a Candidate");
			if(action.equals("Reset"))
				firstName.setText("Enter First Name, Last Name and choose a candidate");
		}
		else
		{
			if(action.equals("Candidate 1"))
			{
				castVote("Candidate 1");
			}
			else if(action.equals("Candidate 2"))
			{
				castVote("Candidate 2");
			}
			else if(action.equals("Candidate 3"))
			{
				castVote("Candidate 3");
			}
			else if(action.equals("Candidate 4"))
			{
				castVote("Candidate 4");
			}
			else if(action.equals("Reset"))
			{
				firstName.setText("Enter First Name, Last Name and choose a candidate");
				fName.setText("");
				lName.setText("");
			}
		}
		
	}
	public static void main(String[] args)
	{
		VotingSystem vote = new VotingSystem();
		vote.setVisible(true);
		vote.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
