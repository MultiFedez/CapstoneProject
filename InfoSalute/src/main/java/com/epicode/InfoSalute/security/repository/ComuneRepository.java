package com.epicode.InfoSalute.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.epicode.InfoSalute.security.entity.Comune;


public interface ComuneRepository extends JpaRepository<Comune, Long> {

}
