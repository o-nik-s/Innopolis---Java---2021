import examples.method_reference.StringOperation;
import examples.method_reference.TextField;
import examples.method_reference.TextProcessor;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        TextField textField = new TextField();

        TextProcessor textProcessor = new TextProcessor(LocalDate.now().toString(), LocalTime.now().toString());
//        StringOperation replacer = TextProcessor::process;
        StringOperation withDateTime = textProcessor::processWithPrefixAndSuffix;

        textField.input("Привет", TextProcessor::process);
        textField.input("Привет как дела?", withDateTime);

        System.out.println(textField.getText());
    }
}
