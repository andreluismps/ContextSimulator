/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.controller;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;

import com.logicalcontextsimulator.connection.TransmitData;
import com.logicalcontextsimulator.gui.panel.TransmissionTabPanel;
import com.logicalcontextsimulator.gui.panel.contextList.SituationExpectedBehaviorPanel;
import com.logicalcontextsimulator.gui.panel.contextList.TimeLinePanel;
import com.logicalcontextsimulator.gui.panel.contextList.TransmissionPanel;
import com.logicalcontextsimulator.model.context.AbstractContext;
import com.logicalcontextsimulator.model.context.PhysicalContext;
import com.logicalcontextsimulator.model.context.Scenario;
import com.logicalcontextsimulator.model.context.TimeSlot;
import com.logicalcontextsimulator.util.Constants;

/**
 *
 * @author MHL
 */
public class TransmissionController {

    private boolean isPlaying = false;
    
    private TransmitData transmitData;
    
    private TransmissionPanel transmissionPanel;
    
    private SituationExpectedBehaviorPanel situationExpectedBehaviorPanel;

    private TimeLinePanel timeLinePanel;  
    
    private Scenario scenarioInTimeLine;
    
    private TransmissionTabPanel transmissionTabPanel;
    
    private AbstractContext dragDropObject;
    
    private int rowSource, columnSource, columnTarget;
    
    private Thread timeLineThread;
    
    private int timeDuration = 1000;
    
    //----------------------
    private int itsRow, itsColumn, index;
    private JTable aTable;

    //Thread for playback timeline
    Runnable run = new Runnable() {
       public void run() {
           try {
               while(true) {
                   Thread.sleep(timeDuration);
                   if(isPlaying){
                       index = scenarioInTimeLine.getCurrentTransmissionIndex();
                       situationExpectedBehaviorPanel.getTextArea().setText(scenarioInTimeLine.getSituationExpectedSituation(index));
                       
                       index++;
                       if(index >= getMaxColumn()){
                           index = 0;
                       }
                       itsColumn = index;
                       setCurrentTransmissionTabPanel();
                       scenarioInTimeLine.setCurrentTransmissionIndex(index);

                       aTable.repaint();
                       situationExpectedBehaviorPanel.repaint();
                   }
               }
           } catch (InterruptedException e) {
               System.out.println(" interrupted");
           }
       }
    };

    public TransmissionController(TransmissionTabPanel transmissionTabPanel){
        
       timeLineThread = new Thread(run);
       
       transmitData = new TransmitData();
       
       transmitData.connect();
        
       this.transmissionTabPanel = transmissionTabPanel;
        
       scenarioInTimeLine = new Scenario(Constants.EMPTY_STRING); 
        
       transmissionPanel = new TransmissionPanel();
       situationExpectedBehaviorPanel = new SituationExpectedBehaviorPanel();
       timeLinePanel = new TimeLinePanel(scenarioInTimeLine);
       
       aTable = timeLinePanel.getTable();
       transmissionPanel.getPanelScenarioTable().add(timeLinePanel, BorderLayout.CENTER);
       
       TransmissionController.MyMouseAdapter aMouseAda = new TransmissionController.MyMouseAdapter();
       timeLinePanel.getTable().addMouseListener((MouseListener) aMouseAda);
       
       transmissionPanel.getBtPlay().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePlaybackStatus();
            }
        });
       
       timeLineThread.start();
    }
    
    private void changePlaybackStatus(){
      if(!isPlaying){
        String durationInMillis = JOptionPane.showInputDialog( "Duration in Milliseconds: ", timeDuration ); 

        try{
           if(durationInMillis!=null)
            timeDuration = Integer.parseInt(durationInMillis);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        transmissionPanel.getBtPlay().setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_PAUSE));
      }else{
        transmissionPanel.getBtPlay().setIcon(Constants.getInstance().getImageIcon(Constants.URL_ICON_PLAY));
      }
      
      isPlaying = !isPlaying; 
    }
    
    
    public void updatePortNumber(){
        transmitData.connect();
    }

    public TransmissionPanel getTransmissionPanel() {
        return transmissionPanel;
    }

    public SituationExpectedBehaviorPanel getSituationExpectedBehaviorPanel() {
		return situationExpectedBehaviorPanel;
	}

	public TimeLinePanel getTimeLinePanel() {
        return timeLinePanel;
    }

    public Scenario getScenarioInTimeLine() {
        return scenarioInTimeLine;
    }
    
    public JTable getJTable(){
        return timeLinePanel.getTable();
    }

    private void setCurrentTransmissionTabPanel(){
        JTextArea area = transmissionTabPanel.getTextArea();
        area.setText("Raw data which is currently transmitted to the mobile device\n\n");
        
        List<PhysicalContext> lstRawData = ((TimeSlot)(scenarioInTimeLine.getContextList().get(itsColumn))).getTransmissionInSpot();
        
        for(PhysicalContext context: lstRawData){
            area.append(context.getTextAreaRepresentation() +"\n");
        }
        
        transmitData.clearData();
        transmitData.sendData(lstRawData);
        
    }
    
    private int getMaxColumn(){
        return scenarioInTimeLine.getContextList().size();
    }    
    
    public class MyMouseAdapter implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            aTable = (JTable)e.getSource();
            itsRow = aTable.rowAtPoint(e.getPoint());
            itsColumn = aTable.columnAtPoint(e.getPoint());
            
            scenarioInTimeLine.setCurrentTransmissionIndex(itsColumn);

            aTable.repaint();
            
            setCurrentTransmissionTabPanel();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            aTable = (JTable)e.getSource();
            rowSource = aTable.rowAtPoint(e.getPoint());
            columnSource = aTable.columnAtPoint(e.getPoint());
            
            try{
                Object currentObject = scenarioInTimeLine.getContextList().get(columnSource).getContextList().get(rowSource-1);
                dragDropObject = (AbstractContext) currentObject;
            }catch(IndexOutOfBoundsException ex){}
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
          if(dragDropObject != null){
            aTable = (JTable)e.getSource();
            int columnTarget = aTable.columnAtPoint(e.getPoint());  
            
            try{
                scenarioInTimeLine.getContextList().get(columnTarget).getContextList().add(dragDropObject);
                scenarioInTimeLine.getContextList().get(columnSource).getContextList().remove(dragDropObject);
                aTable.repaint();
                ((AbstractTableModel)(aTable.getModel())).fireTableStructureChanged();     
                ((AbstractTableModel)(aTable.getModel())).fireTableDataChanged();
             }catch(IndexOutOfBoundsException ex){}
          }
        }

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }
    
}
