package pl.bykowski.email_sender.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.bykowski.email_sender.mail.EmailSender;

import javax.mail.MessagingException;

@Aspect
@Component
public class MovieAspect {

    private final EmailSender emailSender;
    private final TemplateEngine templateEngine;

    public MovieAspect(EmailSender emailSender, TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }


    @After("@annotation(Movies)")
    private void sendEmail() throws MessagingException {
        Context context = new Context();
        context.setVariable("header", "Zadanie akademiaspring.pl Tydzień 6");
        context.setVariable("title", "Spring Boot – email - szablon i wysyłanie");
        context.setVariable("description", "Pomyślnie dodano nowy film");

        String body = templateEngine.process("email/template", context);
        emailSender.sendEmail("mailyouwantsendto@mail.com", "Email from App", body);
    }

}
