/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.controller;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.logicalcontextsimulator.gui.panel.SimulatorTabPanel;
import com.logicalcontextsimulator.gui.panel.contextList.ListPanelPhysicalContext;
import com.logicalcontextsimulator.model.context.AbstractContext;
import com.logicalcontextsimulator.model.context.PhysicalContext;
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
import com.logicalcontextsimulator.model.renderer.ContextListItem;
import com.logicalcontextsimulator.model.renderer.MyPhysicalContextListModel;
import com.logicalcontextsimulator.util.Constants;

/**
 *
 * @author MHL
 */
public class PhysicalController  extends AbstractController{
    
    private MyPhysicalContextListModel lstModelPhysical;
    
    private MyPhysicalContextListModel lstModelPhysicalCard;
    
    private SimulatorTabPanel simulatorTabPanel;
    
    private ListPanelPhysicalContext physicalContextListPanel;
    
     private ListPanelPhysicalContext physicalContextListPanelCard;   
    
    public PhysicalController(final SimulatorTabPanel simulatorTabPanel){
        super(simulatorTabPanel);
        
        lstModelPhysical = new MyPhysicalContextListModel();                  
        lstModelPhysicalCard = new MyPhysicalContextListModel();
        
        this.simulatorTabPanel = simulatorTabPanel;

        physicalContextListPanel = new ListPanelPhysicalContext(lstModelPhysical);
        physicalContextListPanelCard = new ListPanelPhysicalContext(lstModelPhysicalCard);
        
        //*** Listener ***
        simulatorTabPanel.getCbPhysicalContext().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                if(simulatorTabPanel.getCbPhysicalContext().getSelectedIndex() != -1){
                   lstModelPhysical.setMode(simulatorTabPanel.getCbPhysicalContext().getSelectedItem().toString());
                   physicalContextListPanel.getJListContextSource().updateUI();
               }
            }
        });
        
        physicalContextListPanel.getJListContextSource().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting() && physicalContextListPanel.getJListContextSource().getSelectedValue()!=null) {
                    setEnabledButton(false, false);
                    updateTree();
                }
            }
        });
    }

    public void updateTree(){
        if(physicalContextListPanel.getJListContextSource().getSelectedValue() == null) return;
        AbstractContext selectedContext = getPhysicalContextByName(((ContextListItem)(physicalContextListPanel.getJListContextSource().getSelectedValue())).getName());
        if(selectedContext != null){
           super.fillTreeWithContext(selectedContext, contextTreePanel.getJTree());
           
           String title = new StringBuilder(Constants.PHYSICAL).append(": ").append(((ContextListItem)(physicalContextListPanel.getJListContextSource().getSelectedValue())).getName()).toString();
           super.setTreePanelTitle(title, (JComponent) simulatorTabPanel.getPanelContextDetail().getParent()); 
           simulatorTabPanel.getPanelContextDetail().removeAll();
           simulatorTabPanel.getPanelContextDetail().add(contextTreePanel.getTreeScrollPane(), BorderLayout.CENTER);
           ((JComponent) simulatorTabPanel.getPanelContextDetail().getParent()).updateUI();
            currentContextInTree = selectedContext;
        }
    }
    
    public JPanel getContextSourceListPanel(){
       return physicalContextListPanel;
    }

    public ListPanelPhysicalContext getPhysicalContextListPanelCard() {
        return physicalContextListPanelCard;
    }

    public PhysicalContext getSelectedSource(ListPanelPhysicalContext contextSourcesListPanel){
        JList contextList = contextSourcesListPanel.getJListContextSource();
        if(contextList.getSelectedValue() != null){
            ContextListItem listEntry = ((ContextListItem)contextList.getSelectedValue());
            return getPhysicalContextByName(listEntry.getName());
        }else{
            return null;
        }
    }
    
    public PhysicalContext getPhysicalContextByName(String name){
        PhysicalContext context = null;
        
        switch(name){
            case Constants.ACCELEROMETER:
              context = new Accelerometer();
            break;
            case Constants.THERMOMETER:
              context = new Thermometer();
            break;
            case Constants.BAROMETER:
              context = new Barometer();
            break;
            case Constants.LIGHTSENSOR:
              context = new LightSensor();
            break;
            case Constants.MAGNETOMETER:
              context = new Magnetometer();
            break;
            case Constants.GYROSCOPE:
              context = new Gyroscope();
            break;
            case Constants.TIMEDATE:
              context = new TimeDate();
            break;
            case Constants.CALENDAR:
              context = new Calendar();
            break;
            case Constants.GPS:
              context = new GPS();
            break;
            case Constants.BATTERY:
              context = new Battery();
            break;
            case Constants.RAM:
              context = new RAM();
            break;
            case Constants.DISK:
              context = new HardDisk();
            break;
            case Constants.CPU:
              context = new CPU();
            break;
            case Constants.SDCARD:
              context = new SDCard();
            break;
            case Constants.USBCABLE:
              context = new USBCable();
            break;
            case Constants.MICROPHONE:
              context = new Microphone();
            break;
            case Constants.CAMERA:
              context = new Camera();
            break;
            case Constants.RFID:
              context = new RFID();
            break;
            case Constants.QRCODE:
              context = new QRCode();
            break;
            case Constants.BLUETOOTH:
              context = new Bluetooth();
            break;
            case Constants.INFRARED:
              context = new Infrared();
            break;
            case Constants.HTTP:
              context = new HTTPResponse();
            break;
            case Constants.WIFI:
              context = new WiFi();
            break;
            case Constants.NETWORK:
              context = new NetworkConnection();
            break;
            case Constants.CELLID:
              context = new CellID();
        }
        
        return context;
    }

    @Override
    protected void updateModels(int selectedIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
