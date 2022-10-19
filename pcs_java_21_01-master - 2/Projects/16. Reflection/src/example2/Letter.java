package example2;

import example2.framework.DefaultValue;

import java.time.LocalTime;
import java.util.StringJoiner;

/**
 * 22.09.2021
 * 16. Reflection
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Letter {
    @DefaultValue("sidikov.marsel@gmail.com")
    private String to;
    private LocalTime time;

    public Letter(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Letter.class.getSimpleName() + "[", "]")
                .add("to='" + to + "'")
                .add("time=" + time)
                .toString();
    }
}
