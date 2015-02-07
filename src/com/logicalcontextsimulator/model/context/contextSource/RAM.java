/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.context.contextSource;

import com.logicalcontextsimulator.model.context.PhysicalContext;
import com.logicalcontextsimulator.util.Constants;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author MHL
 */
public class RAM extends PhysicalContext{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4131785591185834361L;

	//Model
    private int value1;
    
    //GUI
    private JPanel panel;
    private JLabel jLabel1;
    private JTextField tfValue1;
    
    //TODO Rechtsbuendig
    public RAM(){
        super(Constants.RAM);
        
        //Model
        value1 = 50;
        
        //GUI
        panel = new JPanel();
        jLabel1 = new JLabel("RAM Memory in MB:");
        tfValue1 = new JTextField(String.valueOf(value1));
        
        panel.setLayout(new GridLayout(3, 2, 0, 15));

        panel.add(new JLabel());
        panel.add(new JLabel());     
        panel.add(jLabel1);
        panel.add(tfValue1);
    }
    
    public void savePanel(){
        try{
            value1 = Integer.parseInt(tfValue1.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter a correct value");
        }
    }
    
    public JPanel getPanel(){
       return panel;
    }
    
    public String getTextAreaRepresentation(){
        StringBuilder sb = new StringBuilder(jLabel1.getText()).append(" ").append(value1);

        return sb.toString();
    }
    
    public String getCommand(){
        return "ram:"+value1;
    }
    
}
