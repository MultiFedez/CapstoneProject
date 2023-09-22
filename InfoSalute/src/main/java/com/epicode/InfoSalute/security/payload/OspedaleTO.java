package com.epicode.InfoSalute.security.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OspedaleTO {

	private String nome;
	private String indirizzo;
	private String descrizione;
	private ComuneIdDTO comune;
}
