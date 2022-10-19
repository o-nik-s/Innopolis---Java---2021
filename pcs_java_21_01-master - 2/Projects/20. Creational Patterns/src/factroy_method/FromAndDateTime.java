package factroy_method;

import java.time.LocalDateTime;

/**
 * 27.09.2021
 * 20. Creational Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class FromAndDateTime implements Information {
    private String from;
    private LocalDateTime dateTime;

    public FromAndDateTime(String from, LocalDateTime dateTime) {
        this.from = from;
        this.dateTime = dateTime;
    }

    public String getFrom() {
        return from;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
