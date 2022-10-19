package example2;

import example2.framework.DefaultValue;

import java.time.LocalDate;
import java.util.StringJoiner;

/**
 * 22.09.2021
 * 16. Reflection
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Act {
    private LocalDate date;
    private String name;
    private String description;

    @DefaultValue("ОБЭП")
    private String from;

    public Act(LocalDate date, String name, String description) {
        this.date = date;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Act.class.getSimpleName() + "[", "]")
                .add("date=" + date)
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("from='" + from + "'")
                .toString();
    }
}
