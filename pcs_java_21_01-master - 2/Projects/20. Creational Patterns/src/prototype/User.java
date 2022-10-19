package prototype;

/**
 * 27.09.2021
 * 20. Creational Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class User implements Cloneable {

    public enum Role {
        USER, ANONYMOUS
    }

    public enum State {
        CONFIRMED, NOT_CONFIRMED;
    }

    private String email;
    private State state;
    private Role role;

    public User(String email) {
        this.email = email;
        this.state = State.NOT_CONFIRMED;
        this.role = Role.ANONYMOUS;
    }

    public void authorize() {
        this.role = Role.USER;
        this.state = State.CONFIRMED;
    }

    public boolean isAuthorized() {
        return this.role.equals(Role.USER) && this.state.equals(State.CONFIRMED);
    }

    public String getEmail() {
        return email;
    }

    public User clone() {
        User user = new User(this.email);
        user.state = this.state;
        user.role = this.role;
        return user;
    }
}
