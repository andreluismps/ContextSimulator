/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.gui.panel;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author MHL
 */
public class TestCaseTabPanel extends javax.swing.JPanel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -7933840010612033919L;
	/**
     * Creates new form PhysicalPanel
     */
    public TestCaseTabPanel() {
        initComponents();
    }

    public JPanel getjPanelDown() {
        return jPanelDown;
    }

    public JPanel getjPanelUp() {
        return jPanelUp;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelUp = new javax.swing.JPanel();
        jPanelDown = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        jPanelUp.setLayout(new java.awt.BorderLayout());
        add(jPanelUp);

        jPanelDown.setLayout(new java.awt.BorderLayout());
        add(jPanelDown);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelDown;
    private javax.swing.JPanel jPanelUp;
    // End of variables declaration//GEN-END:variables
}
