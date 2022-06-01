import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.BitSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JTextArea instructionTxt;
	private static CPU cpu;
	private JButton executeBtn;
	private JButton clearInsButton;
	public static FileWriter fileWriter;
	public static String console_out;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
					centreWindow(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		setFont(new Font("Arial", Font.BOLD, 12));
		setTitle("CPU Simulation");
		console_out = "";
		createCPU();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		instructionTxt = new JTextArea();
		instructionTxt.setBounds(12, 13, 124, 394);
		contentPane.add(instructionTxt);
		instructionTxt.setColumns(17);
		instructionTxt.setLineWrap(true);
		//instructionTxt.setWrapStyleWord(true);
		instructionTxt.setFont(new Font("monospaced", Font.PLAIN, 12));
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		instructionTxt.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	    
//		JButton loadBtn = new JButton("Load Instructions");
//		loadBtn.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(ActionEvent arg0) 
//			{
////				String instructions = instructionTxt.getText();
////			    String[] res = instructions.split("[\n]", 0);
////			    for (int i = 0; i < res.length; i++) {
////			    	cpu.addInstruction(res[i]);
////				}
//				
//			}
//		});
//		loadBtn.setBounds(166, 201, 162, 25);
//		contentPane.add(loadBtn);
		
		executeBtn = new JButton("Execute the Program");
		executeBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		executeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String instructions = instructionTxt.getText();
			    String[] res = instructions.split("[\n]", 0);
			    for (int i = 0; i < res.length; i++) {
			    	cpu.addInstruction(res[i]);
				}
				if(checkInstructionValidity(res) == true && cpu.insf.getInstructions().size() > 0 && instructionTxt.getText().length() > 0)
				{
					cpu.runTheProgram();
					createFileWriter();
					JOptionPane.showMessageDialog(contentPane, "Instructions Performed Successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "Please Enter Valid Instructions");
					cpu.insf.ClearInstructions();
				}
			}
		});
		executeBtn.setBounds(176, 194, 180, 44);
		contentPane.add(executeBtn);
		
		JButton clearCPUButton = new JButton("Clear CPU");
		clearCPUButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		clearCPUButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				cpu = new CPU();
				System.out.println("CPU HAS BEEN CLEARED");
				JOptionPane.showMessageDialog(contentPane, "CPU HAS BEEN CLEARED");
			}
		});
		clearCPUButton.setBounds(350, 15, 152, 30);
		contentPane.add(clearCPUButton);
		
		clearInsButton = new JButton("Clear Text Area");
		clearInsButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		clearInsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				instructionTxt.setText("");
				System.out.println("INSTRUCTION TEXT AREA HAS BEEN CLEARED");
				JOptionPane.showMessageDialog(contentPane, "INSTRUCTION TEXT AREA HAS BEEN CLEARED");
			}
		});
		clearInsButton.setBounds(176, 15, 152, 30);
		contentPane.add(clearInsButton);
		
		JLabel lblNewLabel = new JLabel("<html>Enter the Instructions on the text area and execute the program. <br><br>You can clear the Cpu and text area by clear buttons.</html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(459, 132, 180, 108);
		contentPane.add(lblNewLabel);
		

	}
	
	private void createCPU()
	{
		cpu = new CPU();
	}
	
	private void createFileWriter()
	{
		
		try {
			fileWriter = new FileWriter("console_output_file.txt");
			fileWriter.write(console_out);
			fileWriter.close();
			//System.out.println("Console_output_file.txt created sucessfully with " + console_out.length() + " Number of characters");
			console_out = "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	
	private boolean checkInstructionValidity(String[] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].length() != 16)
			{
				return false;
			}
		}
		return true;
	}
}
