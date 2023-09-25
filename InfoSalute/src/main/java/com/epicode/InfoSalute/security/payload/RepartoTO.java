package com.epicode.InfoSalute.security.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepartoTO {

	private String nome;
	private String piano;
	private String descrizione;
	private Long ospedaleid;
	
}
