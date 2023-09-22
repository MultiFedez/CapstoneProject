package com.epicode.InfoSalute.security.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.InfoSalute.security.entity.Comune;
import com.epicode.InfoSalute.security.payload.ComuneTO;
import com.epicode.InfoSalute.security.repository.ComuneRepository;

@Service
public class ComuneServiceImpl implements ComuneService {

@Autowired ComuneRepository comuneRepository;
	
	@Autowired @Qualifier("comune") private ObjectProvider<Comune> provider;
	@Override
	public Comune createComune(ComuneTO c) {
		Comune c1 = provider.getObject().builder()
				.nome(c.getNome())
				.build();
				return comuneRepository.save(c1);
			}
	
	@Override
	public Comune getComuneById(Long id) {
		return comuneRepository.findById(id).get();
	}
	
	@Override
	public List<Comune> getAllComuni() {
		return comuneRepository.findAll();
	}

	@Override
	public Long deleteComune(Long id) {
		Comune c = comuneRepository.findById(id).get();
		comuneRepository.delete(c);
		return id;
	}
}
