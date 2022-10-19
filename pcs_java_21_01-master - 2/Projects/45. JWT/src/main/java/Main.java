import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.LocalDate;
import java.util.Date;

/**
 * 15.11.2021
 * 45. JWT
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Account account = Account.builder()
                .email("sidikov.marsel@gmail")
                .id(10L)
                .firstName("Marsel")
                .lastName("Sidikov")
                .role(Account.Role.ADMIN)
                .state(Account.State.CONFIRMED)
                .password("$2a$10$sEu.aBYqS/VmnyXpx6IRCO6vu5HdcbgwfKYNqgjduwcACPUpVRcXu")
                .build();

        String token = JWT.create()
                .withSubject(account.getId().toString())
                .withClaim("email", account.getEmail())
                .withClaim("role", account.getRole().toString())
                .withClaim("state", account.getState().toString())
                .sign(Algorithm.HMAC256("secret_key_34231"));

        System.out.println(token);
    }
}
