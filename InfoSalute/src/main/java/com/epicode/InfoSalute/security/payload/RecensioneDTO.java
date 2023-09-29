package com.epicode.InfoSalute.security.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecensioneDTO {

	private Long id;
	private String commento;
	private int voto;
	private MedicoDTO medico;
}
