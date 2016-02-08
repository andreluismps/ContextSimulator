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

import com.logicalcontextsimulator.connection.interfaces.TelnetConnectable;
import com.logicalcontextsimulator.model.context.PhysicalContext;
import com.logicalcontextsimulator.util.Constants;

/**
 *
 * @author MHL
 */
public class GPS extends PhysicalContext implements TelnetConnectable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -2796409290683390549L;

	//Model
    private double latitude, longitude, altitude;
    
    //GUI
    private transient JPanel panel;
    private transient JLabel jLabel1;
    private transient JTextField tfLatitude;
    private transient JLabel jLabel2;
    private transient JTextField tfLongitude;
    private transient JLabel jLabel3;
    private transient JTextField tfAltitude;
    
    public GPS(){
        super(Constants.GPS);
        /*
        //Model
        latitude = 0;
        longitude = 0;
        altitude = 0;
        */
        //GUI
        panel = new JPanel();
        jLabel1 = new JLabel("Latitude:");
        tfLatitude = new JTextField();
        jLabel2 = new JLabel("Longitude:");
        tfLongitude = new JTextField();
        jLabel3 = new JLabel("Altitude:");
        tfAltitude = new JTextField();
        
        panel.setLayout(new GridLayout(3, 2, 0, 15));

        panel.add(jLabel1);
        panel.add(tfLatitude);

        panel.add(jLabel2);
        panel.add(tfLongitude);

        panel.add(jLabel3);
        panel.add(tfAltitude);
        
    }
    
    public void savePanel(){
        try{
            latitude = Double.valueOf(tfLatitude.getText());
            longitude = Double.valueOf(tfLongitude.getText());
            altitude = Double.valueOf(tfAltitude.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter a correct value");
        }
    }
    
	public JPanel getPanel() {
		tfLatitude.setText(String.valueOf(latitude));
		tfLongitude.setText(String.valueOf(longitude));
		tfAltitude.setText(String.valueOf(altitude));
		return panel;
	}
    
    public String getTextAreaRepresentation(){
        StringBuilder sb = new StringBuilder(getName());
        sb = sb.append(": ").append(latitude).append(", ").append(longitude).append(", ").append(altitude);
        
        return sb.toString();
    }
    
    @Override
    public String getCommand(){
        return "geo fix " + longitude + " " + latitude + " "
                    + altitude;
    }
    
}
