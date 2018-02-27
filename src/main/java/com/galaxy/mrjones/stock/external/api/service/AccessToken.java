package com.galaxy.mrjones.stock.external.api.service;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.etrade.etws.sdk.common.ETWSException;
import com.galaxy.mrjones.stock.base.AbstractBase;

@Component
public class AccessToken extends AbstractBase {

	public void getAccessToken() {
		AbstractBase base = AbstractBase.getrequest();
		try {
				base.token = base.client.getAccessToken(base.request);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 catch (ETWSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Get access-token object
		base.oauth_access_token = base.token.getToken(); // Access token string
		base.oauth_access_token_secret = base.token.getSecret(); // Access token
		// secret
		System.out.println("oauth_access_token :" + base.oauth_access_token);
		System.out.println("oauth_access_token_secret :" + base.oauth_access_token_secret);

		base.request.setToken(base.oauth_access_token);
		base.request.setTokenSecret(base.oauth_access_token_secret);

	}

}
