package com.klef.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
public class EmailService {
	@Autowired
	private JavaMailSender emailSender;
	public void sendMessage(String to, String text)
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("weathermanservices@gmail.com");
		message.setTo(to);
		message.setSubject("Hello from mohan");
		message.setText(text);
		emailSender.send(message);
	}

}
