/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.context.contextSource;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.logicalcontextsimulator.model.context.PhysicalContext;
import com.logicalcontextsimulator.util.Constants;

/**
 * 
 * @author MHL
 */
public class Magnetometer extends PhysicalContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2197172832081432200L;
	// Model
	private double value1;
	private double value2;
	private double value3;

	// GUI
	private transient JPanel panel;
	private transient JLabel jLabel1;
	private transient JTextField tf1;
	private transient JLabel jLabel2;
	private transient JTextField tf2;
	private transient JLabel jLabel3;
	private transient JTextField tf3;

	public Magnetometer() {
		super(Constants.MAGNETOMETER);

		// Model
		value1 = 0;
		value2 = 0;
		value3 = 0;

		// GUI
		initPanel();
	}

	private void initPanel() {
		panel = new JPanel();
		jLabel1 = new JLabel("X-Axis:");
		jLabel2 = new JLabel("Y-Axis:");
		jLabel3 = new JLabel("Z-Axis:");
		tf1 = new JTextField(String.valueOf(value1));
		tf2 = new JTextField(String.valueOf(value2));
		tf3 = new JTextField(String.valueOf(value3));

		panel.setLayout(new GridLayout(3, 2, 0, 15));

		panel.add(jLabel1);
		panel.add(tf1);

		panel.add(jLabel2);
		panel.add(tf2);

		panel.add(jLabel3);
		panel.add(tf3);
	}

	public void savePanel() {
		value1 = Double.parseDouble(tf1.getText());
		value2 = Double.parseDouble(tf2.getText());
		value3 = Double.parseDouble(tf3.getText());
	}

	public JPanel getPanel() {
		if (panel == null)
			initPanel();
		return panel;
	}

	public String getTextAreaRepresentation() {
		if (panel == null)
			initPanel();
		StringBuilder sb = new StringBuilder(getName());
		sb = sb.append(": ").append(value1).append(", ").append(value2).append(", ").append(value3);

		return sb.toString();
	}

}
