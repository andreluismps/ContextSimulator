/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.context.contextSource;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.logicalcontextsimulator.model.context.PhysicalContext;
import com.logicalcontextsimulator.util.Constants;

/**
 * 
 * @author MHL
 */
public class Barometer extends PhysicalContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8793645815819328918L;

	// Model
	private int value1;

	// GUI
	private transient JPanel panel;
	private transient JLabel jLabel1;
	private transient JTextField tfValue1;

	// TODO Rechtsbuendig
	public Barometer() {
		super(Constants.BAROMETER);

		// Model
		value1 = 50;

		// GUI
		initPanel();
	}

	private void initPanel() {
		panel = new JPanel();
		jLabel1 = new JLabel("Barometer in hPa:");
		tfValue1 = new JTextField(String.valueOf(value1));

		panel.setLayout(new GridLayout(3, 2, 0, 15));

		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(jLabel1);
		panel.add(tfValue1);
	}

	public void savePanel() {
		try {
			value1 = Integer.parseInt(tfValue1.getText());

			if (value1 > 100 || value1 < 0) {
				JOptionPane.showMessageDialog(null, "Please enter a correct value");
				value1 = 100;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter a correct value");
		}
	}

	public JPanel getPanel() {
		if (panel == null)
			initPanel();
		return panel;
	}

	public String getTextAreaRepresentation() {
		if (panel == null)
			initPanel();
		StringBuilder sb = new StringBuilder(jLabel1.getText()).append(" ").append(value1);

		return sb.toString();
	}

	public String getCommand() {
		return "barometer:" + value1;
	}

}
