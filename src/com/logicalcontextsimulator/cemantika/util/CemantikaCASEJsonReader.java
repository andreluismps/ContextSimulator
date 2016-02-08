/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.cemantika.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.logicalcontextsimulator.model.context.AbstractContext;
import com.logicalcontextsimulator.model.context.Scenario;
import com.logicalcontextsimulator.model.context.TestSuite;
import com.logicalcontextsimulator.util.GsonUtils;

/**
 *
 * @author andreluismps
 */
public class CemantikaCASEJsonReader {
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
		
		Type type = new TypeToken<TestSuite>() {}.getType();
		Gson gson = GsonUtils.getGson();
		
		TestSuite testSuite = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(absolutePath));

			testSuite = gson.fromJson(br, type);
			
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lstScenario = testSuite.getTestCases();
		
		//TODO fill these lists
		lstSituation = new ArrayList<AbstractContext>();
        lstLogicalContext = new ArrayList<AbstractContext>();		
		
	}
}
