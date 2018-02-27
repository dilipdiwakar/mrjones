package com.galaxy.mrjones.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galaxy.mrjones.stock.external.api.service.Authorize;

@Component
public class EtradeGetAuthService {

	@Autowired
	Authorize auth;

	public void getAuth() {
		auth.getAuthorized();
	}
}
