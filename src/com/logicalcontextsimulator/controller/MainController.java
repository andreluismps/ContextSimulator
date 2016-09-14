/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.controller;

import static com.logicalcontextsimulator.controller.AbstractController.currentContextInTree;

import java.awt.BorderLayout;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.logicalcontextsimulator.cemantika.util.CemantikaCASEJsonReader;
import com.logicalcontextsimulator.gui.MainFrame;
import com.logicalcontextsimulator.gui.panel.MainTabPanel;
import com.logicalcontextsimulator.gui.panel.SimulatorTabPanel;
import com.logicalcontextsimulator.gui.panel.TestCaseTabPanel;
import com.logicalcontextsimulator.gui.panel.TransmissionTabPanel;
import com.logicalcontextsimulator.model.context.AbstractContext;
import com.logicalcontextsimulator.model.context.LogicalContext;
import com.logicalcontextsimulator.model.context.PhysicalContext;
import com.logicalcontextsimulator.model.context.Scenario;
import com.logicalcontextsimulator.model.context.Situation;
import com.logicalcontextsimulator.model.context.contextSource.GPS;
import com.logicalcontextsimulator.model.context.contextSource.RAM;
import com.logicalcontextsimulator.util.Constants;
import com.logicalcontextsimulator.util.SerializeHelperClass;

/**
 *
 * @author MHL
 */
public class MainController {
    
    //******* TESTDATA
        Scenario sc1 = new Scenario("Fraunhofer Meeting");
        Scenario sc2 = new Scenario("Transfer Data With Interrupt");

        Situation s1 = new Situation("S1");
        Situation s2 = new Situation("S2");
        Situation s3 = new Situation("S3");
        
        LogicalContext l1 = new LogicalContext("l1");
        LogicalContext l2 = new LogicalContext("l2");
        LogicalContext l3 = new LogicalContext("l3");

        GPS gps1 = new GPS();
        GPS gps2 = new GPS();
        GPS gps3 = new GPS();
        RAM ram1 = new RAM();
        RAM ram2 = new RAM();
    //******* END TESTDATA
    
    private MainFrame mainFrame;
    
    //*** Every Tab has its own controller ***
    private ScenarioController scenarioController;
    
    private SituationController situationController;
    
    private LogicalController logicalController;
    
    private PhysicalController physicalController;
    
    private CardController cardController;
    
    private TransmissionController transmissionController;
    
    private TestCaseController testCaseController;
    
    //*** Model Lists ***
    private List<AbstractContext> lstLogicalContext;
    
    private List<AbstractContext> lstSituation;
    
    private List<AbstractContext> lstScenario;
    
    //**** TAB Panels ***
    private MainTabPanel mainTabPanel;
    
    private SimulatorTabPanel simulatorTabPanel;
    
    private TransmissionTabPanel transmissionTabPanel;
    
    private TestCaseTabPanel testCaseTabPanel;
    
    private SerializeHelperClass serializeHelperClass;
    
    private CemantikaCASEJsonReader cemantikaCASEJsonReader;
    
 //   private PhysicalTabPanel physicalTabPanel;
 //   private LogicalTabPanel logicalTabPanel;
 //   private SituationTabPanel situationTabPanel;
    
    private int selectedIndex = 0;

