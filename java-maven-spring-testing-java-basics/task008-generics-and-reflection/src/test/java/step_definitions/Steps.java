package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import page_objects.CharGrouperPage;

import static org.junit.Assert.assertEquals;

/**
 * @author Henning Gross
 */
public class Steps {

    private WebDriver webDriver = new FirefoxDriver();

    private CharGrouperPage charGrouperPage;

    @When("^I load the chargroup-page$")
    public void I_load_the_chargroup_page() throws Throwable {

        webDriver.get("http://localhost:8080/");

        charGrouperPage = PageFactory.initElements(webDriver, CharGrouperPage.class);
    }

    @And("^I enter a simple text in the input field$")
    public void I_enter_a_simple_text_in_the_input_field() throws Throwable {

        charGrouperPage.input("abzuaaissna");
    }

    @And("^I hit the group-button$")
    public void I_hit_the_group_button() throws Throwable {

        charGrouperPage.submit();
    }

    @Then("^I should see the correct output$")
    public void I_should_see_the_correct_output() throws Throwable {

        String output = charGrouperPage.output();
        assertEquals("a4bins2uz", output);
    }
}
