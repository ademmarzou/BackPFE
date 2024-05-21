package com.pfe.HRS.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class EmailService {
    @Autowired
    private final JavaMailSender mailSender ;
    @Autowired
    private final SpringTemplateEngine templateEngine ;

    @Async
    public void sendEmail ( String to , String username , EmailTemplateName emailTemplate , String confirmationUrl , String activationCode , String subject) throws MessagingException {
        String templatename;
        if (emailTemplate == null) {
            templatename= "confirm-email" ;
        }else {
            templatename = emailTemplate.name() ;
        }

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper( mimeMessage , MimeMessageHelper.MULTIPART_MODE_MIXED , StandardCharsets.UTF_8.name());

        Map<String ,Object> propreties = new HashMap<>();
        propreties.put("username" ,username) ;
        propreties.put("confirmationUrl" ,confirmationUrl);
        propreties.put("activation_code",activationCode);

        Context context = new Context();
        context.setVariables(propreties);

        helper.setFrom(to);
        helper.setTo("HRStunisie@gmail.com");
        helper.setSubject(subject);

        String template = templateEngine.process(templatename , context);

        helper.setText(template ,true);
        mailSender.send(mimeMessage);



    }


}
