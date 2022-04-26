package com.openclassrooms.SafetynetAlert.controller;

import org.pmw.tinylog.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.SafetynetAlert.service.RequestService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class RequestController {

	@Autowired
	private RequestService requestService;

	/**
	 * End point de /person Create = @PostMapping("/person") Update
	 * = @PutMapping("/person") Delete = @DeleteMapping("/person")
	 *
	 * Etant donné que nous travaillons sur un fichier JSON, les parametres
	 * d'entrées seront au format JSON
	 **/

	// Endpoints Nous aurons besoin des endpoints suivants :

	// http://localhost:9000/person
	//
	// Cet endpoint permettra d’effectuer les actions suivantes via Post/Put/Delete
	// avec HTTP :
	// ● ajouter une nouvelle personne ;
	// ● mettre à jour une personne existante (pour le moment, supposons que le
	// prénom et le nom de famille ne changent pas, mais que les autres champs
	// peuvent être modifiés) ;
	// ● supprimer une personne (utilisez une combinaison de prénom et de nom comme
	// identificateur unique).
	//
	// http://localhost:9000/firestation
	//
	// Cet endpoint permettra d’effectuer les actions suivantes via Post/Put/Delete
	// avec HTTP :
	// ● ajout d'un mapping caserne/adresse ;
	// ● mettre à jour le numéro de la caserne de pompiers d'une adresse ;
	// ● supprimer le mapping d'une caserne ou d'une adresse.
	//
	// http://localhost:9000/medicalRecord

	// Cet endpoint permettra d’effectuer les actions suivantes via Post/Put/Delete
	// HTTP :
	// ● ajouter un dossier médical ;
	// ● mettre à jour un dossier médical existant (comme évoqué précédemment,
	// supposer que le prénom et le nom de famille ne changent pas) ;
	// ● supprimer un dossier médical (utilisez une combinaison de prénom et de nom
	// comme identificateur unique).

	@ApiOperation(value = "Ajouter une nouvelle personne dans la <table> personne")
	@PostMapping("/person")
	public String createPerson(
			@ApiParam(value = "${RequestController.paramPersonCreate.value}", required = true) @RequestBody String person) {
		Logger.info("createPerson: exemple" + person);
		return requestService.createPerson(person);
	}

	@ApiOperation(value = "Modifier les informations d'une personne dans la <table> personne")
	@PutMapping("/person")
	public String updatePerson(
			@ApiParam(value = "${RequestController.paramPersonUpdate.value}", required = true) @RequestBody String person) {
		Logger.info("updatePerson: " + person);
		return requestService.updatePerson(person);
	}

	@ApiOperation(value = "Supprimer une personne de la <table> personne")
	@DeleteMapping("/person")
	public String deletePerson(
			@ApiParam(value = "${RequestController.paramPersonDelete.value}", required = true) @RequestBody String person) {
		Logger.info("deletePerson: " + person);
		return requestService.deletePerson(person);
	}

	/**
	 * End point de /firestation Create = @PostMapping("/firestation") Update
	 * = @PutMapping("/firestation") Delete = @DeleteMapping("/firestation")
	 *
	 * Etant donné que nous travaillons sur un fichier JSON, les parametres
	 * d'entrées seront au format JSON
	 **/

	@ApiOperation(value = "Ajouter une caserne à la <table> firestation")
	@PostMapping("/firestation")
	public String createFireStation(
			@ApiParam(value = "${RequestController.paramFireStationCreate.value}") @RequestBody String fireStation) {
		Logger.info("createFireStation: " + fireStation);
		return requestService.createFireStation(fireStation);
	}

	@ApiOperation(value = "Modifier les informations d'une caserne à la <table> firestation")
	@PutMapping("/firestation")
	public String updateFireStation(
			@ApiParam(value = "${RequestController.paramFireStationUpdate.value}") @RequestBody String fireStation) {
		Logger.info("updateFireStation: " + fireStation);
		return requestService.updateFireStation(fireStation);
	}

	@ApiOperation(value = "Supprimer une caserne à la <table> firestation")
	@DeleteMapping("/firestation")
	public String deleteFireStation(
			@ApiParam(value = "${RequestController.paramFireStationDelete.value}") @RequestBody String fireStation) {
		Logger.info("deleteFireStation: " + fireStation);
		return requestService.deleteFireStation(fireStation);
	}

	/**
	 * End point de /medicalRecord Create = @PostMapping("/medicalRecord") Update
	 * = @PutMapping("/medicalRecord") Delete = @DeleteMapping("/medicalRecord")
	 *
	 * Etant donné que nous travaillons sur un fichier JSON, les parametres
	 * d'entrées seront au format JSON
	 **/

	@ApiOperation(value = "Ajouter un dossier médical dans la <table> medicalrecords")
	@PostMapping("/medicalRecord")
	public String createMedicalRecord(
			@ApiParam(value = "${RequestController.paramMedicalRecordCreate.value}") @RequestBody String medicalRecord) {
		Logger.info("createMedicalRecord: " + medicalRecord);
		return requestService.cretaMedicalRecords(medicalRecord);
	}

	@ApiOperation(value = "Modifier les informations d'un dossier médical dans la <table> medicalrecords")
	@PutMapping("/medicalRecord")
	public String updateMedicalRecords(
			@ApiParam(value = "${RequestController.paramMedicalRecordUpdate.value}") @RequestBody String medicalRecord) {
		Logger.info("updateMedicalRecords: " + medicalRecord);
		return requestService.updateMedicalRecords(medicalRecord);
	}

	@DeleteMapping("/medicalRecord")
	@ApiOperation(value = "Supprimer un dossier médical dans la <table> medicalrecords")
	public String deleteMedicalRecords(
			@ApiParam(value = "${RequestController.paramMedicalRecordDelete.value}") @RequestBody String medicalRecord) {
		Logger.info("deleteMedicalRecords: " + medicalRecord);
		return requestService.deleteMedicalRecords(medicalRecord);
	}

}
