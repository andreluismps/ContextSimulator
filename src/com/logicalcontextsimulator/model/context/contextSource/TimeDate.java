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
public class TimeDate extends PhysicalContext{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3629033123060687135L;

	//Model
    private String time, date;
    
    //GUI
    private transient JPanel panel;
    private transient JLabel jLabel1;
    private transient JTextField tfTime;
    private transient JLabel jLabel2;
    private transient JTextField tfDate;
    
    public TimeDate(){
        super(Constants.TIMEDATE);
        
        //Model
        time = "00:00:00";
        date = "01.01.2014";
        
        //GUI
        panel = new JPanel();
        jLabel1 = new JLabel("Time (hh:mm:ss):");
        tfTime = new JTextField(time);
        jLabel2 = new JLabel("Date (dd.mm.yyyy):");
        tfDate = new JTextField(date);
        
        panel.setLayout(new GridLayout(3, 2, 0, 15));

        panel.add(jLabel1);
        panel.add(tfTime);

        panel.add(jLabel2);
        panel.add(tfDate);
    }
    
    public void savePanel(){
        time = tfTime.getText();
        date = tfDate.getText();
    }
    
    public JPanel getPanel(){
       return panel;
    }
    
    public String getTextAreaRepresentation(){
        StringBuilder sb = new StringBuilder(getName());
        sb = sb.append(": ").append(time).append(", ").append(date);
        
        return sb.toString();
    }
    
        @Override
    public String getCommand(){
        return "date-"+date+"-"+time;
    }
    
}
