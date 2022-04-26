package com.openclassrooms.SafetynetAlert;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openclassrooms.SafetynetAlert.model.FireStations;
import com.openclassrooms.SafetynetAlert.model.MedicalRecords;
import com.openclassrooms.SafetynetAlert.model.Persons;
import com.openclassrooms.SafetynetAlert.service.CheckerService;

@Component
public class SaveDataJSON {
	@Autowired
	private Persons mPersons;
	/** Le m indique qu'on cherche la classe Persons dans le modele **/
	@Autowired
	private FireStations mFireStations;
	/** Le m indique qu'on cherche la classe FireStations dans le modele **/
	@Autowired
	private MedicalRecords mMedicalRecords;
	/** Le m indique qu'on cherche la classe MedicalRecords dans le modele **/
	@Autowired
	private CheckerService checkerService;

	public void saveDataJson(String url) {
		JSONObject obj = new JSONObject();
		JSONArray persons = new JSONArray();
		JSONArray fireStation = new JSONArray();
		JSONArray medicalRecords = new JSONArray();
		JSONObject objPerson = new JSONObject();
		JSONObject objFireStation = new JSONObject();
		JSONObject objMedicalRecords = new JSONObject();

		for (int i = 0; i < mPersons.getAddress().size(); i++) {
			System.out.println("boucle " + mPersons.getFirstName().get(i));
			objPerson = new JSONObject();
			objPerson.put("firstName", mPersons.getFirstName().get(i));
			objPerson.put("lastName", mPersons.getLastName().get(i));
			objPerson.put("address", mPersons.getAddress().get(i));
			objPerson.put("city", mPersons.getCity().get(i));
			objPerson.put("zip", mPersons.getZip().get(i));
			objPerson.put("phone", mPersons.getPhone().get(i));
			objPerson.put("email", mPersons.getEmail().get(i));
			persons.add(objPerson);
		}
		for (int i = 0; i < mFireStations.getAddress().size(); i++) {
			objFireStation = new JSONObject();
			objFireStation.put("address", mFireStations.getAddress().get(i));
			objFireStation.put("station", mFireStations.getStation().get(i));
			fireStation.add(objFireStation);
		}
		for (int i = 0; i < mMedicalRecords.getFirstName().size(); i++) {
			objMedicalRecords = new JSONObject();
			objMedicalRecords.put("firstName", mMedicalRecords.getFirstName().get(i));
			objMedicalRecords.put("lastName", mMedicalRecords.getLastName().get(i));
			objMedicalRecords.put("birthdate", mMedicalRecords.getBirthdate().get(i));
			objMedicalRecords.put("medications", mMedicalRecords.getMedications().get(i));
			objMedicalRecords.put("allergies", mMedicalRecords.getAllergies().get(i));
			medicalRecords.add(objMedicalRecords);
		}
		obj.put("persons", persons);
		obj.put("firestations", fireStation);
		obj.put("medicalrecords", medicalRecords);

		try (FileWriter file = new FileWriter(url, false)) {
			file.write(obj.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		checkerService.checkingLoadDataJSon();
	}
}
