/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.context.contextSource;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.logicalcontextsimulator.model.context.PhysicalContext;
import com.logicalcontextsimulator.util.Constants;

/**
 * 
 * @author MHL
 */
public class USBCable extends PhysicalContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6364060773441832300L;

	// Model
	boolean value1;

	// GUI
	private transient JPanel panel;
	private transient JLabel jLabel1;
	private transient JCheckBox cbValue1;

	// TODO Rechtsbuendig
	public USBCable() {
		super(Constants.USBCABLE);

		// GUI
		initPanel();
	}

	private void initPanel() {
		panel = new JPanel();
		jLabel1 = new JLabel("USB-Cable connected:");
		cbValue1 = new JCheckBox();

		panel.setLayout(new GridLayout(3, 2, 0, 15));

		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(jLabel1);
		panel.add(cbValue1);
	}

	public void savePanel() {
		value1 = cbValue1.isSelected();
	}

	public JPanel getPanel() {
		cbValue1.setSelected(value1);
		return panel;
	}

	public String getTextAreaRepresentation() {
		if (panel == null)
			initPanel();
		StringBuilder sb = new StringBuilder(jLabel1.getText()).append(" ").append(value1);

		return sb.toString();
	}

	public String getCommand() {
		return "usb:" + value1;
	}

}
