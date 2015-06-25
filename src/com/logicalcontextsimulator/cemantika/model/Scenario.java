package com.logicalcontextsimulator.cemantika.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.logicalcontextsimulator.cemantika.model.Situation;

@XmlRootElement
public class Scenario {
	private List<Situation> situations = new ArrayList<Situation>();
	
	private String name;
	
	public Scenario(){
		
	}

	@XmlElement(name="situation")
	public List<Situation> getSituations() {
		return situations;
	}

	public void setSituations(List<Situation> situations) {
		this.situations = situations;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlAttribute
	public String getName() {
		return name;
	}
	

}
