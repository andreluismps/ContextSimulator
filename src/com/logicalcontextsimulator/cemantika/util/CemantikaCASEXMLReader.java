/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.cemantika.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import com.logicalcontextsimulator.model.context.AbstractContext;
import com.logicalcontextsimulator.model.context.LogicalContext;
import com.logicalcontextsimulator.model.context.PhysicalContext;
import com.logicalcontextsimulator.model.context.Scenario;
import com.logicalcontextsimulator.model.context.Situation;
import com.logicalcontextsimulator.model.context.contextSource.LightSensor;

/**
 *
 * @author andreluismps
 */
public class CemantikaCASEXMLReader {
    private List<AbstractContext> lstLogicalContext;
    private List<AbstractContext> lstSituation;
    private List<AbstractContext> lstScenario;

	public List<AbstractContext> getLstLogicalContext() {
		return lstLogicalContext;
	}

	public void setLstLogicalContext(List<AbstractContext> lstLogicalContext) {
		this.lstLogicalContext = lstLogicalContext;
	}

	public List<AbstractContext> getLstSituation() {
		return lstSituation;
	}

	public void setLstSituation(List<AbstractContext> lstSituation) {
		this.lstSituation = lstSituation;
	}

	public List<AbstractContext> getLstScenario() {
		return lstScenario;
	}

	public void setLstScenario(List<AbstractContext> lstScenario) {
		this.lstScenario = lstScenario;
	}

	public void loadDataFromDisk(String absolutePath) {
		com.logicalcontextsimulator.cemantika.model.Scenario cemantikaScenario = new com.logicalcontextsimulator.cemantika.model.Scenario();
		
		File xmlSimulador = new File(absolutePath);
		
		XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource(xmlSimulador);
        try{
        	XMLStreamReader xsr = xif.createXMLStreamReader(xml);
            xsr.nextTag();
            //while(!xsr.getLocalName().equals("scenario")) {
            //    xsr.nextTag();
            //}
     
            JAXBContext jc = JAXBContext.newInstance(com.logicalcontextsimulator.cemantika.model.Scenario.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<com.logicalcontextsimulator.cemantika.model.Scenario> jb = unmarshaller.unmarshal(xsr, com.logicalcontextsimulator.cemantika.model.Scenario.class);
            cemantikaScenario = jb.getValue();
        }catch (Exception e) {
			e.printStackTrace();
		}
        AbstractContext scenario = new Scenario(cemantikaScenario.getName());
        lstScenario = new ArrayList<AbstractContext>();
        lstSituation = new ArrayList<AbstractContext>();
        lstLogicalContext = new ArrayList<AbstractContext>();
        
        
        int timeSlot = 0;
        for (com.logicalcontextsimulator.cemantika.model.Situation cemantikaSituation : cemantikaScenario.getSituations()) {
        	AbstractContext situation = new Situation(cemantikaSituation.getName());
        	List<AbstractContext>logicalContexts = new ArrayList<AbstractContext>();
        	for (com.logicalcontextsimulator.cemantika.model.LogicalContext cemantikaLogicalContext : cemantikaSituation.getLogicalContexts()) {
        		AbstractContext logical = new LogicalContext(cemantikaLogicalContext.getName());
        		List<AbstractContext> lstPhysicalContext = new ArrayList<AbstractContext>();
        		for (String sensor : cemantikaLogicalContext.getSensors()) {
        			try {
						Class<?> c = Class.forName("com.logicalcontextsimulator.model.context.contextSource."+ sensor);
						PhysicalContext physicalContext = (PhysicalContext) c.newInstance();
	        			lstPhysicalContext.add(physicalContext);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
        		logical.setContextList(lstPhysicalContext);
        		if (!lstLogicalContext.contains(logical)){
        			lstLogicalContext.add(logical);
        		}else{
        			logical = lstLogicalContext.get(lstLogicalContext.indexOf(logical));
        		}
        		logicalContexts.add(logical);
			}
        	situation.setContextList(logicalContexts);
        	lstSituation.add(situation);
        	scenario.addChildContext(situation, timeSlot++);
		}
       // scenario.setContextList(lstSituation);
        lstScenario.add(scenario);
        
//        lstLogicalContext = new ArrayList<AbstractContext>();
//        int i = 0;
//		for (CasoTeste casoTeste : suite.getCasosTeste()) {
//			List<AbstractContext> list = new ArrayList<AbstractContext>();
//			AbstractContext logicalContext = new LogicalContext("Luz: "+ ++i );
//			for (ValorElementoContextual valorEC : casoTeste.getValores()) {
//				if (valorEC.getTipoEC().equals(TipoElementoContextual.LIGHT_SENSOR)){
//					LightSensor luz = new LightSensor(valorEC.getValor());
//					list.add(luz);
//				}
//			}
//			logicalContext.setContextList(list);
//			lstLogicalContext.add(logicalContext);
//		}
		
//		AbstractContext logicalContext = new LogicalContext("Luz Alta - Logico");
//		LightSensor luz = new LightSensor();
//		luz.setValue1(99);
//		List<AbstractContext> list = new ArrayList<AbstractContext>();
//		list.add(luz);
//		logicalContext.setContextList(list);
//		lstLogicalContext.add(logicalContext);
		
		
	}
}
