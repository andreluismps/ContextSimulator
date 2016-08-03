/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.util;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;

import com.logicalcontextsimulator.model.context.Situation;

/**
 *
 * @author MHL
 */
public class Constants {
    
    private static Constants constants = new Constants();
    
    private Constants(){}
    
    public static Constants getInstance(){
        return constants;
    }
    
    private URL url;
    
    public ImageIcon getImageIcon(String icon_path){
       url = Situation.class.getClassLoader().getResource(icon_path);

       ImageIcon imageIcon = new ImageIcon(url);
       
       return imageIcon;
       
    }
    
    
    public static int TELNET_PORT = 5554;
    
    public final static String EMPTY_STRING = "";
    
    //*** Image Icons ***
    public final static String URL_ICON_SCENARIO = "icons/scenario.png";
    
    public final static String URL_ICON_SITUATION = "icons/situation.png";
    
    public final static String URL_ICON_LOGICAL = "icons/logical.png";
        
    public final static String URL_ICON_PHYSICAL = "icons/physical.png";
  
    public final static String URL_ICON_SIMULATOR_TAB = "icons/SimulatorTab.png";
    
    public final static String URL_ICON_SCENARIO_TAB = "icons/ScenarioTab.png";
  
    public final static String URL_ICON_SITUATION_TAB = "icons/SituationTab.png";
    
    public final static String URL_ICON_TRANSMISSION_TAB = "icons/TransmissionTab.png";
    
    public final static String URL_ICON_TESTCASE_TAB = "icons/TestCaseTab.png";
    
    public final static String URL_ICON_LOGICAL_TAB = "icons/LogicalTab.png";
    
    public final static String URL_ICON_PHYSICAL_TAB = "icons/PhysicalTab.png";
    
    public final static String URL_ICON_ARROW = "icons/Arrow.png";
    
    public final static String URL_ICON_BUTTON_ADD = "icons/buttonAdd.png";
    
    public final static String URL_ICON_BUTTON_COPY = "icons/buttonCopy.png";
    
    public final static String URL_ICON_BUTTON_DELETE = "icons/buttonDelete.png";
   
    public final static String URL_ICON_BUTTON_SAVE = "icons/buttonSave.png";
    
    public final static String URL_ICON_ARROW_LEFT = "icons/arrowLeft.png";
    
    public final static String URL_ICON_ARROW_RIGHT = "icons/arrowRight.png";
    
    public final static String URL_ICON_PLAY = "icons/play.png";
    
    public final static String URL_ICON_PAUSE = "icons/pause.png";
    
    public final static String URL_ICON_PC = "icons/pc.png";
    
    public final static String URL_ICON_CELLPHONE = "icons/cellPhone.png";
    
    public final static String URL_ICON_OPEN = "icons/open.png";
    
    public final static String URL_ICON_SAVE = "icons/save.png";
    
    public final static String URL_ICON_IMPORT = "icons/import.png";
   
    public final static String URL_ICON_SETTINGS = "icons/settings.png";
    
    //*** Image Icon for context sources ***
    public final static String URL_ICON_LIST_ACCELEROMETER = "icons/listIcons/accelerometer.png";    
    
    public final static String URL_ICON_LIST_THERMOMETER = "icons/listIcons/thermometer.png";    
    
    public final static String URL_ICON_LIST_BAROMETER = "icons/listIcons/barometer.png";    
    
    public final static String URL_ICON_LIST_LIGHTSENSOR = "icons/listIcons/lightsensor.png";  
    
    public final static String URL_ICON_LIST_MAGNETOMETER = "icons/listIcons/magnetometer.png";
    
    public final static String URL_ICON_LIST_GYROSCOPE = "icons/listIcons/gyroscope.png";
    
    public final static String URL_ICON_LIST_TIMEDATE = "icons/listIcons/timedate.png";
    
    public final static String URL_ICON_LIST_CALENDAR = "icons/listIcons/calendar.png";
    
    public final static String URL_ICON_LIST_GPS = "icons/listIcons/gps.png";
    
