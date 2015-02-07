/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MHL
 */
public class TCPServer {

    private Socket mClientSocket;
    private ServerSocket mServerSocket = null;
    private PrintWriter out;

    public TCPServer(int n) {
        
    }
    public TCPServer() {
        try {
            mServerSocket = new ServerSocket(8010);
        } catch (IOException e) {
            // mSensorSimulator.addMessage("Could not listen on port: " +
            // mPort);
            e.printStackTrace();
            return;
        }
        
		Thread t = new Thread(new Runnable() {
			public void run() {
		        try {
		            mClientSocket  = mServerSocket.accept();
		        } catch (IOException ex) {
		            Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
		        }
		        try {
		            out = new PrintWriter(mClientSocket.getOutputStream(), true);
		            out.println("SensorSimulator");
		            
		        } catch (IOException ex) {
		            Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
		        }				
			}
		});

		t.start();
    }  
        
    public void sendTCPCommand(String command) {
        if (out != null) {
            out.println(command);
        }
    }
    
}
