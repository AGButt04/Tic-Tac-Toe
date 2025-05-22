import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {
	
	public static void main(String[] args) {
		new TicTacToe();
	}
	
	private JButton[] buttons;
	private char turn = 'X';
	
	public TicTacToe() {
		buildWindow();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton b = (JButton) event.getSource(); //actual thing you clicked on.
		if (b.getText().equals(" ")) {
			b.setText(turn + "");
			if (turn == 'X')
				turn = 'O';
			else
				turn = 'X';
		}
	}
	
	private void buildWindow() {
		this.setTitle("Tic-Tac-Toe"); //Gives a list with this.
		this.setLayout(new GridLayout(3,3,10,10)); //Specifies 3X3 grid layout, 10 pixels in between the X blocks, the gap beside and beneath
		
		buttons = new JButton[9];
		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton(" ");
			buttons[i].addActionListener(this); //Register this class as the action listener.
			buttons[i].setFont(new Font(null,Font.BOLD,64)); //Name, style (bold, italics), size.
			buttons[i].setForeground(Color.orange); //Change color of the X.
			
			if (i % 2 == 0)
				buttons[i].setBackground(new Color(0xff69b4)); //ff69b4 (hot pink)
			else
				buttons[i].setBackground(Color.red);
			
			add(buttons[i]); //Add button to window
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exits the program when you hit x on console, can do anything with this.
		setSize(500,500);
		setLocationRelativeTo(null); //Center window 
		setVisible(true); //Make window appear
		
	}

}
