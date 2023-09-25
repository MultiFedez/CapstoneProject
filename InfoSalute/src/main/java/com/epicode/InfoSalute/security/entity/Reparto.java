package com.epicode.InfoSalute.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="reparti")
public class Reparto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String piano;
	
	@Column(nullable = false)
	private String descrizione;
	
	@Column(nullable = false)
	private Long ospedaleid;
	
}
