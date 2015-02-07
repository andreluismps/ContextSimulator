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
public class MyListCellRenderer extends JPanel implements ListCellRenderer
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2971834262257704518L;
	private JLabel label = null;
 
    public MyListCellRenderer()
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
        label.setText(value.toString());

       // Hintergrundfarbe des JPanels bei Fokuswechseln definieren
        if(iss) setBackground(Color.lightGray); // Hat den Fokus
        else setBackground(list.getBackground()); // Hat den Fokus nicht
 
        return this;
    }
}