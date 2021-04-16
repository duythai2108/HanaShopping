/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thaise.dtos;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author duythai
 */
public class SendingEmail {

    private String userEmail;

    public SendingEmail() {
    }

    public SendingEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void sendEmail() {
        String email = "thaiduy21082000@gmail.com";
        String password = "nguyenduythai";
        Properties propertie = new Properties();

        propertie.put("mail.smtp.auth", "true");
        propertie.put("mail.smtp.starttls.enable", "true");
        propertie.put("mail.smtp.host", "smtp.gmail.com");
        propertie.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(propertie, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
            message.setSubject("Order Success");
            message.setText("Your order has been success");
            message.setText("THanks you for chossing our Store");
            Transport.send(message);
        } catch (Exception e) {
            System.out.println("Sending email..."+e);
        }
    }

}
