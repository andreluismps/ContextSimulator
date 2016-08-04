/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.context;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;

import org.reflections.Reflections;

import com.logicalcontextsimulator.model.context.contextSource.Accelerometer;
import com.logicalcontextsimulator.model.context.contextSource.Barometer;
import com.logicalcontextsimulator.model.context.contextSource.Battery;
import com.logicalcontextsimulator.model.context.contextSource.Bluetooth;
import com.logicalcontextsimulator.model.context.contextSource.CPU;
import com.logicalcontextsimulator.model.context.contextSource.Calendar;
import com.logicalcontextsimulator.model.context.contextSource.Camera;
import com.logicalcontextsimulator.model.context.contextSource.CellID;
import com.logicalcontextsimulator.model.context.contextSource.GPS;
import com.logicalcontextsimulator.model.context.contextSource.Gyroscope;
import com.logicalcontextsimulator.model.context.contextSource.HTTPResponse;
import com.logicalcontextsimulator.model.context.contextSource.HardDisk;
import com.logicalcontextsimulator.model.context.contextSource.Infrared;
import com.logicalcontextsimulator.model.context.contextSource.LightSensor;
import com.logicalcontextsimulator.model.context.contextSource.Magnetometer;
import com.logicalcontextsimulator.model.context.contextSource.Microphone;
import com.logicalcontextsimulator.model.context.contextSource.NetworkConnection;
import com.logicalcontextsimulator.model.context.contextSource.QRCode;
import com.logicalcontextsimulator.model.context.contextSource.RAM;
import com.logicalcontextsimulator.model.context.contextSource.RFID;
import com.logicalcontextsimulator.model.context.contextSource.SDCard;
import com.logicalcontextsimulator.model.context.contextSource.Thermometer;
import com.logicalcontextsimulator.model.context.contextSource.TimeDate;
import com.logicalcontextsimulator.model.context.contextSource.USBCable;
import com.logicalcontextsimulator.model.context.contextSource.WiFi;
import com.logicalcontextsimulator.util.GsonUtils;
import com.logicalcontextsimulator.util.HashCodeUtil;
import com.logicalcontextsimulator.util.RuntimeTypeAdapterFactory;

/**
 *
 * @author MHL
 */
public abstract class AbstractContext implements Serializable, Cloneable, Comparable<AbstractContext>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2703014888130627743L;

	private List<AbstractContext> lstContext = new ArrayList<AbstractContext>();
    
    private String name;
    
    protected transient ImageIcon leafIcon;
    
    private static final RuntimeTypeAdapterFactory<AbstractContext> adapter = RuntimeTypeAdapterFactory.of(AbstractContext.class);

	private static final HashSet<Class<?>> registeredClasses = new HashSet<Class<?>>();

	static {
		GsonUtils.registerType(adapter);
		Reflections reflections = new Reflections("com.logicalcontextsimulator.model.context");
		
		Set<Class<? extends AbstractContext>> allClasses = reflections.getSubTypesOf(AbstractContext.class);
		System.out.println("context size = " + allClasses.size());
		reflections = new Reflections("com.logicalcontextsimulator.model.context.contextSource");
		allClasses.addAll(reflections.getSubTypesOf(AbstractContext.class));
		System.out.println("contextSource after size = " + allClasses.size());
		for (Class<? extends AbstractContext> clazz : allClasses) {
			System.out.println(clazz.getName());
			adapter.registerSubtype(clazz);
		}
		//TODO fix the reflection on mac os terminal
				new TimeSlot(0);
				new Accelerometer();
				new Barometer();
				new Battery();
				new Bluetooth();
				new Calendar();
				new Camera();
				new CellID();
				new CPU();
				new GPS();
				new Gyroscope();
				new HardDisk();
				new HTTPResponse();
				new Infrared();
				new LightSensor();
				new Magnetometer();
				new Microphone();
				new NetworkConnection();
				new QRCode();
				new RAM();
				new RFID();
				new SDCard();
				new Thermometer();
				new TimeDate();
				new USBCable();
				new WiFi();
	}

	private synchronized void registerClass() {
		if (!AbstractContext.registeredClasses.contains(this.getClass())) {
			adapter.registerSubtype(this.getClass());
		}
	}

	public AbstractContext() {
		registerClass();
	}
    
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
		return result;
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
	
	@Override
	public String toString() {
		
		return name + "["+ lstContext.toString() +"]";
	}
	
	@Override
	public int compareTo(AbstractContext abstractContext) {
		return this.name.compareTo(abstractContext.name);
	}  
}
