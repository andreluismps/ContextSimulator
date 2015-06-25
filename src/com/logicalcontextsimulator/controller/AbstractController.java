/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.controller;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.logicalcontextsimulator.gui.panel.SimulatorTabPanel;
import com.logicalcontextsimulator.gui.panel.cardPanels.ContextChoicePanel;
import com.logicalcontextsimulator.gui.panel.contextList.ContextTreePanel;
import com.logicalcontextsimulator.model.context.AbstractContext;
import com.logicalcontextsimulator.model.context.LogicalContext;
import com.logicalcontextsimulator.model.context.PhysicalContext;
import com.logicalcontextsimulator.model.context.Scenario;
import com.logicalcontextsimulator.model.context.Situation;
import com.logicalcontextsimulator.model.context.contextSource.Accelerometer;
import com.logicalcontextsimulator.model.context.contextSource.Barometer;
import com.logicalcontextsimulator.model.context.contextSource.Battery;
import com.logicalcontextsimulator.model.context.contextSource.Bluetooth;
import com.logicalcontextsimulator.model.context.contextSource.CPU;
import com.logicalcontextsimulator.model.context.contextSource.Calendar;
import com.logicalcontextsimulator.model.context.contextSource.Camera;
import com.logicalcontextsimulator.model.context.contextSource.CellID;
import com.logicalcontextsimulator.model.context.contextSource.GPS;
import com.logicalcontextsimulator.model.context.contextSource.Gyroscope;
import com.logicalcontextsimulator.model.context.contextSource.HTTPResponse;
import com.logicalcontextsimulator.model.context.contextSource.HardDisk;
import com.logicalcontextsimulator.model.context.contextSource.Infrared;
import com.logicalcontextsimulator.model.context.contextSource.LightSensor;
import com.logicalcontextsimulator.model.context.contextSource.Magnetometer;
import com.logicalcontextsimulator.model.context.contextSource.Microphone;
import com.logicalcontextsimulator.model.context.contextSource.NetworkConnection;
import com.logicalcontextsimulator.model.context.contextSource.QRCode;
import com.logicalcontextsimulator.model.context.contextSource.RAM;
import com.logicalcontextsimulator.model.context.contextSource.RFID;
import com.logicalcontextsimulator.model.context.contextSource.SDCard;
import com.logicalcontextsimulator.model.context.contextSource.Thermometer;
import com.logicalcontextsimulator.model.context.contextSource.TimeDate;
import com.logicalcontextsimulator.model.context.contextSource.USBCable;
import com.logicalcontextsimulator.model.context.contextSource.WiFi;
import com.logicalcontextsimulator.model.renderer.MyTreeRenderer;
import com.logicalcontextsimulator.util.Constants;

/**
 *
 * @author MHL
 */
public abstract class AbstractController {
     
    protected ContextChoicePanel contextChoicePanel;
    
    private DefaultMutableTreeNode topNode;
    
    private DefaultMutableTreeNode tmpNode;
    
    protected ContextTreePanel contextTreePanel;
    
    protected static AbstractContext currentContextInTree = null;
    
    private SimulatorTabPanel simulatorTabPanel;
    
