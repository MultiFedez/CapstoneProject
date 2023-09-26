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

import com.epicode.InfoSalute.security.entity.Medico;
import com.epicode.InfoSalute.security.entity.Reparto;
import com.epicode.InfoSalute.security.payload.MedicoDTO;
import com.epicode.InfoSalute.security.payload.MedicoTO;
import com.epicode.InfoSalute.security.service.MedicoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/medico")
public class MedicoController {
	
@Autowired private MedicoService medicoService;
	
	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createMedico(@RequestBody MedicoTO medicoTO){
		return new ResponseEntity<Medico>(medicoService.createMedico(medicoTO),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getAllMedici(){
		return new ResponseEntity<List<Medico>>(medicoService.getAllMedici(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteMedico(@PathVariable Long id){
		return new ResponseEntity<>(medicoService.deleteMedico(id),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Object> getMedicoById(@PathVariable Long id){
		return new ResponseEntity<>(medicoService.getMedicoById(id),HttpStatus.OK);
	}
	
	@GetMapping("/byReparto/{repartoid}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Medico>> findMedicoByRepartoid(@PathVariable Long repartoid) {
	    List<Medico> medici = medicoService.findMedicoByRepartoid(repartoid);
	    return new ResponseEntity<List<Medico>>(medici, HttpStatus.OK);
    }


}
