package com.galaxy.mrjones.stock.external.api.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.etrade.etws.sdk.common.ETWSException;
import com.galaxy.mrjones.stock.base.AbstractBase;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Component;

@Component
public class Authorize extends AbstractBase{


	public void getAuthorized(){
		AbstractBase base = AbstractBase.getrequest();
		String authorizeURL = null;

		try {
			authorizeURL = base.client.getAuthorizeUrl(base.request);
		} catch (ETWSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // E*TRADE authorization URL
		URI uri=null;
		try {
			uri = new java.net.URI(authorizeURL);
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
		System.out.print("Enter your oauth verifier : ");
		try {
			oauth_verifier=reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("Your oauth verifier is : "+oauth_verifier);

		base.request.setVerifierCode(oauth_verifier); 

		try {
			base.token = base.client.getAccessToken(base.request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ETWSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Get access-token object
		base.oauth_access_token = base.token.getToken(); // Access token string
		base.oauth_access_token_secret = base.token.getSecret(); // Access token secret
		System.out.println("oauth_access_token :" +base.oauth_access_token);
		System.out.println("oauth_access_token_secret :" +base.oauth_access_token_secret);		 


		base.request.setToken(base.oauth_access_token);
		base.request.setTokenSecret(base.oauth_access_token_secret);

	}

}





