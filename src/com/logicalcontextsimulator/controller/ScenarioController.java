/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.controller;

import com.logicalcontextsimulator.gui.panel.SimulatorTabPanel;
import com.logicalcontextsimulator.gui.panel.contextList.ContextTreePanel;
import com.logicalcontextsimulator.gui.panel.contextList.ListPanelScenario;
import com.logicalcontextsimulator.model.context.AbstractContext;
import com.logicalcontextsimulator.model.context.PhysicalContext;
import com.logicalcontextsimulator.model.context.Scenario;
import com.logicalcontextsimulator.util.Constants;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

/**
 *
 * @author MHL
 */
public class ScenarioController extends AbstractController{
       
    private SimulatorTabPanel simulatorTabPanel;
    
    private List<AbstractContext> lstScenario;
    
    private SituationController situationController; 
    
    private LogicalController logicalController;
    
    private PhysicalController physicalController;
    
    protected DefaultComboBoxModel lstModelScenario;
    protected DefaultComboBoxModel lstModelScenarioCard;
    
    //*** Small Windows ***
    
    private ListPanelScenario scenarioListPanel; 
    
    
    private ListPanelScenario scenarioListPanelCard;  
    
    private String currentPanel;
    
  //  private ContextChoicePanel cardContextChoicePanel;
    
  //  private DefaultComboBoxModel listModelSituationGroup;
    
    
    public ScenarioController(final SimulatorTabPanel simulatorTabPanel, final List<AbstractContext> lstScenario, final SituationController situationController, final LogicalController logicalController, PhysicalController physicalController){

        super(simulatorTabPanel);
        
        this.simulatorTabPanel = simulatorTabPanel;
        
        this.situationController = situationController;
        
        this.logicalController = logicalController;
        
        this.physicalController = physicalController;
        
        this.lstScenario = lstScenario;
        
        lstModelScenario = new DefaultComboBoxModel<>();     
        lstModelScenarioCard = new DefaultComboBoxModel<>();  
        
        //*** GUI ***
        scenarioListPanel = new ListPanelScenario(lstModelScenario);
        
        scenarioListPanelCard = new ListPanelScenario(lstModelScenarioCard);
        
        updateModels(-1);
        
        
        //*** Listener *** 
        scenarioListPanel.getJListScenario().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting() && scenarioListPanel.getJListScenario().getSelectedValue()!=null) {
                    buttonEnableMode(true);
                    setEnabledButton(false, false);
                    updateTree();
                }
            }
        });
        
        simulatorTabPanel.getBtAddScenario().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewScenario();
                updateModels(lstScenario.size()-1);
            }
        });
        
        simulatorTabPanel.getBtCopyScenario().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyScenario();
                updateModels(lstScenario.size()-1);
            }
        });
        
        simulatorTabPanel.getBtRemoveScenario().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeScenario();
                updateModels(0);
            }
        });
    }

    public List<AbstractContext> getLstScenario() {
        return lstScenario;
    }

    public void setLstScenario(List<AbstractContext> lstScenario) {
        this.lstScenario = lstScenario;
    }
    
    
    
    private void addNewScenario(){
       String sgName =  JOptionPane.showInputDialog ( "Please enter a name:" ); 
       if(sgName != null){
           lstScenario.add(new Scenario(sgName));
       }
    }
    
    /**
     * Clones the selected context and renamed it.
     */
    private void copyScenario(){
       String contextName =  JOptionPane.showInputDialog ( "Please enter a name:" ); 
       if(contextName != null && scenarioListPanel.getJListScenario().getSelectedValue() != null){
           AbstractContext oldContext = super.findContextByName(scenarioListPanel.getJListScenario().getSelectedValue().toString(), lstScenario);
           if(oldContext == null) return;
           
           Scenario newScenario = (Scenario) oldContext.clone();
           newScenario.setName(contextName);
           lstScenario.add(newScenario);
       }
    }
    
    /**
     * Removes a selected context from the model and GUI. It won`t be saved
     * until the Save-Button in menu bar will be triggered.
     */
    private void removeScenario(){
        if(scenarioListPanel.getJListScenario().getSelectedValue() == null) return;
        
        AbstractContext selectedContext = super.findContextByName(scenarioListPanel.getJListScenario().getSelectedValue().toString(), lstScenario);
        if(selectedContext != null){
           lstScenario.remove(selectedContext);
        }
    }
    
    public void updateTree(){
        if(scenarioListPanel.getJListScenario().getSelectedValue() == null) return;
        AbstractContext selectedContext = super.findContextByName(scenarioListPanel.getJListScenario().getSelectedValue().toString(), lstScenario);
        if(selectedContext != null){
           super.fillTreeWithContext(selectedContext, contextTreePanel.getJTree());
           
           String title = new StringBuilder(Constants.SCENARIO).append(": ").append(scenarioListPanel.getJListScenario().getSelectedValue().toString()).toString();
           super.setTreePanelTitle(title, (JComponent) simulatorTabPanel.getPanelContextDetail().getParent()); 
           simulatorTabPanel.getPanelContextDetail().removeAll();
           simulatorTabPanel.getPanelContextDetail().add(contextTreePanel.getTreeScrollPane(), BorderLayout.CENTER);
           ((JComponent) simulatorTabPanel.getPanelContextDetail().getParent()).updateUI();
            currentContextInTree = selectedContext;
        }
    }
    
    protected void updateModels(int selectedIndex){
        fillListWithModel(scenarioListPanel.getJListScenario(), this.lstScenario, null);
        fillListWithModel(scenarioListPanelCard.getJListScenario(), this.lstScenario, null);
        
        if(selectedIndex != -1 && lstScenario.size()>0){
            scenarioListPanel.getJListScenario().setSelectedIndex(selectedIndex);
        }else{
            buttonEnableMode(false);
        }
    }
    
    private void buttonEnableMode(boolean isSelected){
        simulatorTabPanel.getBtCopyScenario().setEnabled(isSelected);
        simulatorTabPanel.getBtRemoveScenario().setEnabled(isSelected);    
    }
    
    public JPanel getScenarioListPanel(){
        return scenarioListPanel;
    }
    
    
    
        private void switchContextSelectionPanel(boolean forwardDirection){
        if(forwardDirection){
       //    cardContextChoicePanel.getCardLayout().next(cardContextChoicePanel.getjPanelContextSources()); 
        }else{
      //     cardContextChoicePanel.getCardLayout().previous(cardContextChoicePanel.getjPanelContextSources()); 
        }

        switch (currentPanel) {
            case Constants.PHYSICAL:
              currentPanel = forwardDirection? Constants.LOGICAL:Constants.SITUATION; 
            break;
            case Constants.LOGICAL:
              currentPanel = forwardDirection? Constants.SITUATION:Constants.PHYSICAL;
            break; 
            case Constants.SITUATION:
              currentPanel = forwardDirection? Constants.PHYSICAL:Constants.LOGICAL;
            break; 
        }
        //setAvailableSourcesTitle(currentPanel);
    }

}
