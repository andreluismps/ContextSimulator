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
public class Calendar extends PhysicalContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4598288158432074459L;
	// Model
	private String appointmentName;
	private String startTime;
	private String endTime;
	private String date;

	// GUI
	private transient JPanel panel;
	private transient JLabel jLabel1;
	private transient JTextField tfAppointmentName;
	private transient JLabel jLabel2;
	private transient JTextField tfStartTime;
	private transient JLabel jLabel3;
	private transient JTextField tfEndTime;
	private transient JLabel jLabel4;
	private transient JTextField tfDate;

	public Calendar() {
		super(Constants.CALENDAR);
		/*
		 * //Model appointmentName = "Meeting 1"; 
		 * startTime = "08:00"; 
		 * endTime = "09:00"; 
		 * date = "30.04.2014";
		 */
		// GUI
		initPanel();

	}

	private void initPanel() {
		panel = new JPanel();
		jLabel1 = new JLabel("Appointment Name:");
		jLabel2 = new JLabel("Start (hh:mm:ss):");
		jLabel3 = new JLabel("End (hh:mm:ss):");
		jLabel4 = new JLabel("Date (dd.mm.yyyy):");
		tfAppointmentName = new JTextField(appointmentName);
		tfStartTime = new JTextField(startTime);
		tfEndTime = new JTextField(endTime);
		tfDate = new JTextField(date);

		panel.setLayout(new GridLayout(4, 2, 0, 8));

		panel.add(jLabel1);
		panel.add(tfAppointmentName);

		panel.add(jLabel4);
		panel.add(tfDate);

		panel.add(jLabel2);
		panel.add(tfStartTime);

		panel.add(jLabel3);
		panel.add(tfEndTime);
	}

	public void savePanel() {
		appointmentName = tfAppointmentName.getText();
		startTime = tfStartTime.getText();
		endTime = tfEndTime.getText();
		date = tfDate.getText();
	}

	public JPanel getPanel() {
		if (panel == null)
			initPanel();
		tfAppointmentName.setText(appointmentName);
		tfStartTime.setText(startTime);
		tfEndTime.setText(endTime);
		tfDate.setText(date);
		return panel;
	}

	public String getTextAreaRepresentation() {
		if (panel == null)
			initPanel();
		StringBuilder sb = new StringBuilder(getName());
		sb = sb.append(": ").append(appointmentName).append(", Date: ").append(date).append(", Start: ").append(startTime).append(", End: ").append(endTime);

		return sb.toString();
	}

	@Override
	public String getCommand() {
		return "app-" + date + "-" + startTime + "-" + endTime;
	}

}
