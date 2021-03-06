/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.gui.panel.contextList;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.logicalcontextsimulator.util.Constants;

/**
 *
 * @author MHL
 */
public class TransmissionPanel extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1627417699559344328L;
	/**
     * Creates new form ScenarioPanel
     */
    public TransmissionPanel() {
        initComponents();
    }

    public JPanel getPanelScenarioTable() {
        return panelScenarioTable;
    }

    public JButton getBtPlay() {
        return btPlay;
    }
    
    
    
    

    public javax.swing.JButton getBtClear() {
		return btClear;
	}

	public void setBtClear(javax.swing.JButton btClear) {
		this.btClear = btClear;
	}

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btPlay = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelScenarioTable = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        btPlay.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_PLAY));
        jPanel4.add(btPlay, java.awt.BorderLayout.NORTH);
        btClear.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_BUTTON_DELETE));
        jPanel4.add(btClear, java.awt.BorderLayout.SOUTH);

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jLabel1.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_PC));
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        add(jPanel1, java.awt.BorderLayout.WEST);

        panelScenarioTable.setPreferredSize(new java.awt.Dimension(367, 320));
        panelScenarioTable.setLayout(new java.awt.BorderLayout());
        add(panelScenarioTable, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel2.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_CELLPHONE));
        jPanel3.add(jLabel2, java.awt.BorderLayout.PAGE_END);

        add(jPanel3, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPlay;
    private javax.swing.JButton btClear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelScenarioTable;
    // End of variables declaration//GEN-END:variables
}
