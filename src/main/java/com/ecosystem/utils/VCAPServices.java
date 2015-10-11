package com.ecosystem.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class VCAPServices {
	/*
	 * 	Sample Environment variable
		{ "user-provided": [ { "name": "PostgreSQL by Compose-v5", "label": "user-provided", "credentials": { "username": "admin", "password": "password", "public_hostname": "jdbc:postgresql://host:port/database"} } ], "sendgrid": [ { "name": "SendGrid", "label": "sendgrid", "plan": "free", "credentials": { "password": "password", "hostname": "host", "username": "username" } }]}
	*/
	
	private String username;
	private String password;
	private String host;
	private String sendgridUsername;
	private String sendgridPassword;
	private String sendgridHost;
	
	
	//TODO: Clean this mess!!!
	public VCAPServices() {
		
	}
	
	public VCAPServices(String jsonString) {
		
		final JSONObject obj = new JSONObject(jsonString);
	    final JSONArray userProvided = obj.getJSONArray("user-provided");
	    
	    int length = userProvided.length();
	    for(int i = 0; i < length; i++) {
	    	JSONObject element = userProvided.getJSONObject(i);
	    	if(element.getString("name").equalsIgnoreCase("PostgreSQL by Compose-v5")) {
	    		final JSONObject credentials = element.getJSONObject("credentials"); 
	    	    username = credentials.getString("username");
	    	    password = credentials.getString("password");
	    	    host = credentials.getString("public_hostname");
	    	}
	    }    
	    
	    final JSONArray sendGrid = obj.getJSONArray("sendgrid");
	    
	    length = userProvided.length();
	    for(int i = 0; i < length; i++) {
	    	JSONObject element = sendGrid.getJSONObject(i);
	    	if(element.getString("name").equalsIgnoreCase("SendGrid")) {
	    		final JSONObject credentials = element.getJSONObject("credentials"); 
	    		sendgridUsername = credentials.getString("username");
	    		sendgridPassword = credentials.getString("password");
	    		sendgridHost = credentials.getString("hostname");
	    	}
	    }
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getSendgridUsername() {
		return sendgridUsername;
	}

	public void setSendgridUsername(String sendgridUsername) {
		this.sendgridUsername = sendgridUsername;
	}

	public String getSendgridPassword() {
		return sendgridPassword;
	}

	public void setSendgridPassword(String sendgridPassword) {
		this.sendgridPassword = sendgridPassword;
	}

	public String getSendgridHost() {
		return sendgridHost;
	}

	public void setSendgridHost(String sendgridHost) {
		this.sendgridHost = sendgridHost;
	}
}
