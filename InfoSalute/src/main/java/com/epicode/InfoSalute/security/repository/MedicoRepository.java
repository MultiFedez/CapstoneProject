package com.epicode.InfoSalute.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.epicode.InfoSalute.security.entity.Medico;


public interface MedicoRepository extends JpaRepository<Medico, Long>{

	List<Medico> findByRepartoid(Long repartoid);

}

