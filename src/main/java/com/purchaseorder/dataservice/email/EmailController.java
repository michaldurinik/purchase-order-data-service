package com.purchaseorder.dataservice.email;

import javax.mail.internet.MimeMessage;

import com.purchaseorder.dataservice.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {

    @Autowired
    private JavaMailSender sender;

    @RequestMapping("/testemail")
    @ResponseBody
    String testEmail() {
        try {
            sendEmail("misko.durinik@gmail.com", "Testing Mail /testmail", "ola! it works!");
            return "Email Sent!";
        }catch(Exception ex) {
            return "Error in sending mail: "+ex;
        }
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/sendemail"
    )
    public ResponseEntity<String> byName(@RequestBody Email emailData) {

        sendEmail(emailData.getRecipient(), emailData.getSubject(), emailData.getText());
        return ResponseEntity.ok("Email sent successfully");
        }

    public void sendEmail(String recipient, String subject, String text) {
        try {
            sendEmailImpl(recipient, subject, text);
        }catch(Exception ex) {
            System.out.println("Failed to send an email");
        }
    }

    private void sendEmailImpl(String recipient, String subject, String text) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(recipient);
        helper.setSubject(subject);
        helper.setText(text);

        sender.send(message);
    }
}