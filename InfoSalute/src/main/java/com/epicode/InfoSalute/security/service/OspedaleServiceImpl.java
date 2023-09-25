package com.epicode.InfoSalute.security.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.InfoSalute.security.entity.Comune;
import com.epicode.InfoSalute.security.entity.Ospedale;
import com.epicode.InfoSalute.security.payload.OspedaleDTO;
import com.epicode.InfoSalute.security.payload.OspedaleTO;
import com.epicode.InfoSalute.security.repository.ComuneRepository;
import com.epicode.InfoSalute.security.repository.OspedaleRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OspedaleServiceImpl implements OspedaleService{


@Autowired 
OspedaleRepository ospedaleRepository;

@Autowired
private ComuneRepository comuneRepository;
	
	@Autowired @Qualifier("ospedale") private ObjectProvider<Ospedale> provider;
	
	@Override
	public Ospedale createOspedale(OspedaleTO ospedaleTO) {
		Ospedale ospedale = provider.getObject();
		ospedale.setNome(ospedaleTO.getNome());
		ospedale.setIndirizzo(ospedaleTO.getIndirizzo());
		ospedale.setDescrizione(ospedaleTO.getDescrizione());
				
		Comune comune = comuneRepository.findById(ospedaleTO.getComune().getId())
	            .orElseThrow(() -> new EntityNotFoundException("Comune non trovato"));
	    ospedale.setComune(comune);
				return ospedaleRepository.save(ospedale);
			
			}
	
	@Override
	public Ospedale getOspedaleById(Long id) {
		Ospedale o = ospedaleRepository.findById(id).get();
		return o;
	}
	
	@Override
	public List<Ospedale> getAllOspedali() {
		return ospedaleRepository.findAll();
	}

	@Override
	public Long deleteOspedale(Long id) {
		Ospedale o = ospedaleRepository.findById(id).get();
		ospedaleRepository.delete(o);
		return id;
	}
	
	@Override
	public List<Ospedale> findByNome(String nome) {
		List<Ospedale> o = ospedaleRepository.getByNome(nome);
		return o;
	}
	
	@Override
	public List<Ospedale> findOspedaleByComune(String nome){
		List<Ospedale> o = ospedaleRepository.findOspedaleByComuneNome(nome);
		return o;
	}
}
