package com.ecosystem.service;

import java.util.Map;
import org.springframework.mail.SimpleMailMessage;

public interface MailService {
	public int send(SimpleMailMessage email, String html);
	public int send(SimpleMailMessage message, String view, Map<String, Object> paramMap);
}
