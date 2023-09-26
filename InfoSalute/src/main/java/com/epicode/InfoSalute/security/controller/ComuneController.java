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

import com.epicode.InfoSalute.security.entity.Comune;
import com.epicode.InfoSalute.security.entity.Ospedale;
import com.epicode.InfoSalute.security.payload.ComuneDTO;
import com.epicode.InfoSalute.security.payload.ComuneTO;
import com.epicode.InfoSalute.security.service.ComuneService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/comune")
public class ComuneController {

@Autowired private ComuneService comuneService;
	
	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createComune(@RequestBody ComuneTO comuneTO){
		return new ResponseEntity<Comune>(comuneService.createComune(comuneTO),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getAllComuni(){
		return new ResponseEntity<List<Comune>>(comuneService.getAllComuni(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteComune(@PathVariable Long id){
		return new ResponseEntity<>(comuneService.deleteComune(id),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Object> getComuneById(@PathVariable Long id){
		return new ResponseEntity<>(comuneService.getComuneById(id),HttpStatus.OK);
	}
	
	@GetMapping("/nome/{nome}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByNome(@PathVariable String nome){
		Comune c = comuneService.findByNome(nome);
		return new ResponseEntity <Comune>(c,HttpStatus.OK);
	}

}
