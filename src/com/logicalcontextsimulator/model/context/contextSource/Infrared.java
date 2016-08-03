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
public class Infrared extends PhysicalContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = -209700603369259323L;

	// Model
	boolean value1 = false;

	// GUI
	private transient JPanel panel;
	private transient JLabel jLabel1;
	private transient JCheckBox cbValue1;

	// TODO Rechtsbuendig
	public Infrared() {
		super(Constants.INFRARED);

		// GUI
		initPanel();
	}

	private void initPanel() {
		panel = new JPanel();
		jLabel1 = new JLabel("Active Infrared-Connection:");
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
		if (panel == null)
			initPanel();
		return panel;
	}

	public String getTextAreaRepresentation() {
		StringBuilder sb = new StringBuilder(jLabel1.getText()).append(" ").append(value1);

		return sb.toString();
	}

	public String getCommand() {
		return "infrared:" + value1;
	}

}
