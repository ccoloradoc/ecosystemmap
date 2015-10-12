package com.ecosystem.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class VCAPServices {
	/*
	 * 	Sample Environment variable
		{ "user-provided": [ { "name": "PostgreSQL by Compose-v5", "label": "user-provided", "credentials": { "username": "admin", "password": "password", "public_hostname": "jdbc:postgresql://host:port/database"} } ], "sendgrid": [ { "name": "SendGrid", "label": "sendgrid", "plan": "free", "credentials": { "password": "password", "hostname": "host", "username": "username" } }]}
	*/
	
	private Map<String, Service> serviceMap = new HashMap<String, Service>();
	
	public VCAPServices() {
		
	}
	
	public VCAPServices(String jsonString) {
		final JSONObject outter = new JSONObject(jsonString);		
		String[] names = JSONObject.getNames(outter);
		
		for(String name : names) {
			JSONArray inner = outter.getJSONArray(name);
			for(int i = 0; i < inner.length(); i ++) {
				Service service = parse(inner.getJSONObject(i));
				serviceMap.put(service.getName(), service);
			}
		}
	}
	
	public String get(String serviceName, String property) {
		if(serviceMap.containsKey(serviceName)) {
			Service service = serviceMap.get(serviceName);
			if(property.equalsIgnoreCase("username")) {
				return service.getCredentials().getUsername();
			}
			if(property.equalsIgnoreCase("password")) {
				return service.getCredentials().getPassword();
			}
			if(property.equalsIgnoreCase("host")) {
				return service.getCredentials().getHost();
			}
		}
		return "";
	}
	
	private Service parse(JSONObject element) {
		Service service = new Service();
		
		if(element.has("name"))
			service.setName(element.getString("name"));
		if(element.has("label"))
			service.setLabel(element.getString("label"));
		if(element.has("plan"))
			service.setPlan(element.getString("plan"));
		
		if(element.has("credentials")) {
			Credentials credentialsBean = new Credentials();
			JSONObject credentials = element.getJSONObject("credentials");
			if(credentials.has("username"))
				credentialsBean.setUsername(credentials.getString("username"));
			if(credentials.has("password"))
				credentialsBean.setPassword(credentials.getString("password"));
			if(credentials.has("host"))
				credentialsBean.setHost(credentials.getString("host"));
			if(credentials.has("public_hostname"))
				credentialsBean.setHost(credentials.getString("public_hostname"));
			service.setCredentials(credentialsBean);
		}	    
    	
	    
	    return service;
	}

	public class Service {
		private String name;
		private String label;
		private String plan;
		private Credentials credentials;


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getPlan() {
			return plan;
		}

		public void setPlan(String plan) {
			this.plan = plan;
		}

		public Credentials getCredentials() {
			return credentials;
		}

		public void setCredentials(Credentials credentials) {
			this.credentials = credentials;
		}
	}
	
	public class Credentials {
		private String username;
		private String password;
		private String host;
		
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
	}
}
