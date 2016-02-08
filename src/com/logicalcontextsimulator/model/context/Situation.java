/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.context;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.logicalcontextsimulator.util.Constants;

/**
 *
 * @author MHL
 */
public class Situation extends AbstractContext{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6275195839246421095L;
	
	private List<String> expectedActions = new ArrayList<String>();

	public Situation(String name){
		super();
      setName(name);    
      
      leafIcon = Constants.getInstance().getImageIcon(Constants.URL_ICON_SITUATION);
    }
        
    @Override
    public String getTableRepresentation() {
      return "S: "+getName();
    }

    @Override
    public Color getBackgroundColor() {
        return Constants.COLOR_SITUATION;
    }
    
    @Override
    public void addChildContext(AbstractContext context){
        if(!(context instanceof Scenario)){
          getContextList().add(context);  
        }
    }
    
	public void setExpectedActions(List<String> expectedActions) {
		this.expectedActions = expectedActions;
	}

	public List<String> getExpectedActions() {
		return expectedActions;
	}

}
