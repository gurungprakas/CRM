/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prakas.crm.system;

import com.prakas.crm.constant.SystemConstant;
import static java.util.Date.from;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Prakas
 */
public class Mailer {
    private String to,from,subject,body;

    public Mailer() {
    }

    public Mailer(String to, String from, String subject, String body) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public void send() throws Exception {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", SystemConstant.MAIL_HOST);
        Session session = Session.getDefaultInstance(properties);
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

         // Set Subject: header field
         message.setSubject(subject);

         
         // Fill the message
         message.setText(body);
         
         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
        
    }
}
