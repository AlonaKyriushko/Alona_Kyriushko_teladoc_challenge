package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.TablePage;
import utils.CommonMethods;

public class AddUserStep extends CommonMethods {

    @When("user click on Add user")
    public void user_click_on_add_user() {
        click(tablePage.addUser);
    }

    @When("enter {string}, {string},{string}, {string},{string},{string}, {string}, and {string}")
    public void enter_and(String firstName, String lastName, String UserName, String Password,
                          String Customer, String Role, String Email, String PhoneNumber) {
        sendText(tablePage.firstName, firstName);
        sendText(tablePage.lastName, lastName);
        sendText(tablePage.userName, UserName);
        sendText(tablePage.password, Password);
        selectDropdown(tablePage.role, Role);
        click(tablePage.companiesRadio);
        sendText(tablePage.email, Email);
        sendText(tablePage.phoneNumber, PhoneNumber);
    }

    @When("click on save")
    public void click_on_save() {
        jsClick(tablePage.saveButton);
    }

    @Then("user verify that {string} is added")
    public void user_verify_that_is_added(String userName) {
        for(WebElement a: tablePage.tableData){
            String actualTableData=a.getText();
            if(actualTableData.equals(userName)){
                Assert.assertEquals(userName, actualTableData);
            }
        }
    }


}
