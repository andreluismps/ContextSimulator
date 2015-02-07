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
public class HTTPResponse extends PhysicalContext{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -2533753255601745451L;

	public HTTPResponse(){
        super(Constants.HTTP);
    }
    
}
