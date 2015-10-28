package com.ecosystem.service.impl;

import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.ecosystem.service.MailService;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

@Service
public class SendGridEmailServiceImpl implements MailService {

	@Autowired
	private SendGrid sendGrid;
	
	@Autowired
    private VelocityEngine velocityEngine;
	
	public int send(SimpleMailMessage message, String html) {
		//Send confirmation email 
	    SendGrid.Email email = new SendGrid.Email();
	    email.setTo(message.getTo());
	    email.setFrom(message.getFrom());
	    email.setSubject(message.getSubject());	    
	    email.setHtml(html);
	    
	    try {
			SendGrid.Response response = sendGrid.send(email);
		} catch (SendGridException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return 0;
	}
	
	public int send(SimpleMailMessage message, String view, Map<String, Object> paramMap) {
		String text = VelocityEngineUtils.mergeTemplateIntoString(this.velocityEngine, view, "UTF-8", paramMap);
		return send(message, text);
	}
}
