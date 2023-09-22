package com.epicode.InfoSalute.security.service;

import java.util.List;

import com.epicode.InfoSalute.security.entity.Comune;
import com.epicode.InfoSalute.security.payload.ComuneDTO;
import com.epicode.InfoSalute.security.payload.ComuneTO;

public interface ComuneService {

	Comune createComune(ComuneTO comuneTO);

	List<Comune> getAllComuni();

	Object deleteComune(Long id);

	Comune getComuneById(Long id);

	

	

	
}
