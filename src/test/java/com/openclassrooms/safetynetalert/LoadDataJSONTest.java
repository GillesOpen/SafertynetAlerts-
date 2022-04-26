package com.openclassrooms.safetynetalert;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import com.openclassrooms.SafetynetAlert.LoadDataJSON;
import com.openclassrooms.SafetynetAlert.config.UrlFileReader;

@SpringBootTest
@Component
class LoadDataJSONTest {

	@Autowired
	private LoadDataJSON loadDataJSON;
	@Autowired
	private UrlFileReader urlFileReader;

	@Test
	public void loadPersonsTest() {

		assertTrue(loadDataJSON.loadPersons(urlFileReader.urlDataJSONTest()));
	}

	@Test
	public void loadFireStationTest() {
		assertTrue(loadDataJSON.loadFireStations(urlFileReader.urlDataJSONTest()));
	}

	@Test
	public void loadMedicalRecordTest() {
		assertTrue(loadDataJSON.loadMedicalRecords(urlFileReader.urlDataJSONTest()));
	}

}
