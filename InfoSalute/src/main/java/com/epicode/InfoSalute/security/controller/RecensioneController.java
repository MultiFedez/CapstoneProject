package com.epicode.InfoSalute.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.InfoSalute.security.entity.Ospedale;
import com.epicode.InfoSalute.security.entity.Recensione;
import com.epicode.InfoSalute.security.payload.OspedaleTO;
import com.epicode.InfoSalute.security.payload.RecensioneTO;
import com.epicode.InfoSalute.security.service.MedicoService;
import com.epicode.InfoSalute.security.service.RecensioneService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/recensione")
public class RecensioneController {

	@Autowired private RecensioneService recensioneService;
	@Autowired private MedicoService medicoService;
	
	@PostMapping("/create/{medicoid}")
	//@PreAuthorize("isAuthenticated()")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> creaRecensione(@RequestBody RecensioneTO recensioneTO){
		return new ResponseEntity<Recensione>(recensioneService.creaRecensione(recensioneTO),HttpStatus.OK);
	}
}
