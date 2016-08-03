/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.context.contextSource;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.logicalcontextsimulator.model.context.PhysicalContext;
import com.logicalcontextsimulator.util.Constants;

/**
 * 
 * @author MHL
 */
public class WiFi extends PhysicalContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = -894979986671295654L;
	// Model
	private boolean value1;
	private String value2;

	// GUI
	private transient JPanel panel;
	private transient JLabel jLabel1;
	private transient JCheckBox cbValue1;
	private transient JLabel jLabel2;
	private transient JTextField jTextField1;

	// TODO Rechtsbuendig
	public WiFi() {
		super(Constants.WIFI);

		// GUI
		initPanel();
	}

	public void savePanel() {
		value1 = cbValue1.isSelected();
		value2 = jTextField1.getText();
	}

	public JPanel getPanel() {
		if (panel == null)
			initPanel();

		jTextField1.setText(value2);
		cbValue1.setSelected(value1);
		return panel;
	}

	private void initPanel() {
		panel = new JPanel();
		jLabel1 = new JLabel("Wi-Fi available:");
		cbValue1 = new JCheckBox();
		cbValue1.setSelected(value1);
		jLabel2 = new JLabel("SSID: ");
		jTextField1 = new JTextField();
		panel.setLayout(new GridLayout(3, 2, 0, 15));

		panel.add(jLabel1);
		panel.add(cbValue1);
		panel.add(jLabel2);
		panel.add(jTextField1);
	}

	public String getTextAreaRepresentation() {
		if (panel == null)
			initPanel();
		StringBuilder sb = new StringBuilder(jLabel1.getText()).append(" ").append(value1).append(", SSID: ").append(value2);

		return sb.toString();
	}

	public String getCommand() {
		return "wifi:" + value1 + ":" + value2;
	}

}
