package com.epicode.InfoSalute.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.InfoSalute.security.entity.Comune;
import com.epicode.InfoSalute.security.entity.Medico;
import com.epicode.InfoSalute.security.entity.Ospedale;
import com.epicode.InfoSalute.security.entity.Reparto;

@Configuration
public class InfoBean {

	@Bean("comune")
    @Scope("prototype")
    public Comune comune() {
        return new Comune();
	}
	
	@Bean("medico")
    @Scope("prototype")
    public Medico medico() {
        return new Medico();
	}
	
	@Bean("ospedale")
    @Scope("prototype")
    public Ospedale ospedale() {
        return new Ospedale();
	}
	
	@Bean("reparto")
    @Scope("prototype")
    public Reparto reparto() {
        return new Reparto();
	}
}
