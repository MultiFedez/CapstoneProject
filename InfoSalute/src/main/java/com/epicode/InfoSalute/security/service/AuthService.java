package com.epicode.InfoSalute.security.service;

import com.epicode.InfoSalute.security.payload.LoginDto;
import com.epicode.InfoSalute.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
