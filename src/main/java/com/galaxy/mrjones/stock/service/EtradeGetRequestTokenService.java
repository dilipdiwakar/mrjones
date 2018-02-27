package com.galaxy.mrjones.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galaxy.mrjones.stock.external.api.service.RequestToken;

@Component
public class EtradeGetRequestTokenService {

	@Autowired
	RequestToken reqToken;

	public void getRequestToken() {
		reqToken.getRequestToken();
		
	}
}
