package com.epicode.InfoSalute.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.epicode.InfoSalute.security.entity.Comune;
import com.epicode.InfoSalute.security.entity.Ospedale;

public interface OspedaleRepository extends JpaRepository<Ospedale, Long>{
	
	@Query("SELECT o FROM Ospedale o WHERE o.nome ILIKE :nome")
    public List<Ospedale> getByNome(String nome);

	Ospedale findByNome(String nome);
	
	@Query("SELECT o FROM Ospedale o WHERE o.comune.nome = :nome")
    List<Ospedale> findOspedaleByComuneNome(@Param("nome") String nome);
}
