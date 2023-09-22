package com.epicode.InfoSalute.security.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OspedaleDTO {

	private Long id;
	private String nome;
	private String indirizzo;
	private String descrizione;
	private ComuneDTO comune;
}
