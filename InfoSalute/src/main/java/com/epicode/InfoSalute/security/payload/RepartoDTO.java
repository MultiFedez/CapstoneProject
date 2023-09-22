package com.epicode.InfoSalute.security.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepartoDTO {

	private Long id;
	private String nome;
	private String piano;
	private Long ospedaleid;
}