    public AbstractController(final SimulatorTabPanel simulatorTabPanel){
        this.simulatorTabPanel = simulatorTabPanel;
        
        contextTreePanel = new ContextTreePanel();

        //*** Listener ***
        contextTreePanel.getJTree().addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                AbstractContext context = getSelectedAbstractContextFromTree(contextTreePanel.getJTree());

                if (context != null){
                    if(context instanceof PhysicalContext){
                        simulatorTabPanel.getPanelPhysicalContextDetail().removeAll();
                        simulatorTabPanel.getPanelPhysicalContextDetail().add(((PhysicalContext) context).getPanel(), BorderLayout.CENTER);
                        simulatorTabPanel.getPanelPhysicalContextDetail().updateUI();
                    }
                    
                    if((currentContextInTree instanceof LogicalContext || currentContextInTree instanceof Situation) && contextTreePanel.getJTree().getSelectionPath().getPath().length == 3){
                          setEnabledButton(true, context instanceof PhysicalContext);                     
                    }else if((currentContextInTree instanceof Scenario) && contextTreePanel.getJTree().getSelectionPath().getPath().length == 4){
                          setEnabledButton(true, context instanceof PhysicalContext);
                    }else{
                          setEnabledButton(false, context instanceof PhysicalContext && contextTreePanel.getJTree().getSelectionPath().getPath().length == 2);
                    }
                }
            }
        });
        
        simulatorTabPanel.getBtSavePhysicalContextDetail().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbstractContext context = getSelectedAbstractContextFromTree(contextTreePanel.getJTree());
                if ((context == null) || !(context instanceof PhysicalContext)) return;
                ((PhysicalContext) context).savePanel();
            }
        });
       
        simulatorTabPanel.getBtRemoveContextSource().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeContextFromTree();
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

              fillTreeWithContext(rootContext, contextTreePanel.getJTree());
           }
        }
    }
    
    protected abstract void updateModels(int selectedIndex);
    
    /**
     * Fills the util.List with logical context names from the model.
     */
    public void fillListWithModel(JList jList, List<AbstractContext> listModel, AbstractContext filterContext){
        Object selectedObject = jList.getSelectedValue();
                
        DefaultComboBoxModel model = ((DefaultComboBoxModel)jList.getModel());

        model.removeAllElements();
        
        for(AbstractContext context: listModel){
            if(filterContext == null || filterContext.getContextList().contains(context)){
            model.addElement(context.getName());
            }
        } 
        
        if(selectedObject != null){
          jList.setSelectedValue(selectedObject, true);
        }
    }

     public static AbstractContext findContextByName(String contextName, List<AbstractContext> lstAbstractContext){
        for(AbstractContext context: lstAbstractContext){
            if(context.getName().equals(contextName)){
                return context;
            }
        } 
        
        return null;
     }
     
    protected void fillTreeWithContext(AbstractContext context, JTree jTree){
        topNode = new DefaultMutableTreeNode(context.getName());
        topNode.setUserObject(context);
        
        addNodes(topNode, context);

        DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
        
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
      
        root.removeAllChildren();
        
        //GUI update
        model.reload();
        
        model.insertNodeInto(topNode, root, root.getChildCount());

        jTree.setRootVisible(true);
        
        jTree.setCellRenderer(new MyTreeRenderer());
        
        //Expands the whole tree.
       // for (int i = 0; i < jTree.getRowCount(); i++) {
        for (int i = 0; i < 2 && i < jTree.getRowCount() ; i++) {
         jTree.expandRow(i);
        }
    }
    
     private void addNodes(DefaultMutableTreeNode node, AbstractContext context){
        for(AbstractContext ctx: context.getContextList()){
            tmpNode = new DefaultMutableTreeNode(ctx.getName());
            tmpNode.setUserObject(ctx);
            
            node.add(tmpNode);
            addNodes(tmpNode, ctx);
        }
    }
     
     protected void setTreePanelTitle(String title, JComponent component){
        ((TitledBorder) component.getBorder()).setTitle(title);
     }
     
    protected AbstractContext getSelectedAbstractContextFromTree(JTree tree){
       //Find selected Node 
        if(tree.getLastSelectedPathComponent() == null) return null;
        
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if ((node == null) || !(node.getUserObject() instanceof AbstractContext)){
            return null;
        }

        return (AbstractContext) node.getUserObject();
    }
    
    /**
     * Recursive Method to find the parent of the selected Node in the tree to
     * delete this node.
     * @param rootContext
     * @param searchedContext
     * @return 
     */
    protected AbstractContext findContextInList(AbstractContext rootContext, AbstractContext searchedContext, boolean parent){
        if((rootContext.getContextList().contains(searchedContext) && parent) || (rootContext.equals(searchedContext) && !parent)){
          return rootContext;
        }
        
        for(AbstractContext ctx: rootContext.getContextList()){
            return findContextInList(ctx, searchedContext, parent);
        }
        
        return null;
    }
    
    public void setEnabledButton(boolean removeFromTable, boolean savePhysicalSource){
        simulatorTabPanel.getBtAddContextSource().setEnabled(true);
        simulatorTabPanel.getBtAddToTimeline().setEnabled(true);
        simulatorTabPanel.getBtRemoveContextSource().setEnabled(removeFromTable);
        simulatorTabPanel.getBtSavePhysicalContextDetail().setEnabled(savePhysicalSource);
    }
    
    protected void checkAvailabilityLogicalContext(List<AbstractContext> list, List<AbstractContext> lstLogicalContext){
        List<AbstractContext> lstNewList = new ArrayList<>();
        for(AbstractContext situation: list){
            lstNewList = new ArrayList<>();
            for(AbstractContext logicalContextInSituation: situation.getContextList()){//Alle logischen Contexte in Situation
                if(!(logicalContextInSituation instanceof LogicalContext) || lstLogicalContext.contains(logicalContextInSituation)){ 
                 //Check obs sie verfügbar sind in logischer Context
                  lstNewList.add(logicalContextInSituation);
                }
            }
            situation.setContextList(lstNewList);
        }
    }
    
    public PhysicalContext getPhysicalContext(String contextSource){
        switch(contextSource){
            case Constants.ACCELEROMETER:
              return new Accelerometer();
            case Constants.THERMOMETER:
              return new Thermometer();
            case Constants.BAROMETER:
              return new Barometer();
            case Constants.LIGHTSENSOR:
              return new LightSensor();
            case Constants.MAGNETOMETER:
              return new Magnetometer();
            case Constants.GYROSCOPE:
              return new Gyroscope();
            case Constants.TIMEDATE:
              return new TimeDate();
            case Constants.CALENDAR:
              return new Calendar();
            case Constants.GPS:
              return new GPS();
            case Constants.BATTERY:
              return new Battery();
            case Constants.RAM:
              return new  RAM();
            case Constants.DISK:
              return new HardDisk();
            case Constants.CPU:
              return new CPU();
            case Constants.SDCARD:
              return new SDCard();
            case Constants.USBCABLE:
              return new USBCable();
            case Constants.MICROPHONE:
              return new Microphone();
            case Constants.CAMERA:
              return new Camera();
            case Constants.RFID:
              return new RFID();
            case Constants.QRCODE:
              return new QRCode();
            case Constants.BLUETOOTH:
              return new Bluetooth();
            case Constants.INFRARED:
              return new Infrared();
            case Constants.HTTP:
              return new HTTPResponse();
            case Constants.WIFI:
              return new WiFi();
            case Constants.NETWORK:
              return new NetworkConnection();
            case Constants.CELLID:
              return new CellID();
            default:
              return new Accelerometer();
        }
    }
}
