/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.util;

import cemantika.testing.model.CasoTeste;
import cemantika.testing.model.SuiteTeste;
import cemantika.testing.model.TipoElementoContextual;
import cemantika.testing.model.ValorElementoContextual;

import com.logicalcontextsimulator.model.context.AbstractContext;
import com.logicalcontextsimulator.model.context.LogicalContext;
import com.logicalcontextsimulator.model.context.PhysicalContext;
import com.logicalcontextsimulator.model.context.contextSource.GPS;
import com.logicalcontextsimulator.model.context.contextSource.LightSensor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author andreluismps
 */
public class CemantikaCASEXMLReader {
    private List<AbstractContext> lstLogicalContext;

	public List<AbstractContext> getLstLogicalContext() {
		return lstLogicalContext;
	}

	public void setLstLogicalContext(List<AbstractContext> lstLogicalContext) {
		this.lstLogicalContext = lstLogicalContext;
	}

	public void loadDataFromDisk(String absolutePath) {
		SuiteTeste suite = new SuiteTeste();
		
		File xmlSimulador = new File(absolutePath);
		
		XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource(xmlSimulador);
        try{
        	XMLStreamReader xsr = xif.createXMLStreamReader(xml);
            xsr.nextTag();
            while(!xsr.getLocalName().equals("suite")) {
                xsr.nextTag();
            }
     
            JAXBContext jc = JAXBContext.newInstance(cemantika.testing.model.SuiteTeste.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<SuiteTeste> jb = unmarshaller.unmarshal(xsr, SuiteTeste.class);
            suite = jb.getValue();
        }catch (Exception e) {
			
		}
        
        lstLogicalContext = new ArrayList<AbstractContext>();
        int i = 0;
		for (CasoTeste casoTeste : suite.getCasosTeste()) {
			List<AbstractContext> list = new ArrayList<AbstractContext>();
			AbstractContext logicalContext = new LogicalContext("Luz: "+ ++i );
			for (ValorElementoContextual valorEC : casoTeste.getValores()) {
				if (valorEC.getTipoEC().equals(TipoElementoContextual.LUMINOSIDADE)){
					LightSensor luz = new LightSensor(valorEC.getValor());
					list.add(luz);
				}
			}
			logicalContext.setContextList(list);
			lstLogicalContext.add(logicalContext);
		}
		
		AbstractContext logicalContext = new LogicalContext("Luz Alta - Logico");
		LightSensor luz = new LightSensor();
		luz.setValue1(99);
		List<AbstractContext> list = new ArrayList<AbstractContext>();
		list.add(luz);
		logicalContext.setContextList(list);
		lstLogicalContext.add(logicalContext);
		
		
	}
}
