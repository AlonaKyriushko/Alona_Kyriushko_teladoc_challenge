package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    // Hooks will run before and after each scenario

    @Before
    public void start() {
        openBrowserAndLaunchApplication();
    }

    @After
    public void end() {
        closeBrowser();
    }

}
