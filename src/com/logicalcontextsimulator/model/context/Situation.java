/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.context;

import com.logicalcontextsimulator.util.Constants;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author MHL
 */
public class Situation extends AbstractContext{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6275195839246421095L;

	public Situation(String name){
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


}
