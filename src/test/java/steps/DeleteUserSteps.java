package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class DeleteUserSteps extends CommonMethods {

    @When("user search {string}")
    public void user_search(String userName) {
        sendText(tablePage.searchTextBox, userName);
    }

    @When("click on delete user")
    public void click_on_delete_user() {
        click(tablePage.deleteButton);
        click(tablePage.okButton);
    }

    @Then("user verify that user with name {string} was deleted")
    public void user_verify_that_user_with_name_was_deleted(String userName) {
        for (WebElement t : tablePage.tableData) {
            String actualText = t.getText();
            if (actualText.equals(userName)) {
                Assert.fail();
            }
        }
    }
}
