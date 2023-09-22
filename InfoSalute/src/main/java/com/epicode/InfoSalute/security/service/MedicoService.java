package com.epicode.InfoSalute.security.service;

import java.util.List;

import com.epicode.InfoSalute.security.entity.Medico;
import com.epicode.InfoSalute.security.payload.MedicoDTO;
import com.epicode.InfoSalute.security.payload.MedicoTO;

public interface MedicoService {

	Medico createMedico(MedicoTO medicoTO);

	List<Medico> getAllMedici();

	Object deleteMedico(Long id);

	Medico getMedicoById(Long id);

}
