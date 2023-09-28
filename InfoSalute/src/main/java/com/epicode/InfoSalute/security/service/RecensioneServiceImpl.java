package com.epicode.InfoSalute.security.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.InfoSalute.security.entity.Medico;
import com.epicode.InfoSalute.security.entity.Recensione;
import com.epicode.InfoSalute.security.payload.RecensioneTO;
import com.epicode.InfoSalute.security.repository.MedicoRepository;
import com.epicode.InfoSalute.security.repository.RecensioneRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RecensioneServiceImpl implements RecensioneService{

	@Autowired 
	RecensioneRepository recensioneRepository;
	@Autowired 
	MedicoRepository medicoRepository;
	
	@Autowired @Qualifier("recensione") private ObjectProvider<Recensione> provider;
	 
	@Override
	public Recensione creaRecensione(RecensioneTO recensioneTO) {
		Recensione recensione = provider.getObject();
		recensione.setCommento(recensioneTO.getCommento());
		recensione.setVoto(recensioneTO.getVoto());
				
		Medico medico = medicoRepository.findById(recensioneTO.getMedico().getId())
	            .orElseThrow(() -> new EntityNotFoundException("Medico non trovato"));
		recensione.setMedico(medico);
				return recensioneRepository.save(recensione);
			}

	
}
