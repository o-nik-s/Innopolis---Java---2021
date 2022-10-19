package proxy;

/**
 * 27.09.2021
 * 21. Structural Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UserServiceProxy extends UserService {

    private After after;
    private Before before;
    private Instead instead;

    private UserService userService;

    public void setAfter(After after) {
        this.after = after;
    }

    public void setBefore(Before before) {
        this.before = before;
    }

    public void setInstead(Instead instead) {
        this.instead = instead;
    }

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void signUp(String email, String password) {
        if (before != null) {
            before.before();
        }
        if (instead != null) {
            instead.instead();
        } else {
            userService.signUp(email, password);
        }

        if (after != null) {
            after.after();
        }
    }
}
