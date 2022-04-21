package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features I use to provide the path of all the feature files
        features = "src/test/resources/features/",
        //glue is where I find implementations for gherkin steps
        //I provide the path of package where I defined all the steps
        glue = "steps",
        /*if I set it to true, it will quickly scan all gherkin steps whether they are implemented or not
        if it is set to true, it stops actual execution
        to execute script, it should be set to false*/
        dryRun = false,
        //when it set to true, it simply removes all the irrelevant information from the console
        monochrome = true,
        //tags will identify the scenario based on the tag I provided to the feature file
        tags = "@task",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}

)
public class TaskRunner {

}
