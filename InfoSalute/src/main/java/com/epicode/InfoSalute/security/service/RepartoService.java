package com.epicode.InfoSalute.security.service;

import java.util.List;

import com.epicode.InfoSalute.security.entity.Reparto;
import com.epicode.InfoSalute.security.payload.RepartoTO;

public interface RepartoService {

	Reparto createReparto(RepartoTO repartoTO);

	List<Reparto> getAllReparti();

	Object deleteReparto(Long id);

	Reparto getRepartoById(Long id);

	List<Reparto> findRepartoByOspedaleid(Long ospedaleid);

}
