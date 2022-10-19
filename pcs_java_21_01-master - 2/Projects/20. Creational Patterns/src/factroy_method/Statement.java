package factroy_method;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 27.09.2021
 * 20. Creational Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Statement implements Document {

    private LocalDateTime dateTime;
    private String from;

    public Statement(LocalDateTime dateTime, String from) {
        this.dateTime = dateTime;
        this.from = from;
    }

    @Override
    public String getType() {
        return "STATEMENT";
    }

    @Override
    public String getFrom() {
        return from;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return getType() + "[" + getFrom() + ", " + getDateTime() + "]";
    }
}
