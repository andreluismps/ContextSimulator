/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.context;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com.logicalcontextsimulator.util.HashCodeUtil;

/**
 *
 * @author MHL
 */
public abstract class AbstractContext implements Serializable, Cloneable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2703014888130627743L;

	private List<AbstractContext> lstContext = new ArrayList<>();
    
    private String name;
    
    protected ImageIcon leafIcon;
    
    public abstract String getTableRepresentation();
    
    public abstract Color getBackgroundColor();
    
    public void addChildContext(AbstractContext context, int timeSlot){
        addChildContext(context);
    }
    
    public abstract void addChildContext(AbstractContext context);
    
    public List<AbstractContext> getContextList(){
        return lstContext;
    }
    
    public void setContextList(List<AbstractContext> list){
        lstContext = list;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void removeChildContext(AbstractContext context){
        lstContext.remove(context);
    }  
    
    public ImageIcon getLeafIcon() {
        if(leafIcon != null)
            return leafIcon;
        else
            return new ImageIcon();
    }
    
  @Override
  public AbstractContext clone()
  {
    try
    {
      return (AbstractContext) super.clone();
    }
    catch ( CloneNotSupportedException e ) {
      // Kann eigentlich nicht passieren, da Cloneable
      throw new InternalError();
    }
  }

	@Override
	public int hashCode() {
		int result = HashCodeUtil.SEED;
		result = HashCodeUtil.hash(result, name);
		result = HashCodeUtil.hash(result, lstContext);
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AbstractContext))
            return false;
        if (obj == this)
            return true;

        AbstractContext rhs = (AbstractContext) obj;
        return name.equals(rhs.name) && lstContext.equals(rhs.lstContext);
	}

  
  
}
