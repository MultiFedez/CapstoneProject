package com.epicode.InfoSalute.security.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.InfoSalute.security.entity.Ospedale;
import com.epicode.InfoSalute.security.entity.Reparto;
import com.epicode.InfoSalute.security.payload.RepartoTO;
import com.epicode.InfoSalute.security.repository.RepartoRepository;

@Service
public class RepartoServiceImpl implements RepartoService{

@Autowired RepartoRepository repartoRepository;
	
	@Autowired @Qualifier("reparto") private ObjectProvider<Reparto> provider;
	@Override
	public Reparto createReparto(RepartoTO r) {
		Reparto r1 = provider.getObject().builder()
				.nome(r.getNome())
				.piano(r.getPiano())
				.descrizione(r.getDescrizione())
				.ospedaleid(r.getOspedaleid())
				.build();
				return repartoRepository.save(r1);
			}
	
	@Override
	public Reparto getRepartoById(Long id) {
		return repartoRepository.findById(id).get();
	}
	
	@Override
	public List<Reparto> getAllReparti() {
		return repartoRepository.findAll();
	}

	@Override
	public Long deleteReparto(Long id) {
		Reparto r = repartoRepository.findById(id).get();
		repartoRepository.delete(r);
		return id;
	}
	
	@Override
	public List<Reparto> findRepartoByOspedaleid(Long ospedaleid){
		List<Reparto> r = repartoRepository.findByOspedaleid(ospedaleid);
		return r;
	}
}
