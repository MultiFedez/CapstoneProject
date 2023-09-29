package com.epicode.InfoSalute.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.InfoSalute.security.entity.Medico;
import com.epicode.InfoSalute.security.entity.Recensione;

public interface RecensioneRepository extends JpaRepository<Recensione, Long> {

	List<Recensione> findByMedico(Medico medico);
}
