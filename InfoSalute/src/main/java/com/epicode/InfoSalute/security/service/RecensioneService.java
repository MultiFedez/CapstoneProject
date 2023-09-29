package com.epicode.InfoSalute.security.service;

import java.util.List;

import com.epicode.InfoSalute.security.entity.Recensione;
import com.epicode.InfoSalute.security.payload.RecensioneTO;

public interface RecensioneService {

	Recensione creaRecensione(RecensioneTO recensioneTO);

	List<Recensione> findByMedico(Long medicoid);
}
