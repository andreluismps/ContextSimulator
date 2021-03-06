/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.gui.panel.cardPanels;

import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.logicalcontextsimulator.util.Constants;

/**
 *
 * @author MHL
 */
public class ContextChoicePanel extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2961290019428838913L;

	private Border detachedBorder;
    
    private TitledBorder titleBorder;
    
    private CardLayout cardLayout;
    
    private String contextParent = Constants.PHYSICAL;
    
    /**
     * Creates new form ContextChoicePanel
     */
    public ContextChoicePanel() {
        cardLayout = new CardLayout();
 

        initComponents();
        
        jPanelContextSources.setLayout(cardLayout);
        
        titleBorder = BorderFactory.createTitledBorder(detachedBorder, "Physical Contexts");
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        jPanelContextSources.setBorder(titleBorder); 
        
       // jPanelContextSources.add(cardPhysicalContextSource);
       // jPanelContextSources.add(cardLogicalContextSource);
        
        //Situation are not displayed for logical context
        /*
        if(!contextParent.equals(Constants.LOGICAL)){
            jPanelContextSources.add(cardSituationListPanel);
        }
        
        if(contextParent.equals(Constants.SCENARIO)){
            jButtonAddContextSource.setVisible(false);
        }*/
    }
    

    public CardLayout getCardLayout() {
        return cardLayout;
    }
    
    public JButton getBtLeft() {
        return btLeft;
    }

    public JButton getBtRight() {
        return btRight;
    }
    
    public JButton getButtonAddContextSource() {
        return jButtonAddContextSource;
    }

    public JPanel getPanelContextSources() {
        return jPanelContextSources;
    }

    
    
  /*  
    public JComboBox getCbSituationGroup() {
        return cardSituationListPanel.getCbSituationGroup();
    }
    
    public JList getJListSituation() {
        return cardSituationListPanel.getJListSituation();
    }*/
    /*
    public JList getJListLogical(){
        return cardLogicalContextSource.getJListLogicalContext();
    }
    
    public JList getJListPhysical(){
        return cardPhysicalContextSource.getJListContextSource();
    }*/
    
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelButtonOverview4 = new javax.swing.JPanel();
        btRight = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButtonAddContextSource = new javax.swing.JButton();
        jPanelLeft = new javax.swing.JPanel();
        btLeft = new javax.swing.JButton();
        jPanelContextSources = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanelButtonOverview4.setLayout(new java.awt.BorderLayout());

        btRight.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_ARROW_RIGHT));
        jPanelButtonOverview4.add(btRight, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.PAGE_AXIS));

        jButtonAddContextSource.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_BUTTON_ADD));
        jPanel6.add(jButtonAddContextSource);

        jPanelButtonOverview4.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        add(jPanelButtonOverview4, java.awt.BorderLayout.EAST);

        jPanelLeft.setLayout(new java.awt.BorderLayout());

        btLeft.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_ARROW_LEFT));
        jPanelLeft.add(btLeft, java.awt.BorderLayout.NORTH);

        add(jPanelLeft, java.awt.BorderLayout.WEST);

        jPanelContextSources.setLayout(null);
        add(jPanelContextSources, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLeft;
    private javax.swing.JButton btRight;
    private javax.swing.JButton jButtonAddContextSource;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelButtonOverview4;
    private javax.swing.JPanel jPanelContextSources;
    private javax.swing.JPanel jPanelLeft;
    // End of variables declaration//GEN-END:variables
}
