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




public class VotingSystem extends JFrame implements ActionListener
{
	private JTextField fName;
	private JTextField lName;
	private JLabel midLabel;
	private JLabel firstName;
	private JLabel lastName;
	
	
	public VotingSystem()
	{
		
		
		//addWindowListener(new WindowDestroyer());
		setSize(600,300);
		setTitle("Voting System");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		
		JPanel messagePanel = new JPanel();
		firstName = new JLabel("Enter First Name");
		lastName = new JLabel("Enter Last Name");
		midLabel = new JLabel("Choose a candidate");
		messagePanel.add(firstName);
		messagePanel.add(lastName);
		//messagePanel.add(topLabel);
		contentPane.add(messagePanel,BorderLayout.NORTH);
		
		JPanel textPanel = new JPanel();
		fName = new JTextField(15);
		lName = new JTextField(15);
		textPanel.add(fName);
		textPanel.add(lName);
		//textPanel.add(midLabel,BorderLayout.NORTH);
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

		contentPane.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();
		if(action.equals("Candidate 1"))
		{
			
		}
		else if(action.equals("Candidate 2"))
		{
			
		}
		else if(action.equals("Candidate 3"))
		{
			
		}
		else if(action.equals("Candidate 4"))
		{
			
		}
	}
	public static void main(String[] args)
	{
		VotingSystem vote = new VotingSystem();
		vote.setVisible(true);
		vote.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
