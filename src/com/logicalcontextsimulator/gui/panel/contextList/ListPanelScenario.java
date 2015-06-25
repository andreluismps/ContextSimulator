/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.gui.panel.contextList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

import com.logicalcontextsimulator.model.renderer.MyListCellRenderer;

/**
 *
 * @author MHL
 */
public class ListPanelScenario extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -9103626667121639178L;
	private DefaultComboBoxModel listModel;

    /**
     * Creates new form LogicalContextList
     */
    public ListPanelScenario(DefaultComboBoxModel listModel) {
        this.listModel = listModel;
        
        initComponents();  
    }

    public JList getJListScenario() {
        return jListScenario;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spSituationGroupList = new javax.swing.JScrollPane();
        jListScenario = new javax.swing.JList();

        setLayout(new java.awt.BorderLayout());

        jListScenario.setModel(listModel);
        jListScenario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jListScenario.setCellRenderer(new MyListCellRenderer());
        spSituationGroupList.setViewportView(jListScenario);

        add(spSituationGroupList, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jListScenario;
    private javax.swing.JScrollPane spSituationGroupList;
    // End of variables declaration//GEN-END:variables
}
