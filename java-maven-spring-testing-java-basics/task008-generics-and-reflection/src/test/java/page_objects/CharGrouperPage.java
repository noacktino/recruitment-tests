package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Henning Gross
 */
public class CharGrouperPage {

    @FindBy(className = "input")
    private WebElement input;

    @FindBy(className = "submit")
    private WebElement submit;

    @FindBy(className = "output")
    private WebElement output;

    public void input(String message) {
        input.clear();
        input.sendKeys(message);
    }

    public void submit() {
        submit.click();
    }

    public String output() {
        return output.getText();
    }
}
