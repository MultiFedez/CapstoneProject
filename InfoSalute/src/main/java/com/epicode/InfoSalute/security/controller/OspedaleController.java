package com.epicode.InfoSalute.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.InfoSalute.security.entity.Ospedale;
import com.epicode.InfoSalute.security.payload.OspedaleDTO;
import com.epicode.InfoSalute.security.payload.OspedaleTO;
import com.epicode.InfoSalute.security.service.OspedaleService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/ospedale")
public class OspedaleController {


@Autowired private OspedaleService ospedaleService;
	
	@PostMapping("/create")
	//@PreAuthorize("isAuthenticated()")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createOspedale(@RequestBody OspedaleTO ospedaleTO){
		return new ResponseEntity<Ospedale>(ospedaleService.createOspedale(ospedaleTO),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getAllOspedali(){
		return new ResponseEntity<List<Ospedale>>(ospedaleService.getAllOspedali(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteOspedale(@PathVariable Long id){
		return new ResponseEntity<>(ospedaleService.deleteOspedale(id),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Object> getOspedaleById(@PathVariable Long id){
		return new ResponseEntity<>(ospedaleService.getOspedaleById(id),HttpStatus.OK);
	}
	
	@GetMapping("/{nome}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByNome(@PathVariable String nome){
		List<Ospedale> o = ospedaleService.findByNome(nome);
		return new ResponseEntity <List<Ospedale>>(o,HttpStatus.OK);
	}
	
}
