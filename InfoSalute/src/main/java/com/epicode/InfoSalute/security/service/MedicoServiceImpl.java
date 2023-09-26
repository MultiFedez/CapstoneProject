package com.epicode.InfoSalute.security.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.InfoSalute.security.entity.Medico;
import com.epicode.InfoSalute.security.entity.Reparto;
import com.epicode.InfoSalute.security.payload.MedicoTO;
import com.epicode.InfoSalute.security.repository.MedicoRepository;

@Service
public class MedicoServiceImpl implements MedicoService {
	
@Autowired MedicoRepository medicoRepository;
	
	@Autowired @Qualifier("medico") private ObjectProvider<Medico> provider;
	@Override
	public Medico createMedico(MedicoTO m) {
		Medico m1 = provider.getObject().builder()
				.nome(m.getNome())
				.specializzazione(m.getSpecializzazione())
				.repartoid(m.getRepartoid())
				.build();
				return medicoRepository.save(m1);
			}
	
	@Override
	public Medico getMedicoById(Long id) {
		return medicoRepository.findById(id).get();
	}
	
	@Override
	public List<Medico> getAllMedici() {
		return medicoRepository.findAll();
	}

	@Override
	public Long deleteMedico(Long id) {
		Medico m = medicoRepository.findById(id).get();
		medicoRepository.delete(m);
		return id;
	}

	@Override
	public List<Medico> findMedicoByRepartoid(Long repartoid){
		List<Medico> m = medicoRepository.findByRepartoid(repartoid);
		return m;
	}
}
