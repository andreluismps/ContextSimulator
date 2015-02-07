/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author MHL
 */
public class MyListIconCellRenderer extends JPanel implements ListCellRenderer
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7933262658679637606L;
	private JLabel label = null;
 
    public MyListIconCellRenderer()
    {
        // Konstruktor des JPanels mit FlowLayout aufrufen
        super(new FlowLayout(FlowLayout.LEFT));
 
        // JPanel undurchsichtig machen
           setOpaque(true);
 
        // JLabel instanzieren, durchsichtig machen und hinzufügen    
        label = new JLabel();
        label.setOpaque(false);
        add(label);                
    }
 
    public Component getListCellRendererComponent(JList list, // JList Objekt
                                                  Object value, // anzuzeigende Komponente
                                                  int index,    // Zellenindex
                                                  boolean iss,  // Ist selektiert?
                                                  boolean chf)  // Hat den Fokus?
    {
        // JLabel das Icon aus unserem MyListItem zuweisen
        label.setIcon(((ContextListItem)value).getIcon());
        //label.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_LIST_MICROPHONE));
        // JLabel den Text aus unserem MyListItem zuweisen
        label.setText(((ContextListItem)value).getName());
        //label.setText("Accelerometer");
       // Hintergrundfarbe des JPanels bei Fokuswechseln definieren
        if(iss) setBackground(Color.lightGray); // Hat den Fokus
        else setBackground(list.getBackground()); // Hat den Fokus nicht
 
        return this;
    }
}