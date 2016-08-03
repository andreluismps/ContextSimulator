/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.context.contextSource;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.logicalcontextsimulator.connection.interfaces.TelnetConnectable;
import com.logicalcontextsimulator.model.context.PhysicalContext;
import com.logicalcontextsimulator.util.Constants;

/**
 * 
 * @author MHL
 */
public class NetworkConnection extends PhysicalContext implements TelnetConnectable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1593910932474472258L;
	// Model
	private boolean value1 = true;
	private boolean value2 = false;
	private boolean value3 = false;
	private boolean value4 = false;
	private boolean value5 = false;
	private boolean value6 = false;

	// GUI
	private transient JPanel panel;
	private transient ButtonGroup btGroup;
	private transient JRadioButton rbValue1;
	private transient JRadioButton rbValue2;
	private transient JRadioButton rbValue3;
	private transient JRadioButton rbValue4;
	private transient JRadioButton rbValue5;
	private transient JRadioButton rbValue6;
  
    
    /*
gsm 	GSM/CSD	(Up: 14.4, down: 14.4)
edge 	EDGE/EGPRS 	(Up: 118.4, down: 236.8)
umts 	UMTS/3G	(Up: 128.0, down: 1920.0)
hsdpa 	HSDPA	(Up: 348.0, down: 14400.0)
full
    */
    
    
	// TODO Rechtsbuendig
	public NetworkConnection() {
		super(Constants.NETWORK);

		// GUI
		initPanel();
	}

	private void initPanel() {
		rbValue1 = new JRadioButton("None", value1);
		rbValue2 = new JRadioButton("GSM", value2);
		rbValue3 = new JRadioButton("EDGE", value3);
		rbValue4 = new JRadioButton("UMTS", value4);
		rbValue5 = new JRadioButton("HSDPA", value5);
		rbValue6 = new JRadioButton("Full", value6);

		btGroup = new ButtonGroup();
		btGroup.add(rbValue1);
		btGroup.add(rbValue2);
		btGroup.add(rbValue3);
		btGroup.add(rbValue4);
		btGroup.add(rbValue5);
		btGroup.add(rbValue6);

		panel = new JPanel();

		panel.setLayout(new GridLayout(2, 3, 4, 15));

		panel.add(rbValue1);
		panel.add(rbValue2);
		panel.add(rbValue3);
		panel.add(rbValue4);
		panel.add(rbValue5);
		panel.add(rbValue6);
	}

	@Override
	public void savePanel() {
		value1 = rbValue1.isSelected();
		value2 = rbValue2.isSelected();
		value3 = rbValue3.isSelected();
		value4 = rbValue4.isSelected();
		value5 = rbValue5.isSelected();
		value6 = rbValue6.isSelected();
	}

	@Override
	public JPanel getPanel() {
		if (panel == null)
			initPanel();
		return panel;
	}

	@Override
	public String getTextAreaRepresentation() {
		if (panel == null)
			initPanel();
		StringBuilder sb = new StringBuilder("Network Connection: ").append(getNetworkSpeed());

		return sb.toString();
	}

	private String getNetworkSpeed() {
		if (value1) {
			return "0 0";
		} else if (value2) {
			return "GSM";
		} else if (value3) {
			return "EDGE";
		} else if (value4) {
			return "UMTS";
		} else if (value5) {
			return "HSDPA";
		} else {
			return "FULL";
		}
	}

	@Override
	public String getCommand() {
		return "network speed " + getNetworkSpeed().toLowerCase();
	}
}
