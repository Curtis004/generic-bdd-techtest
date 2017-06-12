package portaltech.test.acceptance;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
            "pretty",
            "json:target/cucumber/json/acceptance.json"
        },
        glue = {
            "portaltech.test.acceptance"
        },
        features = {
                "src/test/resources/portaltech/test/acceptance/API - All Countries.feature"
        }
)
public class APIAcceptanceTest {}
