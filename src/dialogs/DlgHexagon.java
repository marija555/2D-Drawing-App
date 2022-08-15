package dialogs;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class DlgHexagon extends JDialog implements ActionListener, KeyListener {

	
	private static final long serialVersionUID = 1L;
	private final JTextField textFieldX = new JTextField();
	private final JTextField textFieldY = new JTextField();
	private final JButton btnAccept = new JButton("Accept");
	private final JButton btnDecline = new JButton("Decline");
	private final JButton btnOuterColor = new JButton("");
	private final JLabel lbOuterColor = new JLabel("Outer Color");
	private final JButton btnInnerColor = new JButton("");
	private final JLabel lbInnerColor = new JLabel("Inner Color");
	private final JLabel lbXCoord = new JLabel("X Coordinate:");
	private final JLabel lbYCoord = new JLabel("Y Coordinate:");
	private final JLabel lbRadius = new JLabel("Radius:");
	private final JTextField textFieldRadius = new JTextField();

	public JTextField getTextFieldRadius() {
		return textFieldRadius;
	}

	private boolean accepted = false;

	public DlgHexagon(int x, int y, Color innerColor, Color outerColor) {

		setTitle("Hexagon Dialog");
		setSize(300, 300);
		setLocationRelativeTo(null); 
		setModal(true);

		JPanel mainPanel = new JPanel(new GridLayout(0,2,5,5));

		textFieldX.setText(Integer.toString(x));
		textFieldY.setText(Integer.toString(y));
		btnInnerColor.setBackground(innerColor);
		btnOuterColor.setBackground(outerColor);

		mainPanel.add(lbXCoord);
		mainPanel.add(textFieldX);
		mainPanel.add(lbYCoord);
		mainPanel.add(textFieldY);
		mainPanel.add(lbRadius);
		mainPanel.add(textFieldRadius);
		mainPanel.add(lbInnerColor);
		mainPanel.add(btnInnerColor);
		mainPanel.add(lbOuterColor);
		mainPanel.add(btnOuterColor);
		mainPanel.add(btnAccept);
		mainPanel.add(btnDecline);

		btnInnerColor.addActionListener(this);
		btnOuterColor.addActionListener(this);
		btnAccept.addActionListener(this);
		btnDecline.addActionListener(this);
		textFieldRadius.addKeyListener(this);

		getContentPane().add(mainPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOuterColor) {
			Color outerColor = JColorChooser.showDialog(this, "Choose your outer color", Color.BLACK);
			btnOuterColor.setBackground(outerColor);
		}
		else if(e.getSource() == btnInnerColor) {
			Color innerColor = JColorChooser.showDialog(this, "Choose your inner color", Color.RED);
			btnInnerColor.setBackground(innerColor);
		}
		else if(e.getSource() == btnAccept) {
			accepted = true;
			dispose();
		}
		else if(e.getSource() == btnDecline) {
			dispose();
		}

	}

	public JTextField getTextFieldX() {
		return textFieldX;
	}

	public JTextField getTextFieldY() {
		return textFieldY;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public JButton getBtnOuterColor() {
		return btnOuterColor;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
			getToolkit().beep();
			e.consume();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}


}