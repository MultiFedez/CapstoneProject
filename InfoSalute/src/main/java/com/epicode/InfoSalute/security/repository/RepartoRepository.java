package com.epicode.InfoSalute.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.InfoSalute.security.entity.Reparto;

public interface RepartoRepository extends JpaRepository<Reparto, Long> {

	List<Reparto> findByOspedaleid(Long ospedaleid);

}
