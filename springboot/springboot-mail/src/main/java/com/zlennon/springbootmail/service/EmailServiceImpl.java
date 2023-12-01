package com.zlennon.springbootmail.service;

import com.zlennon.springbootmail.domain.MailObject;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.File;
import java.util.Arrays;
import java.util.Map;

@Component
public class EmailServiceImpl implements EmailService {

    private static final String NOREPLY_ADDRESS = "zl1172_2011@163.com";
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine thymeleafTemplateEngine;

    @Autowired
    private SimpleMailMessage template;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("zl1172_2011@163.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendMessageWithAttachment(MailObject mailObject, String pathToAttachment) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(mailObject.getFrom());
        helper.setTo(mailObject.getTo());
        helper.setSubject(mailObject.getSubject());
        helper.setText(mailObject.getText());
        File file= new File(pathToAttachment);

        if(file.isDirectory()){
            Arrays.stream(file.listFiles()).forEach(f->{
                try {
                    helper.addAttachment(f.getName(), f);
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }

            });
        }
        emailSender.send(message);
    }

    @Override
    public void sendSimpleMessageUsingTemplate(String to,
                                               String subject,
                                               String ...templateModel) {
        String text = String.format(template.getText(), templateModel);
        sendSimpleMessage(to, subject, text);
    }

    @Override
    public void sendMessageUsingThymeleafTemplate(
            String to, String subject, Map<String, Object> templateModel)
            throws MessagingException {

        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(templateModel);

        String htmlBody = thymeleafTemplateEngine.process("mail.html", thymeleafContext);

        sendHtmlMessage(to, subject, htmlBody);
    }


    private void sendHtmlMessage(String to, String subject, String htmlBody) throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(NOREPLY_ADDRESS);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        helper.addInline("attachment.png", new File("/Users/zlennon/development/test/attachment/a.png"));
        emailSender.send(message);
    }

}