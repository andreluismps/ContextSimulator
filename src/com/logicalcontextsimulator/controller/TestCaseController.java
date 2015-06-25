/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.controller;

import java.awt.BorderLayout;

import javax.swing.JList;

import com.logicalcontextsimulator.gui.panel.TestCaseTabPanel;
import com.logicalcontextsimulator.gui.panel.contextList.CurrentTestCasePanel;
import com.logicalcontextsimulator.gui.panel.contextList.ListPanelPhysicalContext;
import com.logicalcontextsimulator.model.renderer.MyPhysicalContextListModel;

/**
 *
 * @author MHL
 */
public class TestCaseController {

    private TestCaseTabPanel testCaseTabPanel;
    
    private ListPanelPhysicalContext listPanelPhysicalContext;
    
    private CurrentTestCasePanel currentTestCasePanel;

    public TestCaseController(TestCaseTabPanel testCaseTabPanel){
       this.testCaseTabPanel = testCaseTabPanel;
       
       listPanelPhysicalContext = new ListPanelPhysicalContext(new MyPhysicalContextListModel());
       listPanelPhysicalContext.getJListContextSource().setLayoutOrientation(JList.HORIZONTAL_WRAP);
       
       currentTestCasePanel = new CurrentTestCasePanel();
        
       testCaseTabPanel.getjPanelUp().add(listPanelPhysicalContext, BorderLayout.CENTER);
       testCaseTabPanel.getjPanelDown().add(currentTestCasePanel, BorderLayout.CENTER);
    }

    
}
