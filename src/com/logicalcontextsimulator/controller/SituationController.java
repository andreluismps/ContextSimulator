/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.controller;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.logicalcontextsimulator.gui.panel.SimulatorTabPanel;
import com.logicalcontextsimulator.gui.panel.cardPanels.ContextChoicePanel;
import com.logicalcontextsimulator.gui.panel.contextList.ListPanelSituation;
import com.logicalcontextsimulator.model.context.AbstractContext;
import com.logicalcontextsimulator.model.context.Situation;
import com.logicalcontextsimulator.util.Constants;

/**
 *
 * @author MHL
 */
public class SituationController  extends AbstractController{

    private SimulatorTabPanel simulatorTabPanel;
    
    private List<AbstractContext> lstSituation;
    
    private LogicalController logicalController;
           
    private PhysicalController physicalController;
    
    private ContextChoicePanel cardContextChoicePanel;
    
    private JList jListSituationGroup;
    
    private JList jListSituation;
    
    private JTree jTreeDetail;
    
    private DefaultComboBoxModel lstModelSituation;

    private DefaultComboBoxModel lstModelSituationCard;
    
    private ListPanelSituation situationListPanel;
    
    private ListPanelSituation situationListPanelCard;
        
    private String currentPanel;

    public SituationController(SimulatorTabPanel simulatorTabPanel, final List<AbstractContext> lstSituation, LogicalController logicalController, PhysicalController physicalController) {
        super(simulatorTabPanel);
        
        this.simulatorTabPanel = simulatorTabPanel;
        
        this.lstSituation = lstSituation;
        this.logicalController = logicalController;
        this.physicalController = physicalController;

        lstModelSituation = new DefaultComboBoxModel<>();        
        lstModelSituationCard = new DefaultComboBoxModel<>();   
        
        //*** GUI ***
        //contextTreePanel = new ContextTreePanel();
        
        situationListPanel = new ListPanelSituation(lstModelSituation);
        situationListPanelCard = new ListPanelSituation(lstModelSituationCard);
                
        updateModels(-1);
        
        //*** Listener ***
        situationListPanel.getJListSituation().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting() && situationListPanel.getJListSituation().getSelectedValue()!=null) {
                    buttonEnableMode(true);
                    setEnabledButton(false, false);
                    updateTree();
                }
            }
        });
        
        simulatorTabPanel.getBtAddSituation().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewSituation();
                updateModels(lstSituation.size()-1);
            }
        });
        
        simulatorTabPanel.getBtCopySituation().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copySituation();
                updateModels(lstSituation.size()-1);
            }
        });
        
        simulatorTabPanel.getBtRemoveSituation().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSituation();
                updateModels(0);
            }
        });
      
    }

    public ListPanelSituation getSituationListPanel() {
        return situationListPanel;
    }

    public ListPanelSituation getSituationListPanelCard() {
        return situationListPanelCard;
    }

    public DefaultComboBoxModel getLstModelSituationCard() {
        return lstModelSituationCard;
    }

    private void addNewSituation(){
       String sgName =  JOptionPane.showInputDialog ( "Please enter a name:" ); 
       if(sgName != null){
           lstSituation.add(new Situation(sgName));
       }
    }
    
    /**
     * Clones the selected context and renamed it.
     */
    private void copySituation(){
       String contextName =  JOptionPane.showInputDialog ( "Please enter a name:" ); 
       if(contextName != null && situationListPanel.getJListSituation().getSelectedValue() != null){
           AbstractContext oldContext = super.findContextByName(situationListPanel.getJListSituation().getSelectedValue().toString(), lstSituation);
           if(oldContext == null) return;
           
           Situation newSituation = (Situation) oldContext.clone();
           newSituation.setName(contextName);
           lstSituation.add(newSituation);
       }
    }
    
    /**
     * Removes a selected context from the model and GUI. It won`t be saved
     * until the Save-Button in menu bar will be triggered.
     */
    private void removeSituation(){
        if(situationListPanel.getJListSituation().getSelectedValue() == null) return;
        
        AbstractContext selectedContext = super.findContextByName(situationListPanel.getJListSituation().getSelectedValue().toString(), lstSituation);
        if(selectedContext != null){
           lstSituation.remove(selectedContext);
        }
    }
    
    public void updateTree(){
        if(situationListPanel.getJListSituation().getSelectedValue() == null) return;
        AbstractContext selectedContext = super.findContextByName(situationListPanel.getJListSituation().getSelectedValue().toString(), lstSituation);
        if(selectedContext != null){
           super.fillTreeWithContext(selectedContext, contextTreePanel.getJTree());
           
           String title = new StringBuilder(Constants.SITUATION).append(": ").append(situationListPanel.getJListSituation().getSelectedValue().toString()).toString();
           super.setTreePanelTitle(title, (JComponent) simulatorTabPanel.getPanelContextDetail().getParent()); 
           simulatorTabPanel.getPanelContextDetail().removeAll();
           simulatorTabPanel.getPanelContextDetail().add(contextTreePanel.getTreeScrollPane(), BorderLayout.CENTER);
           ((JComponent) simulatorTabPanel.getPanelContextDetail().getParent()).updateUI();
            currentContextInTree = selectedContext;
        }
    }

    public List<AbstractContext> getLstSituation(){
        return lstSituation;
    }

    public void setLstSituation(List<AbstractContext> lstSituation) {
        this.lstSituation = lstSituation;
    }
    
    
    
    
    protected void updateModels(int selectedIndex){
        fillListWithModel(situationListPanel.getJListSituation(), this.lstSituation, null);
        fillListWithModel(situationListPanelCard.getJListSituation(), this.lstSituation, null);
        
        if(selectedIndex != -1 && lstSituation.size()>0){
            situationListPanel.getJListSituation().setSelectedIndex(selectedIndex);
        }else{
            buttonEnableMode(false);
        }
    }
    
    private void buttonEnableMode(boolean isSelected){
        simulatorTabPanel.getBtCopySituation().setEnabled(isSelected);
        simulatorTabPanel.getBtRemoveSituation().setEnabled(isSelected);    
    }

    Object setLstSituation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
