/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.controller;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.logicalcontextsimulator.gui.panel.SimulatorTabPanel;
import com.logicalcontextsimulator.gui.panel.cardPanels.ContextChoicePanel;
import com.logicalcontextsimulator.gui.panel.contextList.ListPanelLogicalContext;
import com.logicalcontextsimulator.model.context.AbstractContext;
import com.logicalcontextsimulator.model.context.LogicalContext;
import com.logicalcontextsimulator.util.Constants;

/**
 *
 * @author MHL
 */
public class LogicalController extends AbstractController{
    
    private SimulatorTabPanel simulatorTabPanel;
    
    private List<AbstractContext> lstLogicalContext;
    
    private PhysicalController physicalController;
    
    private String currentPanel;
    
    private ListPanelLogicalContext logicalContextListPanel;

    private ListPanelLogicalContext logicalContextListPanelCard;    
    
    private DefaultComboBoxModel lstModelLogical;

    private DefaultComboBoxModel lstModelLogicalCard;
    
    private ContextChoicePanel cardContextChoicePanel;
    

    public LogicalController(SimulatorTabPanel simulatorTabPanel, final List<AbstractContext> lstLogicalContext, PhysicalController physicalController){
        
        super(simulatorTabPanel);
        
        this.simulatorTabPanel = simulatorTabPanel;
        
        this.lstLogicalContext = lstLogicalContext;

        this.physicalController = physicalController;
        
        lstModelLogical = new DefaultComboBoxModel<>();           
        lstModelLogicalCard = new DefaultComboBoxModel<>();  
        
        //*** GUI ***
        //contextTreePanel = new ContextTreePanel();
        
        logicalContextListPanel = new ListPanelLogicalContext(lstModelLogical);
        logicalContextListPanelCard = new ListPanelLogicalContext(lstModelLogicalCard);
        
        updateModels(-1);
        
        //*** Listener ***
        logicalContextListPanel.getJListLogicalContext().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting() && logicalContextListPanel.getJListLogicalContext().getSelectedValue()!=null) {
                    buttonEnableMode(true);
                    setEnabledButton(false, false);
                    updateTree();
                }
            }
        });
        
        simulatorTabPanel.getBtAddLogical().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewLogicalContext();
                updateModels(lstLogicalContext.size()-1);
            }
        });
        
        simulatorTabPanel.getBtCopyLogical().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyLogicalContext();
                updateModels(lstLogicalContext.size()-1);
            }
        });
        
        simulatorTabPanel.getBtRemoveLogical().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeLogicalContext();
                updateModels(0);
            }
        });
        

        
    }
    
    /**
     * Removes a node from the tree and from the context model.
     */
    public void removeContextFromTree(){
        //First, find selected Context, then find the Node
        AbstractContext rootContext = currentContextInTree; 
        
        if(rootContext != null){
           //Find selected Node 
            AbstractContext selectedContextPart = getSelectedAbstractContextFromTree(contextTreePanel.getJTree());
            
           //Search Context Part rekursiv
            AbstractContext context = findContextInList(rootContext, selectedContextPart, true);
           
            if(context != null){
              context.getContextList().remove(selectedContextPart);
              updateModels(-1);

              super.fillTreeWithContext(rootContext, contextTreePanel.getJTree());
           }
        }
    }

    public void setLstLogicalContext(List<AbstractContext> lstLogicalContext) {
        this.lstLogicalContext = lstLogicalContext;
    }

    public List<AbstractContext> getLstLogicalContext() {
        return lstLogicalContext;
    }

    public ListPanelLogicalContext getLogicalContextListPanel() {
        return logicalContextListPanel;
    }

    public ListPanelLogicalContext getLogicalContextListPanelCard() {
        return logicalContextListPanelCard;
    }
    
    /**
     * Ask for a name for a new logical context and add it to the model. It won`t be saved
     * until the Save-Button in menu bar will be triggered.
     */
    private void addNewLogicalContext(){
       String sgName =  JOptionPane.showInputDialog ( "Please enter a name:" ); 
       if(sgName != null){
           lstLogicalContext.add(new LogicalContext(sgName));
       }
    }
    
    /**
     * Clones the selected context and renamed it.
     */
    private void copyLogicalContext(){
       String contextName =  JOptionPane.showInputDialog ( "Please enter a name:" ); 
       if(contextName != null && logicalContextListPanel.getJListLogicalContext().getSelectedValue() != null){
           AbstractContext oldContext = super.findContextByName(logicalContextListPanel.getJListLogicalContext().getSelectedValue().toString(), lstLogicalContext);
           if(oldContext == null) return;
           
           LogicalContext newLogicalContext = (LogicalContext) oldContext.clone();
           newLogicalContext.setName(contextName);
           lstLogicalContext.add(newLogicalContext);
       }
    }
    
    /**
     * Removes a selected context from the model and GUI. It won`t be saved
     * until the Save-Button in menu bar will be triggered.
     */
    private void removeLogicalContext(){
        if(logicalContextListPanel.getJListLogicalContext().getSelectedValue() == null) return;
        
        AbstractContext selectedContext = super.findContextByName(logicalContextListPanel.getJListLogicalContext().getSelectedValue().toString(), lstLogicalContext);
        if(selectedContext != null){
           lstLogicalContext.remove(selectedContext);
        }
    }
    
    public void updateTree(){
        if(logicalContextListPanel.getJListLogicalContext().getSelectedValue() == null) return;
        AbstractContext selectedContext = super.findContextByName(logicalContextListPanel.getJListLogicalContext().getSelectedValue().toString(), lstLogicalContext);
        if(selectedContext != null){
           super.fillTreeWithContext(selectedContext, contextTreePanel.getJTree());
           
           String title = new StringBuilder(Constants.LOGICAL).append(": ").append(logicalContextListPanel.getJListLogicalContext().getSelectedValue().toString()).toString();
           super.setTreePanelTitle(title, (JComponent) simulatorTabPanel.getPanelContextDetail().getParent()); 
           simulatorTabPanel.getPanelContextDetail().removeAll();
           simulatorTabPanel.getPanelContextDetail().add(contextTreePanel.getTreeScrollPane(), BorderLayout.CENTER);
           ((JComponent) simulatorTabPanel.getPanelContextDetail().getParent()).updateUI();
            currentContextInTree = selectedContext;
        }
    }

    
    protected void updateModels(int selectedIndex){
        fillListWithModel(logicalContextListPanel.getJListLogicalContext(), this.lstLogicalContext, null);
        fillListWithModel(logicalContextListPanelCard.getJListLogicalContext(), this.lstLogicalContext, null);
        
        if(selectedIndex != -1 && lstLogicalContext.size()>0){
            logicalContextListPanel.getJListLogicalContext().setSelectedIndex(selectedIndex);
        }else{
            buttonEnableMode(false);
        }
    }
    
    private void buttonEnableMode(boolean isSelected){
        simulatorTabPanel.getBtCopyLogical().setEnabled(isSelected);
        simulatorTabPanel.getBtRemoveLogical().setEnabled(isSelected);    
    }

}
