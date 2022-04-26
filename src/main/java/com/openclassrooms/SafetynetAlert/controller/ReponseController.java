package com.openclassrooms.SafetynetAlert.controller;

import org.json.simple.JSONArray;
import org.pmw.tinylog.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.SafetynetAlert.service.ReponseService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

//              URLS : 

//              http://localhost:9000/firestation?stationNumber=<station_number>

// Cette url doit retourner une liste des personnes couvertes par la caserne de
// pompiers correspondante.Donc, si le numéro de station = 1, elle doit renvoyer
// les habitants couverts par la station numéro 1. La liste
// doit inclure les informations spécifiques suivantes : prénom, nom, adresse,
// numéro de téléphone. De plus, elle doit fournir un décompte du nombre
// d'adultes et du nombre d'enfants (tout individu âgé de 18 ans ou
// moins) dans la zone desservie.

//               http://localhost:9000/childAlert?address=<address>

// Cette url doit retourner une liste d'enfants (tout individu âgé de 18 ans ou
// moins) habitant à cette adresse. La liste doit comprendre le prénom et le nom
// de famille de chaque enfant, son âge et une liste des autres
// membres du foyer. S'il n'y a pas d'enfant, cette url peut renvoyer une chaîne
// vide.

//	             http://localhost:9000/phoneAlert?firestation=<firestation_number>

// Cette url doit retourner une liste des numéros de téléphone des résidents
// desservis par la caserne de pompiers. Nous l'utiliserons pour envoyer des
// messages texte d'urgence à des foyers spécifiques.

//	              http://localhost:9000/fire?address=<address>

// Cette url doit retourner la liste des habitants vivant à l’adresse donnée
// ainsi que le numéro de la caserne de pompiers la desservant. La liste doit
// inclure le nom, le numéro de téléphone, l'âge et les antécédents
// médicaux (médicaments, posologie et allergies) de chaque personne.

//	              http://localhost:9000/flood/stations?stations=<a list of station_numbers>

// Cette url doit retourner une liste de tous les foyers desservis par la
// caserne. Cette liste doit regrouper les personnes par adresse. Elle doit
// aussi inclure le nom, le numéro de téléphone et l'âge des habitants, et
// faire figurer leurs antécédents médicaux (médicaments, posologie et
// allergies) à côté de chaque nom.

//	             http://localhost:9000/personInfo?firstName=<firstName>&lastName=<lastName>

// Cette url doit retourner le nom, l'adresse, l'âge, l'adresse mail et les
// antécédents médicaux (médicaments, posologie, allergies) de chaque habitant.
// Si plusieurs personnes portent le même nom, elles doivent
// toutes apparaître.

//	              http://localhost:9000/communityEmail?city=<city>
// Cette url doit retourner les adresses mail de tous les habitants de la ville.

@RestController
public class ReponseController {
	@Autowired
	private ReponseService reponseService;

	/** Endpoint de firestation?stationNumber=<station_number **/
	@ApiOperation(value = "Récupere une liste de personnes couvertes par la caserne de pompiers correspondantes")
	@RequestMapping(value = "firestation", method = RequestMethod.GET)
	public JSONArray personsByStation(
			@ApiParam(value = "Numéro de station requis", required = true) @RequestParam("stationNumber") String station_number) {
		Logger.info("stationnumber: " + station_number);
		return reponseService.personsByStation(station_number);
	}

	/** Endpoint de childAlert?address=<address> **/
	@ApiOperation(value = "Renvoie une liste d’enfants habitant à l’adresse indiqué.")
	@RequestMapping(value = "childAlert", method = RequestMethod.GET)
	public JSONArray childrenByAddress(
			@ApiParam(value = "Une adresse est démandé", required = true) @RequestParam("address") String address) {
		Logger.info("address: " + address);
		return reponseService.childrenByAddress(address);
	}

	/** Endpoint de phoneAlert?firestation=<firestation_number> **/
	@ApiOperation(value = "Renvoie les numéros de téléphone selon un numéro de caserne")
	@RequestMapping(value = "phoneAlert", method = RequestMethod.GET)
	public JSONArray phoneByStation(
			@ApiParam(value = "Numéro de station requis", required = true) @RequestParam("firestation") String firestation_number) {
		Logger.info("firestation: " + firestation_number);
		return reponseService.phoneByStation(firestation_number);
	}

	/** Endpoint de fire?address=<address> **/
	@ApiOperation(value = "Renvoie une liste des habitants vivant à l'adresse entrée.")
	@RequestMapping(value = "fire", method = RequestMethod.GET)
	public JSONArray personsByAddress(
			@ApiParam(value = "Une adresse est requis", required = true) @RequestParam("address") String address) {
		Logger.info("address: " + address);
		return reponseService.personsByAddress(address);
	}

	/** Endpoint de flood/stations?stations=<a list of station_number> **/
	@ApiOperation(value = "Renvoie une liste de tous les foyers désservis par la caserne")
	@RequestMapping(value = "/flood/stations", method = RequestMethod.GET)
	public JSONArray famillyByAddress(
			@ApiParam(value = "Numéro de station requis", required = true) @RequestParam("stations") String stations) {
		Logger.info("stations: " + stations);
		return reponseService.famillyByAddress(stations);
	}

	/** Endpont de personInfo?firstName=<firstName>&lastName=<lastName> **/
	@ApiOperation("Renvoie une liste de personnes selon le nom et prénom")
	@RequestMapping(value = "personInfo", method = RequestMethod.GET)
	public JSONArray personsInfoByName(
			@ApiParam(value = "Un prénom requis", required = true) @RequestParam("firstName") String firstName,
			@ApiParam(value = "Un nom requis", required = true) @RequestParam("lastName") String lastName) {
		Logger.info("firstName: " + firstName + " lastName: " + lastName);

		return reponseService.personsInfoByName(firstName, lastName);
	}

	/** Endpoint de communityEmail?city=<city> **/
	@ApiOperation(value = "Renvoie une liste d'email selon la ville renseignée")
	@RequestMapping(value = "communityEmail", method = RequestMethod.GET)
	public JSONArray emailByCity(
			@ApiParam(value = "Le nom d'une ville est requis", required = true) @RequestParam("city") String city) {
		Logger.info("City: " + city);
		return reponseService.emailByCity(city);
	}
}
