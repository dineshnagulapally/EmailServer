package com.example.email;

import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@RestController
public class EmailController {
    @RequestMapping(value = "/sendemail",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public String sendEmail(@RequestBody EmailTo list)
            throws AddressException, MessagingException, IOException {
        sendmail(list.getFrom(),list.getTo());
        return "Email Sent";
    }

    private void sendmail(String from, List<String> toList) throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "ohoplearcbdrlzio");
            }
        });
        System.out.println("after password");
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(from, false));
        String[] address= {"dineshnagulapally@gmail.com"};
        List<String> names = Arrays.asList("Dinesh");
        //String[] names = {"Katy","Craig","Shannon","Tim","Kim","Adam","Steve","Nancy","Erin","Kevin","Nicole","Jessica","Tom","Amy","Orlando","Matt","Grace","Patricia","Neyle","Kaitlyn","Samantha","Nicole","Jasmine","Kathryn","Caitlin","Kayla","Shuaib","Teylour","Mark","Chelsea","Lyndsay","Jason","Emilee","Cami","Arjun","Joe","Kate","Adam","Lisa","Jessica","Yui","Matt","Luke","Brittany","Tom","Leila","Alex","Tom","Kolbe","Melissa","Ghazal","Jesse","Lawrence","Rebecca","James","Alexa","Stacey","Gretchen","Yuliya","Amy","Melissa"};
        for (int i=0;i<address.length;i++) {
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address[i]));
            msg.setSubject("Full Stack Java Developer || Looking for C2C Position");
            String body = "Hi "+names.get(i)+"\n";
            body+= "\n"+"This is Dinesh and I am a Full Stack Java Developer, currently in the market and looking for new roles. I would like to know if you have any open C2C/C2H opportunities. If yes, I would like to have a conversation with you and elaborate my experience and skill-set. Looking forward to hearing from you."+"\n";
           body+="PFA my resume for reference"+"\n";
           body+= "\n"+"Thanks"+"\n";
           body+= "Dinesh N"+"\n";
           body += "940-464-5090";
            msg.setContent(body, "text/plain");
            msg.setSentDate(new Date());

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            messageBodyPart.setContent(body, "text/plain");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            MimeBodyPart attachPart = new MimeBodyPart();
            attachPart.attachFile("C:\\Users\\dines\\Desktop\\Dinesh_Resume.pdf");
            multipart.addBodyPart(attachPart);
            msg.setContent(multipart);
            Transport.send(msg);
        }

    }
}
