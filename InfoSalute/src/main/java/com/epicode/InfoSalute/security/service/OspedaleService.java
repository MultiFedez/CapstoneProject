package com.epicode.InfoSalute.security.service;

import java.util.List;

import com.epicode.InfoSalute.security.entity.Comune;
import com.epicode.InfoSalute.security.entity.Ospedale;
import com.epicode.InfoSalute.security.payload.OspedaleDTO;
import com.epicode.InfoSalute.security.payload.OspedaleTO;

public interface OspedaleService {

	Ospedale createOspedale(OspedaleTO ospedaleTO);

	List<Ospedale> getAllOspedali();

	Long deleteOspedale(Long id);

	Ospedale getOspedaleById(Long id);

	List<Ospedale> findByNome(String nome);

	List<Ospedale> findOspedaleByComune(String nome);

	

}
