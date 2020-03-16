package com.nt.utility;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender javaMailSender;

	public boolean send(String to, String subject, String text, MultipartFile file) {
		boolean flag=false;
		try {
			
       //create MimeMessage Object
			MimeMessage mimeMsg = javaMailSender.createMimeMessage();
	   //helper class
			MimeMessageHelper helper=new MimeMessageHelper(mimeMsg, file!=null?true:false);
			helper.setTo(to);
			helper.setFrom("rr5817599@gmail.com");
			helper.setText(text);
			if(file!=null)
			helper.addAttachment(file.getOriginalFilename(), file);
			//send
			javaMailSender.send(mimeMsg);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