    public MainController(){
      //  scenario = new ScenarioOld();
        serializeHelperClass = new SerializeHelperClass();
        
        cemantikaCASEJsonReader = new CemantikaCASEJsonReader();
        
        mainTabPanel = new MainTabPanel();
        
        //listModelSituationGroup = new DefaultComboBoxModel<>();
        //listModelSituationGroupTransmission = new DefaultComboBoxModel<>();
        
       // physicalTabPanel = new PhysicalTabPanel();
       // logicalTabPanel = new LogicalTabPanel();
       // situationTabPanel = new SituationTabPanel(listModelSituationGroup);
        simulatorTabPanel = new SimulatorTabPanel(); 
        transmissionTabPanel = new TransmissionTabPanel();
        testCaseTabPanel = new TestCaseTabPanel();

        mainTabPanel.getTabbedPane().addTab(Constants.EMPTY_STRING, Constants.getInstance().getImageIcon(Constants.URL_ICON_SIMULATOR_TAB), simulatorTabPanel);
        mainTabPanel.getTabbedPane().addTab(Constants.EMPTY_STRING, Constants.getInstance().getImageIcon(Constants.URL_ICON_TRANSMISSION_TAB), transmissionTabPanel);
        mainTabPanel.getTabbedPane().addTab(Constants.EMPTY_STRING, Constants.getInstance().getImageIcon(Constants.URL_ICON_TESTCASE_TAB), testCaseTabPanel);

        /*   
        mainTabPanel.getTabbedPane().addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent e) {
            if ( mainTabPanel.getTabbedPane().getSelectedIndex() != selectedIndex ) {  
                //System.out.println("Source: " + selectedIndex);
                selectedIndex = mainTabPanel.getTabbedPane().getSelectedIndex(); 
                
                switch(mainTabPanel.getTabbedPane().getSelectedIndex()){
                    //SituationTab
                    case 1:
                        //Check, if all logical context are available
                        checkAvailabilityLogicalContext(lstSituation, lstLogicalContext);
                        
                        situationController.jListValueChanged();
                        break;
                        //Logical Tab
                    case 2:
                        checkAvailabilityLogicalContext(lstLogicalContext, lstLogicalContext);
                        
                        logicalController.jListValueChanged();
                        break;
                        //Transmission
                    case 0:
                        //TODO
                }
            }  
          }
        });
        */
        showMainFrame();
        
        
        
        if(this.lstLogicalContext == null){
            lstLogicalContext = new ArrayList<>();
        }
        
        if(this.lstSituation == null){
            lstSituation = new ArrayList<>();
        }
        
        if(this.lstScenario == null){
            lstScenario = new ArrayList<>();
        }
        
        //initTestData();

        scenarioController = new ScenarioController(simulatorTabPanel, lstScenario, situationController, logicalController, physicalController);       
        situationController = new SituationController(simulatorTabPanel, lstSituation, logicalController, physicalController);
        logicalController = new LogicalController(simulatorTabPanel, lstLogicalContext, physicalController); 
        physicalController = new PhysicalController(simulatorTabPanel);        
        cardController = new CardController(situationController, logicalController, physicalController);
        
        transmissionController = new TransmissionController(transmissionTabPanel);
        testCaseController = new TestCaseController(testCaseTabPanel);
        
        //Open Context Source Details in PopUp
        simulatorTabPanel.getBtAddContextSource().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardController.openChoicePopUp(currentContextInTree);
            }
        });
        
        //Add Context from Tree to TimeLine
        simulatorTabPanel.getBtAddToTimeline().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(currentContextInTree != null){
                        String code = JOptionPane.showInputDialog(simulatorTabPanel, 
                            "To which timeslot should this context be added?", 
                            0);
                        
                        if(code==null) return;
                        
                        int index = -1;
                        try{
                            index = Integer.valueOf(code);
                        }catch(NumberFormatException e){
                           JOptionPane.showMessageDialog(simulatorTabPanel, "No valid timeslot.");
                        }
                        if(index != -1){
                            transmissionController.getScenarioInTimeLine().addChildContext(currentContextInTree, index);
                        }
                        ((AbstractTableModel)(transmissionController.getJTable().getModel())).fireTableStructureChanged();     
                        ((AbstractTableModel)(transmissionController.getJTable().getModel())).fireTableDataChanged();
                }
            }
        });
        
        cardController.getContextChoicePanel().getButtonAddContextSource().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbstractContext choosenContext = cardController.getChoosenContext();
                cardController.closePopUp();
                
                if(currentContextInTree != null){
                    if(currentContextInTree instanceof Scenario){
                   
                        String code = JOptionPane.showInputDialog(simulatorTabPanel, 
                            "In which timeslot should the context source be added?", 
                            Constants.EMPTY_STRING);
                        
                        if(code==null) return;
                        
                        int index = -1;
                        try{
                            index = Integer.valueOf(code);
                        }catch(NumberFormatException e){
                           JOptionPane.showMessageDialog(simulatorTabPanel, "No valid timeslot.");
                        }
                        if(index != -1){
                            currentContextInTree.addChildContext(choosenContext, index);
                        }
                        scenarioController.updateTree();
                    }else{
                        currentContextInTree.addChildContext(choosenContext);
                        
                        if(currentContextInTree instanceof Situation){
                          situationController.updateTree();  
                        }else if(currentContextInTree instanceof LogicalContext){
                          logicalController.updateTree();  
                        }else if(currentContextInTree instanceof PhysicalContext){
                          physicalController.updateTree();  
                        }
                    }
                }
            }
        });
        
        
        
                
        mainFrame.getMenuItemSettings().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String telnetPortString =  JOptionPane.showInputDialog( "Port Number: ",Constants.TELNET_PORT ); 
                
                try{
                    if(telnetPortString!=null){
                        int telnetPort = Integer.parseInt(telnetPortString);
                        Constants.TELNET_PORT = telnetPort;
                        transmissionController.updatePortNumber();
                    }
                }catch(NumberFormatException e){
                    e.printStackTrace();
                }
            }
        });        
        
        mainFrame.getMenuItemSave().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serializeHelperClass.setLstLogicalContext(lstLogicalContext);
                serializeHelperClass.setLstScenario(lstScenario);
                serializeHelperClass.setLstSituation(lstSituation);
                
                String dir = System.getenv("SAVE_DIR");
                System.out.println("DIST_HOME="+dir);
            	
                JFileChooser chooser = new JFileChooser(dir);

                chooser.setSelectedFile(new File("ContextSimulator.ctx"));
                int answer = chooser.showSaveDialog(mainFrame);
                
                if(answer == JFileChooser.APPROVE_OPTION){
                   saveStatus2Disk(chooser.getSelectedFile().getAbsolutePath(), serializeHelperClass); 
                }
            }
        });
        
        mainFrame.getMenuItemLoad().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {              
            	String dir = System.getenv("SAVE_DIR");
            	
                JFileChooser chooser = new JFileChooser(dir);
                chooser.setSelectedFile(new File("ContextSimulator.ctx"));
                int answer = chooser.showOpenDialog(mainFrame);
                
                if(answer == JFileChooser.APPROVE_OPTION){
                   serializeHelperClass = (SerializeHelperClass) loadStatusFromDisk(chooser.getSelectedFile().getAbsolutePath()); 
  
                    //Load all Logical Context Sources
                    lstLogicalContext = serializeHelperClass.getLstLogicalContext();   

                    //Load all Situations  
                    lstSituation = serializeHelperClass.getLstSituation();

                    //Load all Situation Groups  
                    lstScenario = serializeHelperClass.getLstScenario(); 
                }
                
                situationController.setLstSituation(lstSituation);        
                logicalController.setLstLogicalContext(lstLogicalContext);
                scenarioController.setLstScenario(lstScenario);
                        
                situationController.updateModels(-1);
                logicalController.updateModels(-1);
                scenarioController.updateModels(-1);
            }
        });
        
        mainFrame.getMenuItemImport().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {              
            	String dir = System.getenv("IMPORT_DIR");
            	
                JFileChooser chooser = new JFileChooser(dir);
                chooser.setSelectedFile(new File("ContextSimulator.xml"));
                int answer = chooser.showOpenDialog(mainFrame);
                
                if(answer == JFileChooser.APPROVE_OPTION){
                	
                	cemantikaCASEJsonReader.loadDataFromDisk(chooser.getSelectedFile().getAbsolutePath()); 
  
                    //Load all Logical Context Sources
                    lstLogicalContext = cemantikaCASEJsonReader.getLstLogicalContext();
                    lstSituation = cemantikaCASEJsonReader.getLstSituation();
                    lstScenario = cemantikaCASEJsonReader.getLstScenario();

                }
                
                situationController.setLstSituation(lstSituation);        
                logicalController.setLstLogicalContext(lstLogicalContext);
                scenarioController.setLstScenario(lstScenario);
                        
                situationController.updateModels(-1);
                logicalController.updateModels(-1);
                scenarioController.updateModels(-1);
            }
        });
        
        //*** Add small GUIs ***
        simulatorTabPanel.getPanelScenario().add(scenarioController.getScenarioListPanel(), BorderLayout.CENTER);
        simulatorTabPanel.getPanelSituation().add(situationController.getSituationListPanel(), BorderLayout.CENTER);
        simulatorTabPanel.getPanelLogical().add(logicalController.getLogicalContextListPanel(), BorderLayout.CENTER);
        simulatorTabPanel.getPanelPhysical().add(physicalController.getContextSourceListPanel(), BorderLayout.CENTER);
        simulatorTabPanel.getPanelDown().add(transmissionController.getTransmissionPanel(), BorderLayout.CENTER);
        simulatorTabPanel.getPanelSituationExpectedBehavior().add(transmissionController.getSituationExpectedBehaviorPanel(), BorderLayout.CENTER);
    }

    
    private void showMainFrame(){
      mainFrame = new MainFrame();

      mainFrame.getMainPanel().add(mainTabPanel);
      
      mainFrame.setVisible(true);
    }
    
    private void initTestData(){
        sc1.addChildContext(s1, 0);
        sc1.addChildContext(s3, 1);
        sc2.addChildContext(s2, 0);
        s1.addChildContext(s2);
        s2.addChildContext(l1);
        s2.addChildContext(l2);
        s3.addChildContext(l3);
        sc1.addChildContext(gps1,0);
        l1.addChildContext(l2);
        l1.addChildContext(gps2);
        l2.addChildContext(gps3);
        l2.addChildContext(ram1);
        l3.addChildContext(ram2);
        
        lstScenario.add(sc1);
        lstScenario.add(sc2);
        
        lstSituation.add(s1);
        lstSituation.add(s2);
        lstSituation.add(s3);
        
        lstLogicalContext.add(l1);
        lstLogicalContext.add(l2);
        lstLogicalContext.add(l3);
    }
    
    private Object loadStatusFromDisk(String fileName){        
        Object list = new Object();
        ObjectInputStream ois;
        
        if(!new File(fileName).exists()) return null;
        
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(new BufferedInputStream(fis));
            list = ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
       
        return list;
    }

    private void saveStatus2Disk(String fileName, Object saveObject){
        FileOutputStream fos;
       // File f = new File(fileName);
       // if(!f.exists()){
         // f.mkdir();
        //}
        try {
            fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));
            oos.writeObject(saveObject); 
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        } 
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainController();
            }
        });
    }
    
}
