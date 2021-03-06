/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.context;

import java.awt.Color;

import com.logicalcontextsimulator.util.Constants;

/**
 *
 * @author MHL
 */
public class Scenario extends AbstractContext{

    /**
	 * 
	 */
	private static final long serialVersionUID = -6159223338162142559L;

	private int index = 0;
    
    private int currentTransmissionIndex = 0;
    
    public Scenario(String name){
    	super();
      setName(name);    
      
      leafIcon = Constants.getInstance().getImageIcon(Constants.URL_ICON_SCENARIO);
      
      //addChildContext(new TimeSlot(0));
    }
        
    @Override
    public String getTableRepresentation() {
      return "SC: "+getName();
    }

    @Override
    public Color getBackgroundColor() {
        return Constants.COLOR_SITUATION;
    }
    
    @Override
    public void addChildContext(AbstractContext context){
        if(context instanceof TimeSlot){
          getContextList().add(context);  
        }
    }
    
    @Override
    public void addChildContext(AbstractContext context, int timeSlot){
        if(!(context instanceof TimeSlot) &&
           !(context instanceof Scenario)){
            
            while(getContextList().size() <= timeSlot){
               addChildContext(new TimeSlot(++index)); 
            }
            getContextList().get(timeSlot).addChildContext(context);
        }else if(context instanceof Scenario){
            //Just for the case: TIMELINE
            while((getContextList().size()) <= (timeSlot+context.getContextList().size()-1)){
               addChildContext(new TimeSlot(++index)); 
            }
            
            for(int i=timeSlot;i<context.getContextList().size()+timeSlot;i++){
                for(AbstractContext currentContext: context.getContextList().get(i-timeSlot).getContextList()){
                    //getContextList().get(i).addChildContext(currentContext); 
                    TimeSlot t = (TimeSlot) getContextList().get(i);
                    t.addChildContext(currentContext);
                }
            }
        }
    }
    
    public int getMaxDepth(){
        int depth = 0;
        
        for(AbstractContext slot: getContextList()){
            if(slot.getContextList().size()>depth){
                depth = slot.getContextList().size();
            }
        }

        return depth;
    }

    public int getCurrentTransmissionIndex() {
        return currentTransmissionIndex;
    }

    public void setCurrentTransmissionIndex(int currentTransmissionIndex) {
        this.currentTransmissionIndex = currentTransmissionIndex;
    }
    
    public String getSituationExpectedSituation(int index){
    	
    	if (this.getContextList() == null || this.getContextList().isEmpty()) return "";
    	
    	AbstractContext timeSlot = this.getContextList().get(index);
    	
    	if (timeSlot == null) return "";
    	
    	for (AbstractContext abstractContext : timeSlot.getContextList()) {
			if (abstractContext instanceof Situation)
				return "Expected behavior to situation '" + abstractContext.getName() + "':\n" 
					 + ((Situation)abstractContext).getExpectedBehavior();
		}
    	
    	return "";
    }


}
