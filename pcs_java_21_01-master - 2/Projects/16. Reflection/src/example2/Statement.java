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
public class Statement {
    private String name;
    private LocalDate birthDate;

    @DefaultValue("ООО Зеленоглазое такси")
    private String company;
    @DefaultValue("21312323")
    private String inn;

    public Statement(String name) {
        this.name = name;
    }

    public Statement(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCompany() {
        return company;
    }

    public String getInn() {
        return inn;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Statement.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("birthDate=" + birthDate)
                .add("company='" + company + "'")
                .add("inn='" + inn + "'")
                .toString();
    }
}
