package com.epicode.InfoSalute.security.payload;

import com.epicode.InfoSalute.security.entity.Specializzazione;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoTO {

	private String nome;
	private Specializzazione specializzazione;
	private String valutazione;
	private Long repartoid;
}
