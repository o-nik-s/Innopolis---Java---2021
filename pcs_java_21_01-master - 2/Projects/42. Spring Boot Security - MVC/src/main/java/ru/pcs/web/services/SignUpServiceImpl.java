package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.pcs.web.dto.SignUpForm;
import ru.pcs.web.models.Account;
import ru.pcs.web.repositories.AccountsRepository;

import javax.mail.internet.MimeMessage;
import java.util.Locale;

/**
 * 18.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    private final AccountsRepository accountsRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpForm form) {
        Account account = Account.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail().toLowerCase(Locale.ROOT))
                .password(passwordEncoder.encode(form.getPassword()))
                .role(Account.Role.USER)
                .state(Account.State.NOT_CONFIRMED)
                .build();

        sendMail("<h1>Вы зарегистрированы</h1>", "Регистрация", from, account.getEmail());

        accountsRepository.save(account);
    }

    private void sendMail(String text, String subject, String from, String to) {
        MimeMessagePreparator preparator = mimeMessage -> {
          MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
          messageHelper.setText(text, true);
          messageHelper.setTo(to);
          messageHelper.setFrom(from);
          messageHelper.setSubject(subject);
        };

        mailSender.send(preparator);
    }
}
