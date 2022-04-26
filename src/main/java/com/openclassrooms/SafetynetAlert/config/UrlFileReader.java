package com.openclassrooms.SafetynetAlert.config;

import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Component;

@Component
public class UrlFileReader {

	public String urlDataJSON() {
		Logger.debug("getUrlDataJSON");

		// d'application java/Projet 5/SafetynetAlert/src/main/resources/data.json" ;
		String url = "C:/Users/ggoff/eclipse-workspace/SafetynetAlerts/SafetynetAlerts/src/main/resources/Data1.json";
		return url;
	}

	// C:\Users\ggoff\eclipse-workspace\SafetynetAlert\src\main\resources
	public String urlDataJSONTest() {
		Logger.debug("getUrlDataJSONTest");
		String url = "C:/Users/ggoff/eclipse-workspace/SafetynetAlerts/SafetynetAlerts/src/main/resources/DataTest2.json";

		return url;
	}

}
//C:\Users\ggoff\eclipse-workspace\SafetynetAlerts\SafetynetAlerts