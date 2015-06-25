/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.controller;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.logicalcontextsimulator.gui.panel.cardPanels.CardPhysicalPanel;
import com.logicalcontextsimulator.gui.panel.cardPanels.ContextChoicePanel;
import com.logicalcontextsimulator.model.context.AbstractContext;
import com.logicalcontextsimulator.model.context.LogicalContext;
import com.logicalcontextsimulator.model.context.Scenario;
import com.logicalcontextsimulator.model.context.Situation;

/**
 *
 * @author MHL
 */
public class CardController{
    
    private JDialog dialog;
    
    private ContextChoicePanel contextChoicePanel;
    
    private CardPhysicalPanel listPanelPhysicalContext;
    
    private AbstractContext choosenContext = null;
    
    private SituationController situationController;
    
    private LogicalController logicalController;
    
    private String[] titles = {};
    
    private int titleIndex = 0;

    public CardController(final SituationController situationController, final LogicalController logicalController, final PhysicalController physicalController) {
        this.situationController = situationController;
        this.logicalController = logicalController;
        
        contextChoicePanel = new ContextChoicePanel();
        listPanelPhysicalContext = new CardPhysicalPanel();
        listPanelPhysicalContext.getPanelPhysical().add(physicalController.getPhysicalContextListPanelCard(), BorderLayout.CENTER);
        physicalController.getPhysicalContextListPanelCard().getJListContextSource().setLayoutOrientation(JList.HORIZONTAL_WRAP);

        
        listPanelPhysicalContext.getCbPhysicalContext().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                if(listPanelPhysicalContext.getCbPhysicalContext().getSelectedIndex() != -1){
             //      lstModelPhysical.setMode(simulatorTabPanel.getCbPhysicalContext().getSelectedItem().toString());
              //     physicalContextListPanel.getJListContextSource().updateUI();
               }
            }
        });
        
        contextChoicePanel.getBtLeft().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contextChoicePanel.getCardLayout().next(contextChoicePanel.getPanelContextSources());
                titleIndex++;
                if(titleIndex>=titles.length) titleIndex = 0; 
                ((TitledBorder)(contextChoicePanel.getPanelContextSources().getBorder())).setTitle(titles[titleIndex]);
                contextChoicePanel.getPanelContextSources().updateUI();
            }
        });
        
        contextChoicePanel.getBtRight().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contextChoicePanel.getCardLayout().previous(contextChoicePanel.getPanelContextSources());
                titleIndex--;
                if(titleIndex<0) titleIndex = titles.length-1; 
                ((TitledBorder)(contextChoicePanel.getPanelContextSources().getBorder())).setTitle(titles[titleIndex]);
                contextChoicePanel.getPanelContextSources().updateUI();
            }
        });
        
        //*** Listener for every List ***
        situationController.getSituationListPanelCard().getJListSituation().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting() && situationController.getSituationListPanelCard().getJListSituation().getSelectedValue()!=null) {
                    choosenContext = AbstractController.findContextByName(situationController.getSituationListPanelCard().getJListSituation().getSelectedValue().toString(), situationController.getLstSituation());
                }
            }
        });
        
        logicalController.getLogicalContextListPanelCard().getJListLogicalContext().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting() && logicalController.getLogicalContextListPanelCard().getJListLogicalContext().getSelectedValue()!=null) {
                    choosenContext = AbstractController.findContextByName(logicalController.getLogicalContextListPanelCard().getJListLogicalContext().getSelectedValue().toString(), logicalController.getLstLogicalContext());
                }
            }
        });
        
        physicalController.getPhysicalContextListPanelCard().getJListContextSource().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting() && physicalController.getPhysicalContextListPanelCard().getJListContextSource().getSelectedValue()!=null) {
                    choosenContext = physicalController.getSelectedSource(physicalController.getPhysicalContextListPanelCard());
                }
            }
        });
        
    }
    
    
    
    public ContextChoicePanel getContextChoicePanel() {
        return contextChoicePanel;
    }
    
    

    public void openChoicePopUp(AbstractContext context){
        titleIndex = 0;
        contextChoicePanel.getPanelContextSources().removeAll();
        if(context instanceof Scenario || context instanceof Situation){
            contextChoicePanel.getPanelContextSources().add(listPanelPhysicalContext);
            contextChoicePanel.getPanelContextSources().add(logicalController.getLogicalContextListPanelCard());
            contextChoicePanel.getPanelContextSources().add(situationController.getSituationListPanelCard());
            titles = new String[]{"Physical Contexts", "Logical Contexts", "Situations"};
        }else if(context instanceof LogicalContext){
            contextChoicePanel.getPanelContextSources().add(listPanelPhysicalContext);
            contextChoicePanel.getPanelContextSources().add(logicalController.getLogicalContextListPanelCard());
            titles = new String[]{"Physical Contexts", "Logical Contexts"};
        }
        
       ((TitledBorder)(contextChoicePanel.getPanelContextSources().getBorder())).setTitle(titles[titleIndex]);
        contextChoicePanel.getPanelContextSources().updateUI();
        
        dialog = new JDialog(new JFrame(), "Choose a context source", true);
        dialog.add(contextChoicePanel);
        dialog.setSize(670, 300);
        dialog.setVisible(true);
    }
    
    public void closePopUp(){
        dialog.dispose();
    }

    public AbstractContext getChoosenContext() {
        return choosenContext;   
    }
    
}