    public final static String URL_ICON_LIST_BATTERY = "icons/listIcons/battery.png";
    
    public final static String URL_ICON_LIST_RAM = "icons/listIcons/ram.png";
    
    public final static String URL_ICON_LIST_DISK = "icons/listIcons/disk.png";
    
    public final static String URL_ICON_LIST_CPU = "icons/listIcons/cpu.png";
    
    public final static String URL_ICON_LIST_SDCARD = "icons/listIcons/sdcard.png";
    
    public final static String URL_ICON_LIST_USBCABLE = "icons/listIcons/usbcable.png";
    
    public final static String URL_ICON_LIST_MICROPHONE = "icons/listIcons/microphone.png";
    
    public final static String URL_ICON_LIST_CAMERA = "icons/listIcons/camera.png";
    
    public final static String URL_ICON_LIST_RFID = "icons/listIcons/rfid.png";
    
    public final static String URL_ICON_LIST_QRCODE = "icons/listIcons/qrcode.png";
    
    public final static String URL_ICON_LIST_BLUETOOTH = "icons/listIcons/bluetooth.png";
    
    public final static String URL_ICON_LIST_INFRARED = "icons/listIcons/infrared.png";
    
    public final static String URL_ICON_LIST_HTTP = "icons/listIcons/http.png";
    
    public final static String URL_ICON_LIST_WIFI = "icons/listIcons/wifi.png";
    
    public final static String URL_ICON_LIST_NETWORK = "icons/listIcons/network.png";
    
    public final static String URL_ICON_LIST_CELLID = "icons/listIcons/cellid.png";  
  
    //*** Differntiate between Physical, Logical and Situations ***
    public final static String PHYSICAL = "Physical Context";
    
    public final static String LOGICAL = "Logical Context";
    
    public final static String SITUATION = "Situation";
    
    public final static String SCENARIO = "Scenario";
    
    public final static String ALL_SITUATIONS = "All Situations";
    
    //*** Context Source Names ***
    public final static String ACCELEROMETER = "Accelerometer";    
    
    public final static String THERMOMETER = "Thermometer";    
    
    public final static String BAROMETER = "Barometer";    
    
    public final static String LIGHTSENSOR = "Light-Sensor";  
    
    public final static String MAGNETOMETER = "Magnetometer";
    
    public final static String GYROSCOPE = "Gyroscope";
    
    public final static String TIMEDATE = "Time and Date";
    
    public final static String CALENDAR = "Appointment";
    
    public final static String GPS = "GPS";
    
    public final static String BATTERY = "Battery";
    
    public final static String RAM = "RAM";
    
    public final static String DISK = "Hard Disk";
    
    public final static String CPU = "CPU";
    
    public final static String SDCARD = "SD-Card";
    
    public final static String USBCABLE = "USB-Cable";
    
    public final static String MICROPHONE = "Microphone";
    
    public final static String CAMERA = "Camera";
    
    public final static String RFID = "RFID";
    
    public final static String QRCODE = "QR-Code";
    
    public final static String BLUETOOTH = "Bluetooth";
    
    public final static String INFRARED = "Infrared";
    
    public final static String HTTP = "HTTP-Response";
    
    public final static String WIFI = "Wi-Fi";
    
    public final static String NETWORK = "Network Connections";
    
    public final static String CELLID = "Cell ID";  
    
    //*** Colour ***
    public final static Color COLOR_SITUATION = Color.WHITE;
    
    public final static Color COLOR_LOGICAL = Color.WHITE;
    
    public final static Color COLOR_PHYSICAL = Color.WHITE;
    
    //*** Physical Context Categories ***
    public final static String ALL_CATEGORIES = "All";   
    
    public final static String LOCATION = "Location";

    public final static String TIME = "Time";

    public final static String INDIVIDUAL = "Individual";

    public final static String DEVICE = "Device";

    public final static String VIRTUAL = "Virtual";

    public final static String RELATION = "Relation";








    
    
}
