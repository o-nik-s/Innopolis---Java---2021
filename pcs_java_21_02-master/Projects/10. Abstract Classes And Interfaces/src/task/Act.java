package task;

import java.time.LocalDate;

/**
 * 31.10.2021
 * 10. Abstract Classes And Interfaces
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Act implements Document {
    private LocalDate createdDate;
    private String text;

    public Act(String text) {
        this.createdDate = LocalDate.now();
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public LocalDate getCreateDate() {
        return createdDate;
    }
}
