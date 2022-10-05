package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/cart.feature", "src/main/resources/checkout.feature",
                "src/main/resources/navigation.feature", "src/main/resources/search.feature",
                "src/main/resources/signIn.feature", "src/main/resources/watchlist.feature"},
        glue = "stepdefinitions"
)

public class RunnerTests {
}
