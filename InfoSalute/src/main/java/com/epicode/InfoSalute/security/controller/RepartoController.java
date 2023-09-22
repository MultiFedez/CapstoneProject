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

import com.epicode.InfoSalute.security.entity.Reparto;
import com.epicode.InfoSalute.security.payload.RepartoTO;
import com.epicode.InfoSalute.security.service.RepartoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/reparto")
public class RepartoController {

@Autowired private RepartoService repartoService;
	
	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createReparto(@RequestBody RepartoTO repartoTO){
		return new ResponseEntity<Reparto>(repartoService.createReparto(repartoTO),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getAllReparti(){
		return new ResponseEntity<List<Reparto>>(repartoService.getAllReparti(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteReparto(@PathVariable Long id){
		return new ResponseEntity<>(repartoService.deleteReparto(id),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Object> getRepartoById(@PathVariable Long id){
		return new ResponseEntity<>(repartoService.getRepartoById(id),HttpStatus.OK);
	}
}
