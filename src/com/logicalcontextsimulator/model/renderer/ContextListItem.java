/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.renderer;

import com.logicalcontextsimulator.util.Constants;
import javax.swing.ImageIcon;

/**
 *
 * @author MHL
 */
public class ContextListItem {
    
    private ImageIcon icon;
    
    private String iconPath;
    
    private String name;
    
    public ContextListItem(String contextSource){
        switch(contextSource){
            case Constants.ACCELEROMETER:
              iconPath = Constants.URL_ICON_LIST_ACCELEROMETER;
              name = Constants.ACCELEROMETER;
            break;
            case Constants.THERMOMETER:
              iconPath = Constants.URL_ICON_LIST_THERMOMETER;
              name = Constants.THERMOMETER;
            break;
            case Constants.BAROMETER:
              iconPath = Constants.URL_ICON_LIST_BAROMETER;
              name = Constants.BAROMETER;
            break;
            case Constants.LIGHTSENSOR:
              iconPath = Constants.URL_ICON_LIST_LIGHTSENSOR;
              name = Constants.LIGHTSENSOR;
            break;
            case Constants.MAGNETOMETER:
              iconPath = Constants.URL_ICON_LIST_MAGNETOMETER;
              name = Constants.MAGNETOMETER;
            break;
            case Constants.GYROSCOPE:
              iconPath = Constants.URL_ICON_LIST_GYROSCOPE;
              name = Constants.GYROSCOPE;
            break;
            case Constants.TIMEDATE:
              iconPath = Constants.URL_ICON_LIST_TIMEDATE;
              name = Constants.TIMEDATE;
            break;
            case Constants.CALENDAR:
              iconPath = Constants.URL_ICON_LIST_CALENDAR;
              name = Constants.CALENDAR;
            break;
            case Constants.GPS:
              iconPath = Constants.URL_ICON_LIST_GPS;
              name = Constants.GPS;
            break;
            case Constants.BATTERY:
              iconPath = Constants.URL_ICON_LIST_BATTERY;
              name = Constants.BATTERY;
            break;
            case Constants.RAM:
              iconPath = Constants.URL_ICON_LIST_RAM;
              name = Constants.RAM;
            break;
            case Constants.DISK:
              iconPath = Constants.URL_ICON_LIST_DISK;
              name = Constants.DISK;
            break;
            case Constants.CPU:
              iconPath = Constants.URL_ICON_LIST_CPU;
              name = Constants.CPU;
            break;
            case Constants.SDCARD:
              iconPath = Constants.URL_ICON_LIST_SDCARD;
              name = Constants.SDCARD;
            break;
            case Constants.USBCABLE:
              iconPath = Constants.URL_ICON_LIST_USBCABLE;
              name = Constants.USBCABLE;
            break;
            case Constants.MICROPHONE:
              iconPath = Constants.URL_ICON_LIST_MICROPHONE;
              name = Constants.MICROPHONE;
            break;
            case Constants.CAMERA:
              iconPath = Constants.URL_ICON_LIST_CAMERA;
              name = Constants.CAMERA;
            break;
            case Constants.RFID:
              iconPath = Constants.URL_ICON_LIST_RFID;
              name = Constants.RFID;
            break;
            case Constants.QRCODE:
              iconPath = Constants.URL_ICON_LIST_QRCODE;
              name = Constants.QRCODE;
            break;
            case Constants.BLUETOOTH:
              iconPath = Constants.URL_ICON_LIST_BLUETOOTH;
              name = Constants.BLUETOOTH;
            break;
            case Constants.INFRARED:
              iconPath = Constants.URL_ICON_LIST_INFRARED;
              name = Constants.INFRARED;
            break;
            case Constants.HTTP:
              iconPath = Constants.URL_ICON_LIST_HTTP;
              name = Constants.HTTP;
            break;
            case Constants.WIFI:
              iconPath = Constants.URL_ICON_LIST_WIFI;
              name = Constants.WIFI;
            break;
            case Constants.NETWORK:
              iconPath = Constants.URL_ICON_LIST_NETWORK;
              name = Constants.NETWORK;
            break;
            case Constants.CELLID:
              iconPath = Constants.URL_ICON_LIST_CELLID;
              name = Constants.CELLID;
            break;
            default:
              iconPath = null;
              name = Constants.EMPTY_STRING;
        }
        
        if(iconPath != null){
            icon = Constants.getInstance().getImageIcon(iconPath);
        }
    }
    
    public ImageIcon getIcon(){
        return icon;
    }
    
    public String getName(){
        return name;
    }
}
