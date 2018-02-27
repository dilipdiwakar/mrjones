package com.galaxy.mrjones.stock.base;
import com.etrade.etws.market.QuoteResponse;
import com.etrade.etws.oauth.sdk.client.IOAuthClient;
import com.etrade.etws.oauth.sdk.common.Token;
import com.etrade.etws.sdk.client.ClientRequest;


public class AbstractBase {

	public static AbstractBase base = null;
	public IOAuthClient client = null;
	public ClientRequest request = null;
	public Token token = null;
	public String oauth_consumer_key = "95f6931cc85c461205cae7439dd14095"; // Your consumer key
	public String oauth_consumer_secret = "02da03e8f706ad76cab1e0ff21265a10"; // Your consumer secret
	public String oauth_request_token = null; // Request token 
	
	public String oauth_request_token_secret = null ; // Request token secret
	 // Request token secret
	 public String oauth_access_token = null; // Variable to store access token 
	 public String oauth_access_token_secret = null; 
	 public QuoteResponse response=null;
	 
	 public static AbstractBase getrequest() {
		 if (base != null)
			 return base;
		 else 
			 base = new AbstractBase();
		 	return base;
		 
	 }
}
