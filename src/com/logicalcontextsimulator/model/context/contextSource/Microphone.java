/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.context.contextSource;

import com.logicalcontextsimulator.model.context.PhysicalContext;
import com.logicalcontextsimulator.util.Constants;

/**
 *
 * @author MHL
 */
public class Microphone extends PhysicalContext{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 8705573373555955840L;

	public Microphone(){
        super(Constants.MICROPHONE);
    }
    
}
