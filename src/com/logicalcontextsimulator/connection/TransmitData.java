/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.connection;

import com.logicalcontextsimulator.connection.interfaces.TelnetConnectable;
import com.logicalcontextsimulator.connection.telnet.TelnetServer;
import com.logicalcontextsimulator.model.context.PhysicalContext;
import com.logicalcontextsimulator.util.Constants;
import java.util.List;

/**
 *
 * @author MHL
 */
public class TransmitData {
    
    private boolean telnetUpdated = false;
    
    private TelnetServer telnetServer;
    
    private TCPServer tcpServer;
    
    public TransmitData(){
        telnetServer = new TelnetServer();
        
        tcpServer = new TCPServer();
    }
    
    public void connect(){
        try{
            telnetServer.connect(Constants.TELNET_PORT);
        }catch(Exception e){
            System.out.println("Connection refused - Modeling Context is still possible");
        }
    }
    
    public void clearData(){
        tcpServer.sendTCPCommand("clear");
    }
    
    public void sendData(List<PhysicalContext> lstContext){
        for(PhysicalContext currentContext: lstContext){
            if(currentContext instanceof TelnetConnectable){
                telnetServer.sendTelnetCommand(currentContext.getCommand());
            }else{
                tcpServer.sendTCPCommand(currentContext.getCommand());
            }
        }
        
        
    }
    
    
}
