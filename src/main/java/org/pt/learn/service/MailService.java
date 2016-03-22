package org.pt.learn.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	/*@Autowired
	private JavaMailSenderImpl mailSender;*/
	
	@Autowired
	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	
	public void sendMail(String from, String to, String subject, String message){
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		System.out.println(mailSender.toString());
		mailMessage.setTo(to);
		mailMessage.setFrom(from);
		mailMessage.setSentDate(new Date());
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		mailSender.send(mailMessage);
	}

}
