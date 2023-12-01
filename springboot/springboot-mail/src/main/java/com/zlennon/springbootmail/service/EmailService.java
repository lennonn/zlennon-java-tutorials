package com.zlennon.springbootmail.service;

import com.zlennon.springbootmail.domain.MailObject;
import jakarta.mail.MessagingException;

import java.io.IOException;
import java.util.Map;

public interface EmailService {
    default void sendSimpleMessage(String to,
                                   String subject,
                                   String text) {

    }

    default void sendSimpleMessageUsingTemplate(String to,
                                                String subject,
                                                String... templateModel) {

    }

    default void sendMessageWithAttachment(MailObject mailObject,
                                           String pathToAttachment) throws MessagingException {

    }

    default void sendMessageUsingThymeleafTemplate(String to,
                                                   String subject,
                                                   Map<String, Object> templateModel)
            throws IOException, MessagingException {

    }

    default void sendMessageUsingFreemarkerTemplate(String to,
                                                    String subject,
                                                    Map<String, Object> templateModel)
            throws IOException, MessagingException {

    }
}
