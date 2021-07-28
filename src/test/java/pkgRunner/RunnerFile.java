package pkgRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/home/MyBDDProj/CucumberInteg/TestCucu/myLogin.feature"}, glue = {
		"StepDefns" }, tags = "@tag2")

public class RunnerFile {

}
