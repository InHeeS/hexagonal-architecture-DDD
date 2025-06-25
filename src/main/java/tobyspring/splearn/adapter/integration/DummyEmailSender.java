package tobyspring.splearn.adapter.integration;

import org.springframework.context.annotation.Fallback;
import org.springframework.stereotype.Component;
import tobyspring.splearn.application.required.EmailSender;
import tobyspring.splearn.domain.Email;

@Component
@Fallback // Bean Last Primary
public class DummyEmailSender implements EmailSender {
    @Override
    public void send(Email email, String subject, String body) {
        System.out.println("dummy email = " + email);
    }
}
