package examples.anonymous.example1;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TextFieldAlwaysLowerCase extends TextField {
    @Override
    public void onAfterInput() {
        this.text = this.text.toLowerCase();
    }

    @Override
    public void onBeforeClear() {

    }
}
