import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Scanner;

/**
 * 15.11.2021
 * 45. JWT
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String token = scanner.nextLine();

        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("secret_key_34231"))
                    .build().verify(token);

            System.out.println(decodedJWT.getClaim("role"));
            System.out.println(decodedJWT.getClaim("email"));
            System.out.println(decodedJWT.getClaim("state"));
        } catch (JWTVerificationException e) {
            System.err.println("Неверный токен");
        }
    }
}
