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
public class HardDisk extends PhysicalContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2531644377220241996L;

	// Model
	private int value1;

	// GUI
	private transient JPanel panel;
	private transient JLabel jLabel1;
	private transient JTextField tfValue1;

	// TODO Rechtsbuendig
	public HardDisk() {
		super(Constants.DISK);

		// GUI
		initPanel();
	}

	private void initPanel() {
		panel = new JPanel();
		jLabel1 = new JLabel("Hard Disk Memory in MB:");
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
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter a correct value");
		}
	}

	public JPanel getPanel() {
		if (panel == null)
			initPanel();
		tfValue1.setText(String.valueOf(value1));
		return panel;
	}

	public String getTextAreaRepresentation() {
		if (panel == null)
			initPanel();
		StringBuilder sb = new StringBuilder(jLabel1.getText()).append(" ").append(value1);

		return sb.toString();
	}

	public String getCommand() {
		return "harddisk:" + value1;
	}

}
