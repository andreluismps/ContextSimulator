/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.gui.panel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.logicalcontextsimulator.util.Constants;

/**
 *
 * @author MHL
 */
public class SimulatorTabPanel extends javax.swing.JPanel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -7374368561148584478L;

	private Border detachedBorder;
    
    private TitledBorder titleBorder;
   
    
    
    /**
     * Creates new form TransmissionPanel
     */
    public SimulatorTabPanel() {
      //  currentTransmissionPanel = new CurrentTransmissionPanel();
        
       // situationGroupListPanel = new SituationGroupListPanel(listModelSituationGroup);
        
      //  contextTreePanel = new ContextTreePanel();
        
    //    scenarioPanel = new ScenarioPanel();
        
      //  TimeLinePanel t = new TimeLinePanel(scenario);
        
        initComponents();     
        
        titleBorder = BorderFactory.createTitledBorder(detachedBorder, "Scenarios");
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        panelScenario.setBorder(titleBorder); 
        
        titleBorder = BorderFactory.createTitledBorder(detachedBorder, "Situations");
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        panelSituation.setBorder(titleBorder); 
        
        titleBorder = BorderFactory.createTitledBorder(detachedBorder, "Logical Contexts");
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        panelLogical.setBorder(titleBorder); 
        
        titleBorder = BorderFactory.createTitledBorder(detachedBorder, "Physical Contexts");
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        panelPhysical.setBorder(titleBorder); 
        
        titleBorder = BorderFactory.createTitledBorder(detachedBorder, "Details");
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        panelContextDetail.setBorder(titleBorder);  
        
        titleBorder = BorderFactory.createTitledBorder(detachedBorder, "Physical Details");
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        panelPhysicalContextDetail.setBorder(titleBorder); 
        
        titleBorder = BorderFactory.createTitledBorder(detachedBorder, "Timeline");
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        jPanel3.setBorder(titleBorder);
        
        titleBorder = BorderFactory.createTitledBorder(detachedBorder, "Situation Expected Behavior");
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        panelSituationExpectedBehavior.setBorder(titleBorder);
        
       // panelCurrentTransmission.add(currentTransmissionPanel, BorderLayout.CENTER);
        
       // panelDown.add(scenarioPanel, BorderLayout.CENTER);
        
       // scenarioPanel.getPanelScenarioTable().add(t, BorderLayout.CENTER);

    }

    public JPanel getPanelContextDetail() {
        //return panelContextDetail;
        return jPanel1;
    }

    public JPanel getPanelLogical() {
        return panelLogical;
    }

    public JPanel getPanelPhysical() {
        return panelPhysical;
    }

    public JPanel getPanelPhysicalContextDetail() {
        return jPanel2;
       // return panelPhysicalContextDetail;
    }

    public JPanel getPanelScenario() {
        return panelScenario;
    }

    public JPanel getPanelSituation() {
        return panelSituation;
    }

    public JPanel getPanelDown() {
        return jPanel3;
    }    

    public javax.swing.JPanel getPanelSituationExpectedBehavior() {
		return panelSituationExpectedBehavior;
	}

	public void setPanelSituationExpectedBehavior(
			javax.swing.JPanel panelSituationExpectedBehavior) {
		this.panelSituationExpectedBehavior = panelSituationExpectedBehavior;
	}

	public JButton getBtAddContextSource() {
        return btAddContextSource;
    }

    public JButton getBtAddLogical() {
        return btAddLogical;
    }

    public JButton getBtAddScenario() {
        return btAddScenario;
    }

    public JButton getBtAddSituation() {
        return btAddSituation;
    }

    public JButton getBtAddToTimeline() {
        return btAddToTimeline;
    }

    public JButton getBtCopyLogical() {
        return btCopyLogical;
    }

    public JButton getBtCopyScenario() {
        return btCopyScenario;
    }

    public JButton getBtCopySituation() {
        return btCopySituation;
    }

    public JButton getBtRemoveContextSource() {
        return btRemoveContextSource;
    }

    public JButton getBtRemoveScenario() {
        return btRemoveScenario;
    }

    public JButton getBtRemoveSituation() {
        return btRemoveSituation;
    }

    public JButton getBtRemoveLogical() {
        return btRemoveLogical;
    }

    public JButton getBtSavePhysicalContextDetail() {
        return btSavePhysicalContextDetail;
    }

    public JComboBox getCbPhysicalContext() {
        return cbPhysicalContext;
    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUp = new javax.swing.JPanel();
        panelScenario = new javax.swing.JPanel();
        jPanelButtonScenarioOverview = new javax.swing.JPanel();
        btAddScenario = new javax.swing.JButton();
        btCopyScenario = new javax.swing.JButton();
        btRemoveScenario = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabelArrow1 = new javax.swing.JLabel();
        panelSituation = new javax.swing.JPanel();
        jPanelButtonSituationOverview = new javax.swing.JPanel();
        btAddSituation = new javax.swing.JButton();
        btCopySituation = new javax.swing.JButton();
        btRemoveSituation = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabelArrow3 = new javax.swing.JLabel();
        panelLogical = new javax.swing.JPanel();
        jPanelButtonLogicalOverview = new javax.swing.JPanel();
        btAddLogical = new javax.swing.JButton();
        btCopyLogical = new javax.swing.JButton();
        btRemoveLogical = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabelArrow2 = new javax.swing.JLabel();
        panelPhysical = new javax.swing.JPanel();
        cbPhysicalContext = new javax.swing.JComboBox();
        panelMiddle = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        panelContextDetail = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanelButtonContextDetailOverview = new javax.swing.JPanel();
        btAddToTimeline = new javax.swing.JButton();
        btAddContextSource = new javax.swing.JButton();
        btRemoveContextSource = new javax.swing.JButton();
        panelPhysicalContextDetail = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanelButtonPhysicalDetailOverview = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btSavePhysicalContextDetail = new javax.swing.JButton();
        panelDown = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        panelConsole = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        panelSituationExpectedBehavior = new javax.swing.JPanel();

        setLayout(new java.awt.GridLayout(4, 1));

        panelUp.setLayout(new javax.swing.BoxLayout(panelUp, javax.swing.BoxLayout.LINE_AXIS));

        panelScenario.setMinimumSize(new java.awt.Dimension(800, 800));
        panelScenario.setPreferredSize(new java.awt.Dimension(150, 27));
        panelScenario.setLayout(new java.awt.BorderLayout());

        jPanelButtonScenarioOverview.setLayout(new java.awt.GridLayout(1, 3));

        btAddScenario.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_BUTTON_ADD));
        btAddScenario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddScenarioActionPerformed(evt);
            }
        });
        jPanelButtonScenarioOverview.add(btAddScenario);

        btCopyScenario.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_BUTTON_COPY));
        btCopyScenario.setEnabled(false);
        jPanelButtonScenarioOverview.add(btCopyScenario);

        btRemoveScenario.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_BUTTON_DELETE));
        btRemoveScenario.setEnabled(false);
        jPanelButtonScenarioOverview.add(btRemoveScenario);

        panelScenario.add(jPanelButtonScenarioOverview, java.awt.BorderLayout.SOUTH);

        panelUp.add(panelScenario);

        jPanel4.setMaximumSize(new java.awt.Dimension(50, 2147483647));
        jPanel4.setPreferredSize(new java.awt.Dimension(40, 0));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabelArrow1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelArrow1.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_ARROW));
        jLabelArrow1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelArrow1.setMaximumSize(new java.awt.Dimension(100, 500));
        jLabelArrow1.setPreferredSize(new java.awt.Dimension(50, 0));
        jPanel4.add(jLabelArrow1, java.awt.BorderLayout.CENTER);

        panelUp.add(jPanel4);

        panelSituation.setMinimumSize(new java.awt.Dimension(800, 800));
        panelSituation.setPreferredSize(new java.awt.Dimension(150, 27));
        panelSituation.setLayout(new java.awt.BorderLayout());

        jPanelButtonSituationOverview.setLayout(new java.awt.GridLayout(1, 3));

        btAddSituation.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_BUTTON_ADD));
        btAddSituation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddSituationActionPerformed(evt);
            }
        });
        jPanelButtonSituationOverview.add(btAddSituation);

        btCopySituation.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_BUTTON_COPY));
        btCopySituation.setEnabled(false);
        jPanelButtonSituationOverview.add(btCopySituation);

        btRemoveSituation.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_BUTTON_DELETE));
        btRemoveSituation.setEnabled(false);
        jPanelButtonSituationOverview.add(btRemoveSituation);

        panelSituation.add(jPanelButtonSituationOverview, java.awt.BorderLayout.SOUTH);

        panelUp.add(panelSituation);

        jPanel10.setMaximumSize(new java.awt.Dimension(50, 2147483647));
        jPanel10.setPreferredSize(new java.awt.Dimension(40, 0));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabelArrow3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelArrow3.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_ARROW));
        jLabelArrow3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelArrow3.setMaximumSize(new java.awt.Dimension(100, 500));
        jLabelArrow3.setPreferredSize(new java.awt.Dimension(50, 0));
        jPanel10.add(jLabelArrow3, java.awt.BorderLayout.CENTER);

        panelUp.add(jPanel10);

        panelLogical.setPreferredSize(new java.awt.Dimension(150, 322));
        panelLogical.setLayout(new java.awt.BorderLayout());

        jPanelButtonLogicalOverview.setLayout(new java.awt.GridLayout(1, 3));

        btAddLogical.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_BUTTON_ADD));
        btAddLogical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddLogicalActionPerformed(evt);
            }
        });
        jPanelButtonLogicalOverview.add(btAddLogical);

        btCopyLogical.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_BUTTON_COPY));
        btCopyLogical.setEnabled(false);
        jPanelButtonLogicalOverview.add(btCopyLogical);

        btRemoveLogical.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_BUTTON_DELETE));
        btRemoveLogical.setEnabled(false);
        jPanelButtonLogicalOverview.add(btRemoveLogical);

        panelLogical.add(jPanelButtonLogicalOverview, java.awt.BorderLayout.SOUTH);

        panelUp.add(panelLogical);

        jPanel6.setMaximumSize(new java.awt.Dimension(50, 2147483647));
        jPanel6.setPreferredSize(new java.awt.Dimension(40, 0));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabelArrow2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelArrow2.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_ARROW));
        jLabelArrow2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelArrow2.setMaximumSize(new java.awt.Dimension(100, 500));
        jLabelArrow2.setPreferredSize(new java.awt.Dimension(50, 0));
        jPanel6.add(jLabelArrow2, java.awt.BorderLayout.CENTER);

        panelUp.add(jPanel6);

        panelPhysical.setMinimumSize(new java.awt.Dimension(800, 800));
        panelPhysical.setPreferredSize(new java.awt.Dimension(150, 27));
        panelPhysical.setLayout(new java.awt.BorderLayout());

        cbPhysicalContext.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Location", "Time", "Individual", "Device", "Virtual", "Relation" }));
        panelPhysical.add(cbPhysicalContext, java.awt.BorderLayout.SOUTH);

        panelUp.add(panelPhysical);

        add(panelUp);

        panelMiddle.setLayout(new java.awt.BorderLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setPreferredSize(new java.awt.Dimension(0, 5));
        panelMiddle.add(jSeparator1, java.awt.BorderLayout.NORTH);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        panelContextDetail.setPreferredSize(new java.awt.Dimension(150, 322));
        panelContextDetail.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());
        panelContextDetail.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanelButtonContextDetailOverview.setLayout(new java.awt.GridLayout(1, 3));

        btAddToTimeline.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_BUTTON_ADD));
        btAddToTimeline.setText("To Timeline");
        btAddToTimeline.setToolTipText("Add this context to the current timeline");
        btAddToTimeline.setEnabled(false);
        jPanelButtonContextDetailOverview.add(btAddToTimeline);

        btAddContextSource.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_BUTTON_ADD));
        btAddContextSource.setText("Context");
        btAddContextSource.setToolTipText("Add another context source to this context");
        btAddContextSource.setEnabled(false);
        btAddContextSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddContextSourceActionPerformed(evt);
            }
        });
        jPanelButtonContextDetailOverview.add(btAddContextSource);

        btRemoveContextSource.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_BUTTON_DELETE));
        btRemoveContextSource.setText("Remove");
        btRemoveContextSource.setToolTipText("Remove selected context source from this context");
        btRemoveContextSource.setEnabled(false);
        jPanelButtonContextDetailOverview.add(btRemoveContextSource);

        panelContextDetail.add(jPanelButtonContextDetailOverview, java.awt.BorderLayout.SOUTH);

        jPanel7.add(panelContextDetail);

        panelPhysicalContextDetail.setMinimumSize(new java.awt.Dimension(800, 800));
        panelPhysicalContextDetail.setPreferredSize(new java.awt.Dimension(150, 27));
        panelPhysicalContextDetail.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());
        panelPhysicalContextDetail.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanelButtonPhysicalDetailOverview.setLayout(new java.awt.GridLayout(1, 3));
        jPanelButtonPhysicalDetailOverview.add(jLabel1);
        jPanelButtonPhysicalDetailOverview.add(jLabel2);

        btSavePhysicalContextDetail.setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_BUTTON_SAVE));
        btSavePhysicalContextDetail.setToolTipText("Save this data for the current selected physical context source");
        btSavePhysicalContextDetail.setEnabled(false);
        jPanelButtonPhysicalDetailOverview.add(btSavePhysicalContextDetail);

        panelPhysicalContextDetail.add(jPanelButtonPhysicalDetailOverview, java.awt.BorderLayout.SOUTH);

        jPanel7.add(panelPhysicalContextDetail);

        panelMiddle.add(jPanel7, java.awt.BorderLayout.CENTER);

        add(panelMiddle);

        panelDown.setLayout(new java.awt.BorderLayout());

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator2.setPreferredSize(new java.awt.Dimension(0, 5));
        panelDown.add(jSeparator2, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.BorderLayout());
        panelDown.add(jPanel3, java.awt.BorderLayout.CENTER);
        
        add(panelDown);
        
        panelConsole.setLayout(new java.awt.BorderLayout());
        
        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator3.setPreferredSize(new java.awt.Dimension(0, 5));
        panelConsole.add(jSeparator3, java.awt.BorderLayout.NORTH);
        
        panelConsole.add(jSeparator3, java.awt.BorderLayout.NORTH);
        
        panelSituationExpectedBehavior.setLayout(new java.awt.BorderLayout());
        panelConsole.add(panelSituationExpectedBehavior, java.awt.BorderLayout.CENTER);
        
        add(panelConsole);
        
    }// </editor-fold>//GEN-END:initComponents

    private void btAddScenarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddScenarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAddScenarioActionPerformed

    private void btAddSituationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddSituationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAddSituationActionPerformed

    private void btAddLogicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddLogicalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAddLogicalActionPerformed

    private void btAddContextSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddContextSourceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAddContextSourceActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddContextSource;
    private javax.swing.JButton btAddLogical;
    private javax.swing.JButton btAddScenario;
    private javax.swing.JButton btAddSituation;
    private javax.swing.JButton btAddToTimeline;
    private javax.swing.JButton btCopyLogical;
    private javax.swing.JButton btCopyScenario;
    private javax.swing.JButton btCopySituation;
    private javax.swing.JButton btRemoveContextSource;
    private javax.swing.JButton btRemoveLogical;
    private javax.swing.JButton btRemoveScenario;
    private javax.swing.JButton btRemoveSituation;
    private javax.swing.JButton btSavePhysicalContextDetail;
    private javax.swing.JComboBox cbPhysicalContext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelArrow1;
    private javax.swing.JLabel jLabelArrow2;
    private javax.swing.JLabel jLabelArrow3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelButtonContextDetailOverview;
    private javax.swing.JPanel jPanelButtonLogicalOverview;
    private javax.swing.JPanel jPanelButtonPhysicalDetailOverview;
    private javax.swing.JPanel jPanelButtonScenarioOverview;
    private javax.swing.JPanel jPanelButtonSituationOverview;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panelContextDetail;
    private javax.swing.JPanel panelDown;
    private javax.swing.JPanel panelLogical;
    private javax.swing.JPanel panelMiddle;
    private javax.swing.JPanel panelPhysical;
    private javax.swing.JPanel panelPhysicalContextDetail;
    private javax.swing.JPanel panelScenario;
    private javax.swing.JPanel panelSituation;
    private javax.swing.JPanel panelUp;
    private javax.swing.JPanel panelConsole;
    private javax.swing.JPanel panelSituationExpectedBehavior;
    // End of variables declaration//GEN-END:variables
}
