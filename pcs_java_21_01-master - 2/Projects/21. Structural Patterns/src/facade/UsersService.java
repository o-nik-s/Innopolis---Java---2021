package facade;

/**
 * 27.09.2021
 * 21. Structural Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersService {
    private EmailAndPasswordValidator validator;
    private UsersRepository usersRepository;
    private EmailSender emailSender;

    public UsersService(EmailAndPasswordValidator validator, UsersRepository usersRepository, EmailSender emailSender) {
        this.validator = validator;
        this.usersRepository = usersRepository;
        this.emailSender = emailSender;
    }

    public void signUp(String email, String password) {
        validator.validate(email, password);
        usersRepository.save(new User(email, password));
        emailSender.sendConfirmMessage(email, "Подтверждение регистрации!");
    }
}
