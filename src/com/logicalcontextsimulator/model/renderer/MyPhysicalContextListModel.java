/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.renderer;

import javax.swing.AbstractListModel;

import com.logicalcontextsimulator.util.Constants;

/**
 *
 * @author MHL
 */
public class MyPhysicalContextListModel extends AbstractListModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5236446244570816421L;
	private ContextListItem[] strings = null; 
    private ContextListItem[] all = {new ContextListItem(Constants.ACCELEROMETER), new ContextListItem(Constants.THERMOMETER), new ContextListItem(Constants.BAROMETER), new ContextListItem(Constants.LIGHTSENSOR), new ContextListItem(Constants.MAGNETOMETER), new ContextListItem(Constants.GYROSCOPE), new ContextListItem(Constants.TIMEDATE), new ContextListItem(Constants.CALENDAR), new ContextListItem(Constants.GPS), new ContextListItem(Constants.BATTERY), new ContextListItem(Constants.RAM), new ContextListItem(Constants.DISK), new ContextListItem(Constants.CPU), new ContextListItem(Constants.SDCARD), new ContextListItem(Constants.USBCABLE), new ContextListItem(Constants.MICROPHONE), new ContextListItem(Constants.CAMERA), new ContextListItem(Constants.RFID), new ContextListItem(Constants.QRCODE), new ContextListItem(Constants.BLUETOOTH), new ContextListItem(Constants.INFRARED), new ContextListItem(Constants.HTTP), new ContextListItem(Constants.WIFI), new ContextListItem(Constants.NETWORK), new ContextListItem(Constants.CELLID)};
    private ContextListItem[] location = {new ContextListItem(Constants.ACCELEROMETER), new ContextListItem(Constants.THERMOMETER), new ContextListItem(Constants.BAROMETER), new ContextListItem(Constants.LIGHTSENSOR), new ContextListItem(Constants.MAGNETOMETER), new ContextListItem(Constants.GPS),  new ContextListItem(Constants.CAMERA), new ContextListItem(Constants.WIFI), new ContextListItem(Constants.CELLID)};
    private ContextListItem[] time = {new ContextListItem(Constants.TIMEDATE), new ContextListItem(Constants.CALENDAR)};
    private ContextListItem[] individual = {new ContextListItem(Constants.ACCELEROMETER), new ContextListItem(Constants.GYROSCOPE), new ContextListItem(Constants.CAMERA)};
    private ContextListItem[] device = {new ContextListItem(Constants.BATTERY), new ContextListItem(Constants.RAM), new ContextListItem(Constants.DISK), new ContextListItem(Constants.CPU), new ContextListItem(Constants.SDCARD), new ContextListItem(Constants.USBCABLE)};
    private ContextListItem[] virtual = {new ContextListItem(Constants.CALENDAR), new ContextListItem(Constants.HTTP)};
    private ContextListItem[] relation = {new ContextListItem(Constants.NETWORK), new ContextListItem(Constants.BLUETOOTH), new ContextListItem(Constants.INFRARED), new ContextListItem(Constants.CELLID), new ContextListItem(Constants.CAMERA), new ContextListItem(Constants.MICROPHONE)};
    
    /*
    private ContextListItem[] all = {new ContextListItem(Constants.ACCELEROMETER), new ContextListItem(Constants.THERMOMETER), new ContextListItem(Constants.BAROMETER), new ContextListItem(Constants.LIGHTSENSOR), new ContextListItem(Constants.MAGNETOMETER), new ContextListItem(Constants.GYROSCOPE), new ContextListItem(Constants.TIMEDATE), new ContextListItem(Constants.CALENDAR), new ContextListItem(Constants.GPS), new ContextListItem(Constants.BATTERY), new ContextListItem(Constants.RAM), new ContextListItem(Constants.DISK), new ContextListItem(Constants.CPU), new ContextListItem(Constants.SDCARD), new ContextListItem(Constants.USBCABLE), new ContextListItem(Constants.MICROPHONE), new ContextListItem(Constants.CAMERA), new ContextListItem(Constants.RFID), new ContextListItem(Constants.QRCODE), new ContextListItem(Constants.BLUETOOTH), new ContextListItem(Constants.INFRARED), new ContextListItem(Constants.HTTP), new ContextListItem(Constants.WIFI), new ContextListItem(Constants.NETWORK), new ContextListItem(Constants.CELLID)};
    private ContextListItem[] location = {new ContextListItem(Constants.ACCELEROMETER), new ContextListItem(Constants.THERMOMETER), new ContextListItem(Constants.BAROMETER), new ContextListItem(Constants.LIGHTSENSOR), new ContextListItem(Constants.MAGNETOMETER), new ContextListItem(Constants.GYROSCOPE), new ContextListItem(Constants.TIMEDATE), new ContextListItem(Constants.CALENDAR), new ContextListItem(Constants.GPS), new ContextListItem(Constants.BATTERY), new ContextListItem(Constants.RAM), new ContextListItem(Constants.DISK), new ContextListItem(Constants.CPU), new ContextListItem(Constants.SDCARD), new ContextListItem(Constants.USBCABLE), new ContextListItem(Constants.MICROPHONE), new ContextListItem(Constants.CAMERA), new ContextListItem(Constants.RFID), new ContextListItem(Constants.QRCODE), new ContextListItem(Constants.BLUETOOTH), new ContextListItem(Constants.INFRARED), new ContextListItem(Constants.HTTP), new ContextListItem(Constants.WIFI), new ContextListItem(Constants.NETWORK), new ContextListItem(Constants.CELLID)};
    private ContextListItem[] time = {new ContextListItem(Constants.ACCELEROMETER), new ContextListItem(Constants.THERMOMETER), new ContextListItem(Constants.BAROMETER), new ContextListItem(Constants.LIGHTSENSOR), new ContextListItem(Constants.MAGNETOMETER), new ContextListItem(Constants.GYROSCOPE), new ContextListItem(Constants.TIMEDATE), new ContextListItem(Constants.CALENDAR), new ContextListItem(Constants.GPS), new ContextListItem(Constants.BATTERY), new ContextListItem(Constants.RAM), new ContextListItem(Constants.DISK), new ContextListItem(Constants.CPU), new ContextListItem(Constants.SDCARD), new ContextListItem(Constants.USBCABLE), new ContextListItem(Constants.MICROPHONE), new ContextListItem(Constants.CAMERA), new ContextListItem(Constants.RFID), new ContextListItem(Constants.QRCODE), new ContextListItem(Constants.BLUETOOTH), new ContextListItem(Constants.INFRARED), new ContextListItem(Constants.HTTP), new ContextListItem(Constants.WIFI), new ContextListItem(Constants.NETWORK), new ContextListItem(Constants.CELLID)};
    private ContextListItem[] individual = {new ContextListItem(Constants.ACCELEROMETER), new ContextListItem(Constants.THERMOMETER), new ContextListItem(Constants.BAROMETER), new ContextListItem(Constants.LIGHTSENSOR), new ContextListItem(Constants.MAGNETOMETER), new ContextListItem(Constants.GYROSCOPE), new ContextListItem(Constants.TIMEDATE), new ContextListItem(Constants.CALENDAR), new ContextListItem(Constants.GPS), new ContextListItem(Constants.BATTERY), new ContextListItem(Constants.RAM), new ContextListItem(Constants.DISK), new ContextListItem(Constants.CPU), new ContextListItem(Constants.SDCARD), new ContextListItem(Constants.USBCABLE), new ContextListItem(Constants.MICROPHONE), new ContextListItem(Constants.CAMERA), new ContextListItem(Constants.RFID), new ContextListItem(Constants.QRCODE), new ContextListItem(Constants.BLUETOOTH), new ContextListItem(Constants.INFRARED), new ContextListItem(Constants.HTTP), new ContextListItem(Constants.WIFI), new ContextListItem(Constants.NETWORK), new ContextListItem(Constants.CELLID)};
    private ContextListItem[] device = {new ContextListItem(Constants.ACCELEROMETER), new ContextListItem(Constants.THERMOMETER), new ContextListItem(Constants.BAROMETER), new ContextListItem(Constants.LIGHTSENSOR), new ContextListItem(Constants.MAGNETOMETER), new ContextListItem(Constants.GYROSCOPE), new ContextListItem(Constants.TIMEDATE), new ContextListItem(Constants.CALENDAR), new ContextListItem(Constants.GPS), new ContextListItem(Constants.BATTERY), new ContextListItem(Constants.RAM), new ContextListItem(Constants.DISK), new ContextListItem(Constants.CPU), new ContextListItem(Constants.SDCARD), new ContextListItem(Constants.USBCABLE), new ContextListItem(Constants.MICROPHONE), new ContextListItem(Constants.CAMERA), new ContextListItem(Constants.RFID), new ContextListItem(Constants.QRCODE), new ContextListItem(Constants.BLUETOOTH), new ContextListItem(Constants.INFRARED), new ContextListItem(Constants.HTTP), new ContextListItem(Constants.WIFI), new ContextListItem(Constants.NETWORK), new ContextListItem(Constants.CELLID)};
    private ContextListItem[] virtual = {new ContextListItem(Constants.ACCELEROMETER), new ContextListItem(Constants.THERMOMETER), new ContextListItem(Constants.BAROMETER), new ContextListItem(Constants.LIGHTSENSOR), new ContextListItem(Constants.MAGNETOMETER), new ContextListItem(Constants.GYROSCOPE), new ContextListItem(Constants.TIMEDATE), new ContextListItem(Constants.CALENDAR), new ContextListItem(Constants.GPS), new ContextListItem(Constants.BATTERY), new ContextListItem(Constants.RAM), new ContextListItem(Constants.DISK), new ContextListItem(Constants.CPU), new ContextListItem(Constants.SDCARD), new ContextListItem(Constants.USBCABLE), new ContextListItem(Constants.MICROPHONE), new ContextListItem(Constants.CAMERA), new ContextListItem(Constants.RFID), new ContextListItem(Constants.QRCODE), new ContextListItem(Constants.BLUETOOTH), new ContextListItem(Constants.INFRARED), new ContextListItem(Constants.HTTP), new ContextListItem(Constants.WIFI), new ContextListItem(Constants.NETWORK), new ContextListItem(Constants.CELLID)};
    private ContextListItem[] relation = {new ContextListItem(Constants.ACCELEROMETER), new ContextListItem(Constants.THERMOMETER), new ContextListItem(Constants.BAROMETER), new ContextListItem(Constants.LIGHTSENSOR), new ContextListItem(Constants.MAGNETOMETER), new ContextListItem(Constants.GYROSCOPE), new ContextListItem(Constants.TIMEDATE), new ContextListItem(Constants.CALENDAR), new ContextListItem(Constants.GPS), new ContextListItem(Constants.BATTERY), new ContextListItem(Constants.RAM), new ContextListItem(Constants.DISK), new ContextListItem(Constants.CPU), new ContextListItem(Constants.SDCARD), new ContextListItem(Constants.USBCABLE), new ContextListItem(Constants.MICROPHONE), new ContextListItem(Constants.CAMERA), new ContextListItem(Constants.RFID), new ContextListItem(Constants.QRCODE), new ContextListItem(Constants.BLUETOOTH), new ContextListItem(Constants.INFRARED), new ContextListItem(Constants.HTTP), new ContextListItem(Constants.WIFI), new ContextListItem(Constants.NETWORK), new ContextListItem(Constants.CELLID)};
    */ 
    
    
    private String mode = Constants.ALL_CATEGORIES;
    
    private void updateList(){

        switch(mode){
            case Constants.ALL_CATEGORIES:
                strings = all;
            break;
            case Constants.LOCATION:
                strings = location;
            break;
            case Constants.TIME:
                strings = time;
            break;
            case Constants.INDIVIDUAL:
                strings = individual;
            break;
            case Constants.DEVICE:
                strings = device;
            break;
            case Constants.VIRTUAL:
                strings = virtual;
            break;
            case Constants.RELATION:
                strings = relation;
            break;
        }
    }

    @Override
    public int getSize() {
        updateList();
        
        return strings.length;
    }

    @Override
    public Object getElementAt(int index) {
        updateList();
        
        return strings[index];
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
 
    

    
}
