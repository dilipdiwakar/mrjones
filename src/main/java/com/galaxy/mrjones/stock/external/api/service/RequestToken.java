package com.galaxy.mrjones.stock.external.api.service;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.etrade.etws.oauth.sdk.client.OAuthClientImpl;
import com.etrade.etws.sdk.client.ClientRequest;
import com.etrade.etws.sdk.client.Environment;
import com.etrade.etws.sdk.common.ETWSException;
import com.galaxy.mrjones.stock.base.AbstractBase;

@Component
public class RequestToken extends AbstractBase{


	public void getRequestToken(){
		AbstractBase base = AbstractBase.getrequest();
		base.client	 = OAuthClientImpl.getInstance();
		base.request = new ClientRequest(); // Instantiate ClientRequest
		base.request.setEnv(Environment.SANDBOX); // Use sandbox environment

		base.request.setConsumerKey(base.oauth_consumer_key); //Set consumer key
		base.request.setConsumerSecret(base.oauth_consumer_secret); // Set consumer secret
		try {
			base.token= base.client.getRequestToken(base.request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ETWSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Get request-token object
		base.oauth_request_token  = base.token.getToken(); // Get token string
		base.oauth_request_token_secret = base.token.getSecret(); // Get token secret
		base.request.setToken(base.oauth_request_token);
		base.request.setTokenSecret(base.oauth_request_token_secret);
		System.out.println("oauth_request_token :" +base.oauth_request_token);
		System.out.println("oauth_request_token_secret :" +base.oauth_request_token_secret);

	}	


}





