package task;

import java.time.LocalDate;

/**
 * 31.10.2021
 * 10. Abstract Classes And Interfaces
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Statement implements Document {

    private LocalDate createdDate;
    private String text;
    private String from;
    private String to;

    public Statement(LocalDate createdDate, String text, String from, String to) {
        this.createdDate = createdDate;
        this.text = text;
        this.from = from;
        this.to = to;
    }

    @Override
    public String getText() {
        return "От " + from + " к " + to + " Заявление: " + text;
    }

    @Override
    public LocalDate getCreateDate() {
        return createdDate;
    }
}
