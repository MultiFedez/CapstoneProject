package com.epicode.InfoSalute.security.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecensioneTO {

	private String commento;
	private int voto;
	private MedicoIdDTO medico;
	

}
