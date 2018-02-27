package com.galaxy.mrjones.stock.external.api.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.etrade.etws.market.DetailFlag;
import com.etrade.etws.market.QuoteResponse;
import com.etrade.etws.oauth.sdk.client.IOAuthClient;
import com.etrade.etws.oauth.sdk.client.OAuthClientImpl;
import com.etrade.etws.oauth.sdk.common.Token;
import com.etrade.etws.sdk.client.ClientRequest;
import com.etrade.etws.sdk.client.Environment;
import com.etrade.etws.sdk.client.MarketClient;
import com.etrade.etws.sdk.common.ETWSException;
import com.galaxy.mrjones.stock.base.AbstractBase;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class AllRequestsBackUp extends AbstractBase{


	public static void main(String args[]){
	// Variables
	 IOAuthClient client = null;
	 ClientRequest request = null;
	Token token = null;
	String oauth_consumer_key = "95f6931cc85c461205cae7439dd14095"; // Your consumer key
	String oauth_consumer_secret = "02da03e8f706ad76cab1e0ff21265a10"; // Your consumer secret
	String oauth_request_token = null; // Request token 
	
	String oauth_request_token_secret = null ; // Request token secret
	 String oauth_access_token = null; // Variable to store access token 
	 String oauth_access_token_secret = null; 
	
	client	 = OAuthClientImpl.getInstance();
	request = new ClientRequest(); // Instantiate ClientRequest
	request.setEnv(Environment.SANDBOX); // Use sandbox environment

	request.setConsumerKey(oauth_consumer_key); //Set consumer key
	request.setConsumerSecret(oauth_consumer_secret); // Set consumer secret
	try {
		token= client.getRequestToken(request);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ETWSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} // Get request-token object
	oauth_request_token  = token.getToken(); // Get token string
	oauth_request_token_secret = token.getSecret(); // Get token secret
	request.setToken(oauth_request_token);
	request.setTokenSecret(oauth_request_token_secret);
	System.out.println("oauth_request_token :" +oauth_request_token);
	System.out.println("oauth_request_token_secret :" +oauth_request_token_secret);
	
	 String authorizeURL = null;
	 try {
		authorizeURL = client.getAuthorizeUrl(request);
	} catch (ETWSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} // E*TRADE authorization URL
	 URI uri=null;
	try {
		uri = new java.net.URI(authorizeURL	);
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 Desktop desktop = Desktop.getDesktop();
	 try {
		desktop.browse(uri);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		String oauth_verifier="";
		
		BufferedReader reader;
		
		reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter your oauth verifier");
		try {
			oauth_verifier=reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("Your oauth verifier is "+oauth_verifier);

		request.setVerifierCode(oauth_verifier); 
		
		 try {
			token = client.getAccessToken(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ETWSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Get access-token object
		 oauth_access_token = token.getToken(); // Access token string
		 oauth_access_token_secret = token.getSecret(); // Access token secret
			System.out.println("oauth_access_token :" +oauth_access_token);
			System.out.println("oauth_access_token_secret :" +oauth_access_token_secret);		 
		 
			
			 request.setToken(oauth_access_token);
			 request.setTokenSecret(oauth_access_token_secret);
/*
			 try
			 {
			   AccountsClient account_client = new AccountsClient(request);
			   AccountListResponse response = account_client.getAccountList();
			   List<Account> alist = response.getResponse();
			   Iterator<Account> al = alist.iterator();
			   while (al.hasNext()) {
			     Account a = al.next();
			     System.out.println("===================");
			     System.out.println("Account: " + a.getAccountId());
			     System.out.println("===================");
			   }
			 }
			 catch (Exception e)
			 {
			 }   
			 */
			 ArrayList<String> list = new ArrayList<String>();
			 MarketClient quote = new MarketClient(request);
			 list.add("CTSH");
			 list.add("MSFT");
			 list.add("GOOG");
			 QuoteResponse response=null;
			try {
				response = quote.getQuote(list, true, DetailFlag.ALL);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ETWSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					 System.out.println(response.toString());
			 
	
	}

}


	


