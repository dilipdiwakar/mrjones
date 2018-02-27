package com.galaxy.mrjones.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galaxy.mrjones.stock.external.api.service.AccessToken;

@Component
public class EtradeGetAccessTokenService {
	
	@Autowired
	AccessToken accessToken;

	public void getAccessToken() {		
		accessToken.getAccessToken();
	}
}
