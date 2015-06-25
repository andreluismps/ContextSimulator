/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.util;

import java.io.Serializable;
import java.util.List;

import com.logicalcontextsimulator.model.context.AbstractContext;

/**
 *
 * @author MHL
 */
public class SerializeHelperClass implements Serializable{
    
		/**
	 * 
	 */
	private static final long serialVersionUID = 1180275648919502702L;

		private List<AbstractContext> lstLogicalContext;
        
        private List<AbstractContext> lstSituation;
        
        private List<AbstractContext> lstScenario;
        
        
        public SerializeHelperClass(){
            
        }

    public List<AbstractContext> getLstLogicalContext() {
        return lstLogicalContext;
    }

    public List<AbstractContext> getLstSituation() {
        return lstSituation;
    }

    public List<AbstractContext> getLstScenario() {
        return lstScenario;
    }

    public void setLstLogicalContext(List<AbstractContext> lstLogicalContext) {
        this.lstLogicalContext = lstLogicalContext;
    }

    public void setLstSituation(List<AbstractContext> lstSituation) {
        this.lstSituation = lstSituation;
    }

    public void setLstScenario(List<AbstractContext> lstScenario) {
        this.lstScenario = lstScenario;
    }
        
        
    
    
}
