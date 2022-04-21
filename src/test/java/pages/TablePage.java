package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class TablePage extends CommonMethods {
    /*
     * Using Page Object Model Design pattern I stored all the webElements of my page in the class,
     * and initialized it using constructor and PageFactory
     * */
    @FindBy(xpath = "//button[@class='btn btn-link pull-right']")
    public WebElement addUser;

    @FindBy(xpath = "//input[@name='FirstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='LastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='UserName']")
    public WebElement userName;

    @FindBy(xpath = "//input[@name='Password']")
    public WebElement password;

    @FindBy(xpath = "//input[@value='15']")
    public WebElement companiesRadio;

    @FindBy(xpath = "//select[@name='RoleId']")
    public WebElement role;

    @FindBy(xpath = "//input[@name='Email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='Mobilephone']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//table[@class='smart-table table table-striped']/tbody/tr/td")
    public List<WebElement> tableData;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searchTextBox;

    @FindBy(xpath = "//i[@class='icon icon-remove']")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement okButton;

    public TablePage() {
        PageFactory.initElements(driver, this);
    }


}
